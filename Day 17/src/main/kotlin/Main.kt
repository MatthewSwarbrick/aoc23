import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

const val MAX_LINE_LENGTH = 3

fun main() {
    part1()
}

var currentLowestHeatLoss = Int.MAX_VALUE
val currentHeatLosses: MutableMap<Pair<CityBlock, DirectionOfTravel>, Int> = mutableMapOf()

private fun part1() {
    val result = sample
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
    val startBlock = this.first { it.coordinate.x == 0 && it.coordinate.y == 0 }
    traverseAllPaths(startBlock, this)

    val endBlock = this.getLastBlock()
    return currentHeatLosses.entries.filter { it.key.first == endBlock }.minOf { it.value }
}

var stackCount = 200
var hasArbitraryMaxStackCount = false
private fun traverseAllPaths(startBlock: CityBlock, cityBlocks: List<CityBlock>) {
    val lastBlock = cityBlocks.getLastBlock()
    val stack = mutableListOf<CityBlockWithDirectionOfTravel>()
    val startCityBlocks = startBlock.coordinate.getNextCityBlocks(cityBlocks, null, 0)
        .sortedBy {
            it.cityBlock.getDistanceTo(lastBlock)
        }

    startCityBlocks.forEach {
        currentHeatLosses[it.cityBlock to it.directionOfTravel] = it.cityBlock.heatLossValue
    }

    stack.addAll(startCityBlocks)
    while (stack.isNotEmpty()) {
        if(stack.size > 210) {
            hasArbitraryMaxStackCount = true
        }

        if(hasArbitraryMaxStackCount) {
            val newStackCount = stack.size
            if(newStackCount < stackCount) {
                stackCount = newStackCount
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                println("${LocalDateTime.now().format(formatter)} | New stack count: $stackCount. Current lowest heat loss: $currentLowestHeatLoss")
            }
        }

        val (currentCityBlock, currentDirectionOfTravel, currentLongestStraightLine) = stack.removeLast()
        val currentHeatLoss = currentHeatLosses[currentCityBlock to currentDirectionOfTravel]!!

        val nextCityBlocks = currentCityBlock.coordinate.getNextCityBlocks(
            cityBlocks,
            currentDirectionOfTravel,
            currentLongestStraightLine
        )
            .sortedBy {
                it.cityBlock.getDistanceTo(lastBlock)
            }

        nextCityBlocks.forEach { (nextCityBlock, nextDirectionOfTravel, nextLongestStraightLine) ->
            val existingHeatLossForNextCityBlock = currentHeatLosses[nextCityBlock to nextDirectionOfTravel]
            val newTotalHeatLoss = if (nextCityBlock == cityBlocks.getLastBlock()) {
                currentHeatLoss
            } else {
                currentHeatLoss + nextCityBlock.heatLossValue
            }

            if(newTotalHeatLoss > currentLowestHeatLoss) return@forEach

            if (existingHeatLossForNextCityBlock == null) {
                currentHeatLosses[nextCityBlock to nextDirectionOfTravel] = newTotalHeatLoss
                stack.add(CityBlockWithDirectionOfTravel(nextCityBlock, nextDirectionOfTravel, nextLongestStraightLine))
            } else {
                if(newTotalHeatLoss < existingHeatLossForNextCityBlock) {
                    currentHeatLosses[nextCityBlock to nextDirectionOfTravel] = newTotalHeatLoss
                    stack.add(CityBlockWithDirectionOfTravel(nextCityBlock, nextDirectionOfTravel, nextLongestStraightLine))

                    if(nextCityBlock == cityBlocks.getLastBlock() && newTotalHeatLoss < currentLowestHeatLoss) {
                        currentLowestHeatLoss = newTotalHeatLoss
                    }
                }
            }
        }
    }
}

