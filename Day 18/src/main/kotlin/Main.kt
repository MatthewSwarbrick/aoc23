import arrow.core.prependTo
import java.time.LocalDateTime
import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min

fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toDigInstructions()
        .toTrenchLoop()
        .toFilledTrenchCount()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toDigInstructionsFromHex()
        .toTrenchCount()

    println("Part 2 | Answer: $result")
}

private fun List<String>.toDigInstructions(): List<DigInstruction> =
    this.map {
        val planParts = it.split(" ")
        val direction = when (planParts[0]) {
            "U" -> Direction.UP
            "D" -> Direction.DOWN
            "R" -> Direction.RIGHT
            "L" -> Direction.LEFT
            else -> throw Error("Invalid Dig direction found")
        }
        DigInstruction(direction, planParts[1].toInt())
    }

private fun List<String>.toDigInstructionsFromHex(): List<DigInstruction> =
    this.map {
        val planParts = it.split(" ").last().trimStart('(', '#').trimEnd(')')
        val direction = when (planParts.last()) {
            '0' -> Direction.RIGHT
            '1' -> Direction.DOWN
            '2' -> Direction.LEFT
            '3' -> Direction.UP
            else -> throw Error("Invalid direction char found")
        }
        val length = planParts.dropLast(1).toInt(radix = 16)
        DigInstruction(direction, length)
    }

private fun List<DigInstruction>.toTrenchLoop(): List<Coordinate> {
    val startCoordinate = Coordinate(0, 0)
    val allCoordinates = mutableListOf<Coordinate>()
    var currentCoordinate = startCoordinate
    this.forEach { instruction ->
        val newCoords = when (instruction.direction) {
            Direction.UP -> (1..instruction.digLength).map { length -> currentCoordinate.copy(y = currentCoordinate.y - length) }
            Direction.DOWN -> (1..instruction.digLength).map { length -> currentCoordinate.copy(y = currentCoordinate.y + length) }
            Direction.LEFT -> (1..instruction.digLength).map { length -> currentCoordinate.copy(x = currentCoordinate.x - length) }
            Direction.RIGHT -> (1..instruction.digLength).map { length -> currentCoordinate.copy(x = currentCoordinate.x + length) }
        }

        currentCoordinate = newCoords.last()
        allCoordinates.addAll(newCoords)
    }

    return allCoordinates
}

private fun List<Coordinate>.toFilledTrenchCount(): Long {
    val rows = this.groupBy { it.y }.mapValues { (_, value) -> value.sortedBy { it.x } }
    val minY = this.minOf { it.y }
    val maxY = this.maxOf { it.y }
    var totalCount = 0L

    var currentY = minY
    val totalRows = maxY - minY
    while(currentY <= maxY) {
        if(currentY > 0 && currentY % 10000 == 0) {
            println("${LocalDateTime.now()} | Processed $currentY rows: ${floor((100 * (currentY.toDouble() / totalRows.toDouble()))).toInt()}% complete")
        }

        val row = rows[currentY]!!
        totalCount += row.size
        var currentXIndex = 0
        while(currentXIndex < row.size) {
            val firstCoord = row[currentXIndex]
            var currentCoordInEdge = firstCoord
            val coordsInEdge = firstCoord.prependTo(row.drop(currentXIndex + 1).takeWhile {
                (it.x == currentCoordInEdge.x + 1).apply {
                    if (this) {
                        currentCoordInEdge = it
                    }
                }
            })

            currentXIndex += coordsInEdge.size
            if(currentXIndex == row.size) {
                break
            }

            val distanceToNextX = row[currentXIndex].x - coordsInEdge.last().x - 1
            val totalEdges = countEdges(row.drop(currentXIndex), this)
            if (totalEdges % 2L == 0L) {
                continue
            } else {
                totalCount += distanceToNextX
            }
        }
        currentY++
    }

    return totalCount
}

private fun List<DigInstruction>.toTrenchCount(): Long {
    val yRange = this.getYRangeForTrench()
    val rangeChunks = yRange.chunked(1_000_000)
    var totalCount = 0L
    rangeChunks.forEachIndexed { index, range ->
        if(index > 0 && index % 10 == 0) {
            println("${LocalDateTime.now()} | Processed: $index of ${rangeChunks.size} batches. Batch ${range.first()} - ${range.last()}")
        }

        val row = this.toTrenchRows(range.first() .. range.last())
        totalCount += row.toFilledTrenchRowCount(range.first(), range.last())
    }

    return totalCount
}

