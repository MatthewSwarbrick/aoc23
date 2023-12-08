fun main() {
    part1()
}

private fun part1() {
    val result = input
        .toMaps()
        .getStepsToZ()

    println("Part 1 | Answer: $result")
}

private fun List<String>.toMaps(): Maps {
    val sequence = this.first().map {
        if (it == 'R') {
            Direction.RIGHT
        } else {
            Direction.LEFT
        }
    }

    val leftNodes = this.drop(2).associate {
        val nodeParts = it.split(" = ")
        val nodeId = nodeParts[0].trim()
        nodeId to nodeParts[1].split(",")[0].trim('(')
    }

    val rightNodes = this.drop(2).associate {
        val nodeParts = it.split(" = ")
        val nodeId = nodeParts[0].trim()
        nodeId to nodeParts[1].split(",")[1].trim().trim(')')
    }
    return Maps(sequence, leftNodes, rightNodes)
}

private fun Maps.getStepsToZ(): Int {
    var currentNodeId = "AAA"
    var currentSteps = 0
    while(currentNodeId != "ZZZ") {
       this.sequence.forEach { direction ->
           currentNodeId = when(direction) {
               Direction.LEFT -> this.leftNodes[currentNodeId]!!
               Direction.RIGHT -> this.rightNodes[currentNodeId]!!
           }
           currentSteps++
           if(currentNodeId == "ZZZ") {
               return currentSteps
           }
       }
    }

    return currentSteps
}

data class Maps(val sequence: List<Direction>, val leftNodes: Map<String, String>, val rightNodes: Map<String, String>)

enum class Direction {
    LEFT,
    RIGHT
}