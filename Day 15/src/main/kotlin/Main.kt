fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toHashSequence()
        .toHashes()
        .sum()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toLabels()
        .toBoxes()
        .toTotalFocusingPower()

    println("Part 2 | Answer: $result")
}

private fun String.toHashSequence(): List<List<Int>> =
    this.split(',').map { stringToHash ->
        stringToHash.toAsciiCode()
    }

private fun String.toAsciiCode() =
    this.map { it.code }

private fun String.toLabels(): List<Label> =
    this.split(',')
        .map { fullLabel ->
            if (fullLabel.contains("=")) {
                val labelParts = fullLabel.split("=")
                Label(labelParts[0], operator = Operator.EQUAL, focalLength = labelParts[1].toInt())
            } else {
                Label(fullLabel.dropLast(1), operator = Operator.MINUS)
            }
        }

private fun List<List<Int>>.toHashes(): List<Int> =
    this.map {
        it.toHash()
    }

private fun List<Int>.toHash(): Int =
    this.fold(initial = 0) { acc, code ->
        var newValue = acc + code
        newValue *= 17
        newValue %= 256
        newValue
    }

private fun List<Label>.toBoxes(): Map<Int, Box> {
    val initialBoxes = (0 until 256).associateWith { index -> Box(mutableMapOf(), index) }.toMutableMap()
    return this.fold(initialBoxes) { currentBoxes, label ->
        when (label.operator) {
            Operator.EQUAL -> {
                val boxToUpdate = currentBoxes[label.hash]!!
                boxToUpdate.labels[label.rawValue] = label
                currentBoxes[boxToUpdate.index] = boxToUpdate
                currentBoxes
            }

            Operator.MINUS -> {
                val boxToUpdate = currentBoxes[label.hash]!!
                boxToUpdate.labels.remove(label.rawValue)
                currentBoxes[boxToUpdate.index] = boxToUpdate
                currentBoxes
            }
        }
    }
}

private fun Map<Int, Box>.toTotalFocusingPower(): Int =
    this.map { (_, box) ->
        val boxNumber = 1 + box.index
        box.labels.values.mapIndexed { labelIndex, label ->
            val slotNumber = labelIndex + 1
            boxNumber * slotNumber * label.focalLength
        }.sum()
    }.sum()

data class Label(
    val rawValue: String,
    val hash: Int = rawValue.toAsciiCode().toHash(),
    val operator: Operator,
    val focalLength: Int = 0
)

data class Box(val labels: MutableMap<String, Label>, val index: Int)
enum class Operator {
    EQUAL,
    MINUS
}