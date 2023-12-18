import java.util.PriorityQueue

const val MAX_LINE_LENGTH = 3

fun main() {
    part1()
}

private fun part1() {
    val result = input
        .toCityBlocks()
        .toLowestHeatLossPath()

    println("Part 1 | Answer: $result")
}

private fun List<String>.toCityBlocks(): List<CityBlock> =
    this.flatMapIndexed { y, row ->
        row.mapIndexed { x, heatLoss ->
            val coordinate = Coordinate(x, y)
            CityBlock(coordinate, heatLoss.digitToInt())
        }
    }

private fun List<CityBlock>.toLowestHeatLossPath(): Int {
    val startBlock = this.first()
    val endCoord = this.last().coordinate
    val visited = mutableMapOf<Coordinate, MutableMap<Pair<DirectionOfTravel, Int>, Int>>()
    val queue = PriorityQueue(compareBy<LowestHeatLossState> { it.totalHeatLoss })

    listOf(DirectionOfTravel.DOWN, DirectionOfTravel.RIGHT).forEach { dir ->
        startBlock.coordinate.let { coord ->
            val nextCoord = dir.move(coord)
            this.find { it.coordinate == nextCoord }?.let { nextBlock ->
                queue.add(LowestHeatLossState(nextBlock, dir, 1, nextBlock.heatLoss))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val (currentBlock, currentDirection, currentStraightLength, currentTotalHeatLoss) = queue.poll()
        val currentCoord = currentBlock.coordinate
        val currentKey = Pair(currentDirection, currentStraightLength)

        if (currentTotalHeatLoss < (visited[currentCoord]?.get(currentKey) ?: Int.MAX_VALUE)) {
            visited.getOrPut(currentCoord) { mutableMapOf() }[currentKey] = currentTotalHeatLoss

            if (currentCoord != endCoord) {
                DirectionOfTravel.values().forEach { newDirection ->
                    if (newDirection == currentDirection || newDirection != currentDirection.toOpposite()) {
                        val newStraightLength = if (newDirection == currentDirection) {
                            currentStraightLength + 1
                        } else {
                            1
                        }

                        if (newStraightLength <= MAX_LINE_LENGTH) {
                            val nextCoord = newDirection.move(currentCoord)
                            this.firstOrNull { it.coordinate == nextCoord }?.let { nextBlock ->
                                val newTotalHeatLoss = currentTotalHeatLoss + nextBlock.heatLoss
                                val nextState = LowestHeatLossState(nextBlock, newDirection, newStraightLength, newTotalHeatLoss)
                                queue.add(nextState)
                            }
                        }
                    }
                }
            }
        }
    }

    return visited[endCoord]?.values?.minOrNull() ?: throw Error("Could not find path")
}

private fun DirectionOfTravel.move(coord: Coordinate): Coordinate = when (this) {
    DirectionOfTravel.UP -> coord.copy(y = coord.y - 1)
    DirectionOfTravel.DOWN -> coord.copy(y = coord.y + 1)
    DirectionOfTravel.LEFT -> coord.copy(x = coord.x - 1)
    DirectionOfTravel.RIGHT -> coord.copy(x = coord.x + 1)
}

data class Coordinate(val x: Int, val y: Int)
data class CityBlock(val coordinate: Coordinate, val heatLoss: Int)
data class LowestHeatLossState(val cityBlock: CityBlock, val directionOfTravel: DirectionOfTravel, val currentStraightLineLength: Int, val totalHeatLoss: Int)
enum class DirectionOfTravel {
    UP, DOWN, RIGHT, LEFT;

    fun toOpposite() = when (this) {
        UP -> DOWN
        LEFT -> RIGHT
        DOWN -> UP
        RIGHT -> LEFT
    }
}