private fun Coordinate.getNextCityBlocks(
    allCityBlocks: List<CityBlock>,
    currentDirectionOfTravel: DirectionOfTravel?,
    currentLongestStraightLineLength: Int
): List<CityBlockWithDirectionOfTravel> =
    if (currentDirectionOfTravel == null) {
        val blockToRight = allCityBlocks.first { it.coordinate == this.getRightBlockCoord() }
        val blockToBottom = allCityBlocks.first { it.coordinate == this.getDownBlockCoord() }
        listOf(
            CityBlockWithDirectionOfTravel(blockToRight, DirectionOfTravel.RIGHT, 1),
            CityBlockWithDirectionOfTravel(blockToBottom, DirectionOfTravel.DOWN, 1)
        )
    } else {
        val nextBlocks = mutableListOf<CityBlockWithDirectionOfTravel>()
        when (currentDirectionOfTravel) {
            DirectionOfTravel.UP -> {
                if (currentLongestStraightLineLength < MAX_LINE_LENGTH) {
                    allCityBlocks.firstOrNull { it.coordinate == this.getUpBlockCoord() }
                        ?.let {
                            nextBlocks.add(
                                CityBlockWithDirectionOfTravel(
                                    it,
                                    DirectionOfTravel.UP,
                                    currentLongestStraightLineLength + 1
                                )
                            )
                        }
                }

                allCityBlocks.firstOrNull { it.coordinate == this.getLeftBlockCoord() }
                    ?.let {
                        nextBlocks.add(
                            CityBlockWithDirectionOfTravel(
                                it, DirectionOfTravel.LEFT, 1
                            )
                        )
                    }
                allCityBlocks.firstOrNull { it.coordinate == this.getRightBlockCoord() }
                    ?.let {
                        nextBlocks.add(
                            CityBlockWithDirectionOfTravel(
                                it, DirectionOfTravel.RIGHT, 1
                            )
                        )
                    }
            }

            DirectionOfTravel.DOWN -> {
                if (currentLongestStraightLineLength < MAX_LINE_LENGTH) {
                    allCityBlocks.firstOrNull { it.coordinate == this.getDownBlockCoord() }
                        ?.let {
                            nextBlocks.add(
                                CityBlockWithDirectionOfTravel(
                                    it, DirectionOfTravel.DOWN, currentLongestStraightLineLength + 1
                                )
                            )
                        }
                }

                allCityBlocks.firstOrNull { it.coordinate == this.getLeftBlockCoord() }
                    ?.let {
                        nextBlocks.add(
                            CityBlockWithDirectionOfTravel(
                                it, DirectionOfTravel.LEFT, 1
                            )
                        )
                    }
                allCityBlocks.firstOrNull { it.coordinate == this.getRightBlockCoord() }
                    ?.let {
                        nextBlocks.add(
                            CityBlockWithDirectionOfTravel(
                                it, DirectionOfTravel.RIGHT, 1
                            )
                        )
                    }
            }

            DirectionOfTravel.LEFT -> {
                if (currentLongestStraightLineLength < MAX_LINE_LENGTH) {
                    allCityBlocks.firstOrNull { it.coordinate == this.getLeftBlockCoord() }
                        ?.let {
                            nextBlocks.add(
                                CityBlockWithDirectionOfTravel(
                                    it, DirectionOfTravel.LEFT, currentLongestStraightLineLength + 1
                                )
                            )
                        }
                }

                allCityBlocks.firstOrNull { it.coordinate == this.getUpBlockCoord() }
                    ?.let {
                        nextBlocks.add(
                            CityBlockWithDirectionOfTravel(
                                it, DirectionOfTravel.UP, 1
                            )
                        )
                    }
                allCityBlocks.firstOrNull { it.coordinate == this.getDownBlockCoord() }
                    ?.let {
                        nextBlocks.add(
                            CityBlockWithDirectionOfTravel(
                                it, DirectionOfTravel.DOWN, 1
                            )
                        )
                    }
            }

            DirectionOfTravel.RIGHT -> {
                if (currentLongestStraightLineLength < MAX_LINE_LENGTH) {
                    allCityBlocks.firstOrNull { it.coordinate == this.getRightBlockCoord() }
                        ?.let {
                            nextBlocks.add(
                                CityBlockWithDirectionOfTravel(
                                    it, DirectionOfTravel.RIGHT, currentLongestStraightLineLength + 1
                                )
                            )
                        }
                }

                allCityBlocks.firstOrNull { it.coordinate == this.getUpBlockCoord() }
                    ?.let {
                        nextBlocks.add(
                            CityBlockWithDirectionOfTravel(
                                it, DirectionOfTravel.UP, 1
                            )
                        )
                    }
                allCityBlocks.firstOrNull { it.coordinate == this.getDownBlockCoord() }
                    ?.let {
                        nextBlocks.add(
                            CityBlockWithDirectionOfTravel(
                                it, DirectionOfTravel.DOWN, 1
                            )
                        )
                    }
            }
        }
        nextBlocks
    }

private fun Coordinate.getLeftBlockCoord(): Coordinate =
    this.copy(x = this.x - 1)

private fun Coordinate.getRightBlockCoord(): Coordinate =
    this.copy(x = this.x + 1)

private fun Coordinate.getUpBlockCoord(): Coordinate =
    this.copy(y = this.y - 1)

private fun Coordinate.getDownBlockCoord(): Coordinate =
    this.copy(y = this.y + 1)

private fun List<CityBlock>.getLastBlock(): CityBlock =
    this.maxBy { it.coordinate.x + it.coordinate.y }

private fun CityBlock.getDistanceTo(destBlock: CityBlock) =
    abs(
        sqrt(
            ((destBlock.coordinate.x - this.coordinate.x).toDouble()).pow(2.toDouble()) +
                    ((destBlock.coordinate.y - this.coordinate.y).toDouble()).pow(2.toDouble())
        )
    )

private fun List<CityBlock>.print() {
    val rows = this.groupBy { it.coordinate.y }.toSortedMap()
    rows.map { (_, cityBlocks) ->
        cityBlocks.sortedBy {
            it.coordinate.x
        }.map {
            print(it.heatLossValue)
        }
        println()
    }
}

data class CityBlockWithDirectionOfTravel(
    val cityBlock: CityBlock, val directionOfTravel: DirectionOfTravel,
    val currentLongestStraightLineLength: Int
)
data class CityBlock(val coordinate: Coordinate, val heatLossValue: Int)
data class Coordinate(val x: Int, val y: Int)
enum class DirectionOfTravel {
    UP,
    DOWN,
    LEFT,
    RIGHT
}