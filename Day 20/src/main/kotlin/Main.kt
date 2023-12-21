fun main() {
    part1()
}

private fun part1() {
    val result = input
        .toModules()
        .pressButton(1000)

    println("Part 1 | Answer: $result")
}

private fun List<String>.toModules(): List<Module> {
    val modules = this.map { moduleString ->
        val modulePaths = moduleString.split("->")
        val destinationModules = modulePaths[1].split(",").map { it.trim() }
        val moduleLabelPart = modulePaths[0].trim()

        when {
            moduleLabelPart == "broadcaster" -> Module.Broadcaster(destinationModuleLabels = destinationModules)
            moduleLabelPart.startsWith("%") -> Module.FlipFlop(
                moduleLabelPart.removePrefix("%").trim(),
                destinationModules
            )

            moduleLabelPart.startsWith("&") -> Module.Conjunction(
                moduleLabelPart.removePrefix("&").trim(),
                destinationModules
            )

            else -> throw Error("Invalid module input encountered")
        }
    }

    return modules.map { moduleToUpdate ->
        if (moduleToUpdate !is Module.Conjunction) {
            moduleToUpdate
        } else {
            val inputLabelsToModule = modules
                .filter { inputModule ->
                    inputModule.destinationModuleLabels.any { it == moduleToUpdate.label }
                }
                .map { it.label }
            moduleToUpdate.copy(previousPulses = inputLabelsToModule.associateWith { Pulse.LOW }.toMutableMap())
        }
    }
}

private fun List<Module>.pressButton(times: Int): Long {
    var totalLowPulses = 0L;
    var totalHighPulses = 0L
    repeat(times) {
        val initialBroadcast = Pulse.LOW to this.firstOrNull { it is Module.Broadcaster }
        val modulesToActions = mutableListOf(initialBroadcast)

        while (modulesToActions.isNotEmpty()) {
            val (pulse, module) = modulesToActions.removeFirst()
            when (pulse) {
                Pulse.HIGH -> totalHighPulses++
                Pulse.LOW -> totalLowPulses++
            }

            if (module == null) {
                continue
            }

            when (module) {
                is Module.Broadcaster -> module.destinationModuleLabels.forEach { destModuleLabel ->
                    val conjunctionModule =
                        this.filterIsInstance<Module.Conjunction>().firstOrNull { it.label == destModuleLabel }
                    if (conjunctionModule != null) {
                        conjunctionModule.previousPulses[module.label] = pulse
                    }

                    modulesToActions.add(pulse to this.firstOrNull { it.label == destModuleLabel })
                }

                is Module.Conjunction -> {
                    val pulseToSend =
                        if (module.previousPulses.isNotEmpty() && module.previousPulses.all { it.value == Pulse.HIGH }) Pulse.LOW else Pulse.HIGH
                    module.destinationModuleLabels.forEach { destModuleLabel ->
                        val conjunctionModule =
                            this.filterIsInstance<Module.Conjunction>().firstOrNull { it.label == destModuleLabel }
                        if (conjunctionModule != null) {
                            conjunctionModule.previousPulses[module.label] = pulseToSend
                        }

                        modulesToActions.add(pulseToSend to this.firstOrNull { it.label == destModuleLabel })
                    }

                }

                is Module.FlipFlop -> {
                    if (pulse == Pulse.HIGH) continue
                    val pulseToSend = if (module.isOn) {
                        Pulse.LOW
                    } else {
                        Pulse.HIGH
                    }
                    module.isOn = !module.isOn
                    module.destinationModuleLabels.forEach { destModuleLabel ->
                        val conjunctionModule =
                            this.filterIsInstance<Module.Conjunction>().firstOrNull { it.label == destModuleLabel }
                        if (conjunctionModule != null) {
                            conjunctionModule.previousPulses[module.label] = pulseToSend
                        }

                        modulesToActions.add(pulseToSend to this.firstOrNull { it.label == destModuleLabel })
                    }
                }
            }
        }
    }

    return totalHighPulses * totalLowPulses
}

sealed class Module {
    abstract val label: String
    abstract val destinationModuleLabels: List<String>

    data class FlipFlop(
        override val label: String,
        override val destinationModuleLabels: List<String>,
        var isOn: Boolean = false
    ) :
        Module()

    data class Broadcaster(
        override val label: String = "broadcaster",
        override val destinationModuleLabels: List<String>
    ) : Module()

    data class Conjunction(
        override val label: String,
        override val destinationModuleLabels: List<String>,
        val previousPulses: MutableMap<String, Pulse> = mutableMapOf()
    ) : Module()
}

enum class Pulse {
    HIGH, LOW
}