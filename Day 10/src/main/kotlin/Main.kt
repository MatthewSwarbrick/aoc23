fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toPipeMap()
        .toLoop()
        .toFarthestPoint()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val pipeMap = input
        .toPipeMap()

    val loop = pipeMap
        .toLoop()

    val nonLoopCoordinates =
        pipeMap.keys.filter { nonLoopCoordinate -> loop.all { it.coordinate != nonLoopCoordinate } }

    val enclosedCoordinates = loop.toEnclosedCoordinates(nonLoopCoordinates)
    val result = enclosedCoordinates.count()

    println("Part 2 | Answer: $result")
}

private fun List<String>.toPipeMap(): Map<Coordinate, Pipe> =
    this.flatMapIndexed { y, row ->
        row.mapIndexed { x, pipeChar ->
            val coordinate = Coordinate(x, y)
            val pipe = Pipe(coordinate, pipeChar)
            coordinate to pipe
        }
    }.toMap()

private fun Map<Coordinate, Pipe>.toLoop(): List<Pipe> {
    val startPipePart = this.entries.first { (_, pipe) -> pipe.symbol == 'S' }
    var pipePathsSoFar = setOf(listOf(startPipePart.value))

    var loopFound = false
    while (!loopFound) {
        pipePathsSoFar = pipePathsSoFar.flatMap { pipePath ->
            val previousPipePart = pipePath.last()
            val previousCoordinate = previousPipePart.coordinate
            previousPipePart.possibleDirections.mapNotNull { direction ->
                val newCoordinate = when (direction) {
                    Direction.NORTH -> previousCoordinate.copy(y = previousCoordinate.y - 1)
                    Direction.EAST -> previousCoordinate.copy(x = previousCoordinate.x + 1)
                    Direction.SOUTH -> previousCoordinate.copy(y = previousCoordinate.y + 1)
                    Direction.WEST -> previousCoordinate.copy(x = previousCoordinate.x - 1)
                }

                val newPipe = this[newCoordinate]
                if (newPipe != null) {
                    if (previousPipePart.symbol != 'S') {
                        newPipe
                    } else {
                        val pipesCanConnect = newPipe.possibleDirections.any { newPartDirection ->
                            when (direction) {
                                Direction.NORTH -> newPartDirection == Direction.SOUTH
                                Direction.EAST -> newPartDirection == Direction.WEST
                                Direction.SOUTH -> newPartDirection == Direction.NORTH
                                Direction.WEST -> newPartDirection == Direction.EAST
                            }
                        }
                        if (pipesCanConnect) {
                            newPipe
                        } else {
                            null
                        }
                    }
                } else {
                    null
                }
            }
                .filter { (pipePath.count() > 2 && it.symbol == 'S') || !pipePath.contains(it) }
                .map {
                    if (it.symbol == 'S') {
                        loopFound = true
                    }

                    pipePath.plus(it)
                }
        }.toSet()
    }

    return pipePathsSoFar.first { it.last().symbol == 'S' }
}

private fun List<Pipe>.toFarthestPoint() =
    (this.size - 1) / 2

private fun List<Pipe>.toEnclosedCoordinates(nonLoopCoordinates: List<Coordinate>): List<Coordinate> =
    nonLoopCoordinates.mapNotNull { nonLoopCoordinate ->
        val loopPartsRightOfPoint = this.filter {
            it.coordinate.y == nonLoopCoordinate.y &&
                    it.coordinate.x > nonLoopCoordinate.x
        }.toSet()

        val edgeCount = loopPartsRightOfPoint.count { it.symbol == '|' }
        val northCorners = loopPartsRightOfPoint
            .count {
                it.symbol == 'F' || it.symbol == '7'
            }

        val intersectCount = edgeCount + northCorners
        if (intersectCount % 2 == 0) {
            null
        } else {
            nonLoopCoordinate
        }
    }

private fun Char.toPossibleDirections(): List<Direction> =
    when (this) {
        'S' -> listOf(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST)
        '|' -> listOf(Direction.NORTH, Direction.SOUTH)
        '-' -> listOf(Direction.WEST, Direction.EAST)
        'L' -> listOf(Direction.NORTH, Direction.EAST)
        'J' -> listOf(Direction.NORTH, Direction.WEST)
        '7' -> listOf(Direction.SOUTH, Direction.WEST)
        'F' -> listOf(Direction.SOUTH, Direction.EAST)
        else -> emptyList()
    }

data class Coordinate(val x: Int, val y: Int)
data class Pipe(
    val coordinate: Coordinate,
    val symbol: Char,
    val possibleDirections: List<Direction> = symbol.toPossibleDirections()
)

enum class Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST
}



