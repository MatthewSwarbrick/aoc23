fun main() {
    part1()
}

private fun part1() {
    val result = input
        .toWorkflowsAndParts()
        .toAcceptedParts()
        .sumOf { part -> part.components.sumOf { it.value } }

    println("Part 1 | Answer: $result")
}

private fun List<String>.toWorkflowsAndParts(): Pair<Map<String, Workflow>, List<Part>> {
    val workflowStrings = this.takeWhile { it.isNotEmpty() }
    val partStrings = this.drop(workflowStrings.size + 1)

    val workflows = workflowStrings.map { workflowString ->
        val label = workflowString.split("{")[0]
        val conditionParts = workflowString.removePrefix("${label}{").removeSuffix("}").split(",")
        val lastFalseWorkflowLabel = conditionParts.last()
        val conditions = conditionParts.dropLast(1).map { conditionString ->
            val conditionParts = conditionString.split(":")
            val trueWorkflowLabel = conditionParts.last()
            if(conditionParts[0].contains(">")) {
                val parts = conditionParts[0].split(">")
                Condition(parts[0], ConditionOperator.GREATER_THAN, parts[1].toInt(), trueWorkflowLabel)
            } else {
                val parts = conditionParts[0].split("<")
                Condition(parts[0], ConditionOperator.LESS_THAN, parts[1].toInt(), trueWorkflowLabel)
            }
        }

        Workflow(label, conditions.mapIndexed { index, condition  ->
            if(index == conditions.lastIndex) {
                condition.copy(falseWorkflowLabel = lastFalseWorkflowLabel)
            } else {
                condition
            }
        })
    }

    val parts = partStrings.map { partString ->
        val components = partString.removePrefix("{").removeSuffix("}").split(",")
            .map {
                val partParts = it.split("=")
                PartComponent(partParts[0], partParts[1].toInt())
            }

        Part(components)
    }

    return workflows.associateBy { it.label } to parts
}

private fun Pair<Map<String, Workflow>, List<Part>>.toAcceptedParts(): List<Part> {
    val (workflowMap, parts) = this
    return parts.filter { part ->
        val inRule = workflowMap["in"]!!
        var result = inRule.evaluate(part)
        while(result.accepted != true && result.rejected != true) {
            val nextRuleToRun = result.nextWorkflowLabelToRun
            if(nextRuleToRun != null) {
                result = workflowMap[nextRuleToRun]!!.evaluate(part)
            }
        }

        result.accepted == true
    }
}

private fun Workflow.evaluate(part: Part): WorkflowResult {
    this.conditions.forEach { condition ->
        if(condition.evaluate(part)) {
            val isAccepted = condition.trueWorkflowLabel == "A"
            val isRejected = condition.trueWorkflowLabel == "R"
            val nextWorkflowLabel = if(!isAccepted && !isRejected) {
                condition.trueWorkflowLabel
            } else null
            return WorkflowResult(
                accepted = isAccepted,
                rejected = isRejected,
                nextWorkflowLabelToRun = nextWorkflowLabel
            )
        } else {
            if(condition.falseWorkflowLabel != null) {
                val isAccepted = condition.falseWorkflowLabel == "A"
                val isRejected = condition.falseWorkflowLabel == "R"
                val nextWorkflowLabel = if(!isAccepted && !isRejected) {
                    condition.falseWorkflowLabel
                } else null
                return WorkflowResult(
                    accepted = isAccepted,
                    rejected = isRejected,
                    nextWorkflowLabelToRun = nextWorkflowLabel
                )
            }
        }
    }

    throw Error("No condition found")
}

private fun Condition.evaluate(part: Part): Boolean {
    val partComponent = part.components.first { it.label == this.componentLabel }
    return when(this.operator) {
        ConditionOperator.GREATER_THAN -> partComponent.value > this.value
        ConditionOperator.LESS_THAN -> partComponent.value < this.value
    }
}

data class Workflow(val label: String, val conditions: List<Condition>)
data class WorkflowResult(val nextWorkflowLabelToRun: String?, val accepted: Boolean?, val rejected: Boolean?)
data class Part(val components: List<PartComponent>)
data class PartComponent(val label: String, val value: Int)
data class Condition(val componentLabel: String, val operator: ConditionOperator, val value: Int, val trueWorkflowLabel: String,  val falseWorkflowLabel: String? = null)
enum class ConditionOperator {
    GREATER_THAN, LESS_THAN
}