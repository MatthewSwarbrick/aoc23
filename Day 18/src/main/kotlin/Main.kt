import arrow.core.prependTo

fun main() {
    part1()
}

private fun part1() {
    val result = input
        .toDigInstructions()
        .toTrenchLoop().apply { this.print() }
        .toFilledTrench().apply { this.print() }

    println("Part 1 | Answer: ${result.count()}")
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

private fun List<DigInstruction>.toTrenchLoop(): Set<Coordinate> =
    this.fold(setOf(Coordinate(0, 0))) { acc, instruction ->
        val lastCoord = acc.last()
        val newCoords = when(instruction.direction) {
            Direction.UP -> (1 .. instruction.digLength).map { length -> lastCoord.copy(y = lastCoord.y - length) }
            Direction.DOWN -> (1 .. instruction.digLength).map { length -> lastCoord.copy(y = lastCoord.y + length) }
            Direction.LEFT -> (1 .. instruction.digLength).map { length -> lastCoord.copy(x = lastCoord.x - length) }
            Direction.RIGHT -> (1 .. instruction.digLength).map { length -> lastCoord.copy(x = lastCoord.x + length) }
        }
        acc.plus(newCoords)
    }

private fun Set<Coordinate>.toFilledTrench(): Set<Coordinate> {
    val minX = this.minOf { it.x }; val maxX = this.maxOf { it.x }
    val minY = this.minOf { it.y }; val maxY = this.maxOf { it.y }
    return (minY .. maxY).flatMap { y ->
        (minX .. maxX).mapNotNull { x ->
            val coord = Coordinate(x, y)
            if(this.contains(coord)) {
                coord
            } else {
                val coordsToRight = this.filter { it.y == y && it.x > x }
                val totalEdges = countEdges(coordsToRight, this)
                if(totalEdges % 2 == 0) {
                    null
                } else {
                    coord
                }
            }
        }
    }.toSet()
}

private fun countEdges(coordsToCheck: List<Coordinate>, allCoordinates: Set<Coordinate>): Int {
    val mutableCoordsToCheck = coordsToCheck.sortedBy { it.x }.toMutableList()
    var edgeCount = 0
    while(mutableCoordsToCheck.isNotEmpty()) {
        val firstCoord = mutableCoordsToCheck.removeFirst()
        var currentCoordInEdge = firstCoord
        val coordsInEdge = firstCoord.prependTo(mutableCoordsToCheck.takeWhile {
            (it.x == currentCoordInEdge.x + 1).apply {
                if (this) {
                    currentCoordInEdge = it
                }
            }
        })

        mutableCoordsToCheck.removeAll(coordsInEdge)

        if (coordsInEdge.size == 1) {
            edgeCount++
            continue
        }

        val firstEdgeCoord = coordsInEdge.first()
        val lastEdgeCoord = coordsInEdge.last()
        if(allCoordinates.any { it.x == firstEdgeCoord.x && it.y == firstEdgeCoord.y - 1 } &&
            allCoordinates.any { it.x == lastEdgeCoord.x && it.y == lastEdgeCoord.y - 1 }) {
            edgeCount += 2
            continue
        }

        if(allCoordinates.any { it.x == firstEdgeCoord.x && it.y == firstEdgeCoord.y + 1 } &&
            allCoordinates.any { it.x == lastEdgeCoord.x && it.y == lastEdgeCoord.y + 1 }) {
            edgeCount += 2
            continue
        }

        edgeCount++
    }

    return edgeCount
}

private fun Set<Coordinate>.print() {
    val minX = this.minOf { it.x }; val maxX = this.maxOf { it.x }
    val minY = this.minOf { it.y }; val maxY = this.maxOf { it.y }
    println()
    (minY .. maxY).forEach { y ->
        (minX .. maxX).forEach { x ->
            val coord = Coordinate(x, y)
            if(x == 0 && y == 0) {
                print('S')
            }
            else if(this.contains(coord)) {
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