private fun List<Coordinate>.toFilledTrenchRowCount(minY: Int, maxY: Int): Long {
    val rows = this.groupBy { it.y }.mapValues { (_, value) -> value.sortedBy { it.x } }
    var totalCount = 0L
    var currentY = minY
    while(currentY <= maxY) {
        val row = rows[currentY]!!
        totalCount += row.size
        var currentXIndex = 0
        while(currentXIndex < row.size) {
            val firstCoord = row[currentXIndex]
            var currentCoordInEdge = firstCoord
            val coordsInEdge = firstCoord.prependTo(row.drop(currentXIndex + 1).takeWhile {
                (it.x == currentCoordInEdge.x + 1).apply {
                    if (this) {
                        currentCoordInEdge = it
                    }
                }
            })

            currentXIndex += coordsInEdge.size
            if(currentXIndex == row.size) {
                break
            }

            val distanceToNextX = row[currentXIndex].x - coordsInEdge.last().x - 1
            val totalEdges = countEdges(row.drop(currentXIndex), this)
            if (totalEdges % 2L == 0L) {
                continue
            } else {
                totalCount += distanceToNextX
            }
        }
        currentY++
    }

    return totalCount
}

private fun List<DigInstruction>.getYRangeForTrench(): IntRange {
    var minY = 0
    var maxY = 0

    var currentCoordinate = Coordinate(0, 0)
    this.forEach { instruction ->
        val newCoords = when (instruction.direction) {
            Direction.UP -> (1..instruction.digLength).map { length -> currentCoordinate.copy(y = currentCoordinate.y - length) }
            Direction.DOWN -> (1..instruction.digLength).map { length -> currentCoordinate.copy(y = currentCoordinate.y + length) }
            Direction.LEFT -> (1..instruction.digLength).map { length -> currentCoordinate.copy(x = currentCoordinate.x - length) }
            Direction.RIGHT -> (1..instruction.digLength).map { length -> currentCoordinate.copy(x = currentCoordinate.x + length) }
        }

        val newMinY = newCoords.minOf { it.y }
        val newMaxY = newCoords.maxOf { it.y }
        minY = min(minY, newMinY)
        maxY = max(maxY, newMaxY)

        currentCoordinate = newCoords.last()
    }

    return minY .. maxY
}

private fun List<DigInstruction>.toTrenchRows(yRange: IntRange): List<Coordinate> {
    val fullRange = yRange.first - 1 .. yRange.last + 1

    val startCoordinate = Coordinate(0, 0)
    val allCoordinates = mutableListOf<Coordinate>()
    var currentCoordinate = startCoordinate
    this.forEach { instruction ->
        val newCoords = when (instruction.direction) {
            Direction.UP -> (1..instruction.digLength).map { length -> currentCoordinate.copy(y = currentCoordinate.y - length) }
            Direction.DOWN -> (1..instruction.digLength).map { length -> currentCoordinate.copy(y = currentCoordinate.y + length) }
            Direction.LEFT -> (1..instruction.digLength).map { length -> currentCoordinate.copy(x = currentCoordinate.x - length) }
            Direction.RIGHT -> (1..instruction.digLength).map { length -> currentCoordinate.copy(x = currentCoordinate.x + length) }
        }

        currentCoordinate = newCoords.last()
        allCoordinates.addAll(newCoords.filter { fullRange.contains(it.y) })
    }

    return allCoordinates
}

private fun countEdges(coordsToCheck: List<Coordinate>, allCoordinates: List<Coordinate>): Long {
    var edgeCount = 0L
    var coordsToCheckIndex = 0

    while (coordsToCheckIndex < coordsToCheck.size) {
        val firstCoord = coordsToCheck[coordsToCheckIndex]
        var currentCoordInEdge = firstCoord
        val coordsInEdge = firstCoord.prependTo(coordsToCheck.drop(coordsToCheckIndex+1).takeWhile {
            (it.x == currentCoordInEdge.x + 1).apply {
                if (this) {
                    currentCoordInEdge = it
                }
            }
        })

        coordsToCheckIndex += coordsInEdge.size

        if (coordsInEdge.size == 1) {
            edgeCount++
            continue
        }

        val firstEdgeCoord = coordsInEdge.first()
        val lastEdgeCoord = coordsInEdge.last()
        if (allCoordinates.any { it.x == firstEdgeCoord.x && it.y == firstEdgeCoord.y - 1 } &&
            allCoordinates.any { it.x == lastEdgeCoord.x && it.y == lastEdgeCoord.y - 1 }) {
            edgeCount += 2
            continue
        }

        if (allCoordinates.any { it.x == firstEdgeCoord.x && it.y == firstEdgeCoord.y + 1 } &&
            allCoordinates.any { it.x == lastEdgeCoord.x && it.y == lastEdgeCoord.y + 1 }) {
            edgeCount += 2
            continue
        }

        edgeCount++
    }

    return edgeCount
}

private fun Set<Coordinate>.print() {
    val minX = this.minOf { it.x };
    val maxX = this.maxOf { it.x }
    val minY = this.minOf { it.y };
    val maxY = this.maxOf { it.y }
    println()
    (minY..maxY).forEach { y ->
        (minX..maxX).forEach { x ->
            val coord = Coordinate(x, y)
            if (x == 0 && y == 0) {
                print('S')
            } else if (this.contains(coord)) {
                print('#')
            } else {
                print('.')
            }
        }
        println()
    }

    println()
}

data class DigInstruction(val direction: Direction, val digLength: Int)
data class Coordinate(val x: Int, val y: Int)
enum class Direction {
    UP, DOWN, LEFT, RIGHT
}