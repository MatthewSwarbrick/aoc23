fun main() {
    part1()
    part2()
}

val visitedTiles: MutableSet<Pair<Coordinate, DirectionOfTravel>> = mutableSetOf()

private fun part1() {
    input
        .toTiles()
        .toEnergisedTiles()

    val result = visitedTiles
        .map { it.first }.toSet()
        .count()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    visitedTiles.clear()
    val result = input
        .toTiles()
        .toMaxEnergisedTiles()

    println("Part 2 | Answer: $result")
}

private fun List<String>.toTiles(): Map<Coordinate, Char> =
    this.flatMapIndexed { y, row ->
        row.mapIndexed { x, mirrorChar ->
            Coordinate(x, y) to mirrorChar
        }
    }.toMap()


private fun Map<Coordinate, Char>.toEnergisedTiles(
    coordinate: Coordinate = Coordinate(0, 0),
    directionOfTravel: DirectionOfTravel = DirectionOfTravel.RIGHT
) {
    val currentTileAndDirection = coordinate to directionOfTravel
    if (!this.containsKey(coordinate) || visitedTiles.contains(currentTileAndDirection)) {
        return
    }

    visitedTiles.add(currentTileAndDirection)

    val newTileCoordinates = toNewCoordinates(coordinate, this[coordinate]!!, directionOfTravel)
    newTileCoordinates.forEach {
        this.toEnergisedTiles(it.first, it.second)
    }
}

private fun Map<Coordinate, Char>.toMaxEnergisedTiles(): Int {
    val maxY = this.maxOf { it.key.y }
    val maxX = this.maxOf { it.key.x }
    val topCoords = this.keys.filter { it.y == 0 }
    val leftCoords = this.keys.filter { it.x == 0 }
    val bottomCoords = this.keys.filter { it.y == maxY }
    val rightCoords = this.keys.filter { it.x == maxX}

    val maxFromTop = topCoords.maxOf { topCoord ->
        visitedTiles.clear()
        this.toEnergisedTiles(topCoord, DirectionOfTravel.DOWN)

        visitedTiles
            .map { it.first }.toSet().count()
    }

    val maxFromLeft = leftCoords.maxOf { leftCoord ->
        visitedTiles.clear()
        this.toEnergisedTiles(leftCoord, DirectionOfTravel.RIGHT)

        visitedTiles
            .map { it.first }.toSet().count()
    }

    val maxFromBottom = bottomCoords.maxOf { bottomCoord ->
        visitedTiles.clear()
        this.toEnergisedTiles(bottomCoord, DirectionOfTravel.UP)

        visitedTiles
            .map { it.first }.toSet().count()
    }

    val maxFromRight = rightCoords.maxOf { rightCoord ->
        visitedTiles.clear()
        this.toEnergisedTiles(rightCoord, DirectionOfTravel.LEFT)

        visitedTiles
            .map { it.first }.toSet().count()
    }

    return listOf(maxFromTop, maxFromLeft, maxFromBottom, maxFromRight).maxOf { it }
}

private fun toNewCoordinates(
    coordinate: Coordinate,
    tileSymbol: Char,
    directionOfTravel: DirectionOfTravel
): List<Pair<Coordinate, DirectionOfTravel>> =
    when (tileSymbol) {
        '.' -> {
            when(directionOfTravel) {
                DirectionOfTravel.UP -> listOf(coordinate.copy(y = coordinate.y - 1) to directionOfTravel)
                DirectionOfTravel.DOWN -> listOf(coordinate.copy(y = coordinate.y + 1) to directionOfTravel)
                DirectionOfTravel.LEFT -> listOf(coordinate.copy(x = coordinate.x - 1) to directionOfTravel)
                DirectionOfTravel.RIGHT -> listOf(coordinate.copy(x = coordinate.x + 1) to directionOfTravel)
            }
        }

        '/' -> {
            when(directionOfTravel) {
                DirectionOfTravel.UP -> listOf(coordinate.copy(x = coordinate.x + 1) to DirectionOfTravel.RIGHT)
                DirectionOfTravel.DOWN -> listOf(coordinate.copy(x = coordinate.x - 1) to DirectionOfTravel.LEFT)
                DirectionOfTravel.LEFT -> listOf(coordinate.copy(y = coordinate.y + 1) to DirectionOfTravel.DOWN)
                DirectionOfTravel.RIGHT -> listOf(coordinate.copy(y = coordinate.y - 1) to DirectionOfTravel.UP)
            }
        }

        '\\' -> {
            when(directionOfTravel) {
                DirectionOfTravel.UP -> listOf(coordinate.copy(x = coordinate.x - 1) to DirectionOfTravel.LEFT)
                DirectionOfTravel.DOWN -> listOf(coordinate.copy(x = coordinate.x + 1) to DirectionOfTravel.RIGHT)
                DirectionOfTravel.LEFT -> listOf(coordinate.copy(y = coordinate.y - 1) to DirectionOfTravel.UP)
                DirectionOfTravel.RIGHT -> listOf(coordinate.copy(y = coordinate.y + 1) to DirectionOfTravel.DOWN)
            }
        }

        '|' -> {
            when(directionOfTravel) {
                DirectionOfTravel.UP -> listOf(coordinate.copy(y = coordinate.y - 1) to directionOfTravel)
                DirectionOfTravel.DOWN -> listOf(coordinate.copy(y = coordinate.y + 1) to directionOfTravel)
                DirectionOfTravel.LEFT -> listOf(
                    coordinate.copy(y = coordinate.y + 1) to DirectionOfTravel.DOWN,
                    coordinate.copy(y = coordinate.y - 1) to DirectionOfTravel.UP
                )
                DirectionOfTravel.RIGHT -> listOf(
                    coordinate.copy(y = coordinate.y + 1) to DirectionOfTravel.DOWN,
                    coordinate.copy(y = coordinate.y - 1) to DirectionOfTravel.UP
                )
            }
        }

        '-' -> {
            when(directionOfTravel) {
                DirectionOfTravel.UP -> listOf(
                    coordinate.copy(x = coordinate.x - 1) to DirectionOfTravel.LEFT,
                    coordinate.copy(x = coordinate.x + 1) to DirectionOfTravel.RIGHT
                )
                DirectionOfTravel.DOWN -> listOf(
                    coordinate.copy(x = coordinate.x - 1) to DirectionOfTravel.LEFT,
                    coordinate.copy(x = coordinate.x + 1) to DirectionOfTravel.RIGHT
                )
                DirectionOfTravel.LEFT -> listOf(coordinate.copy(x = coordinate.x - 1) to directionOfTravel)
                DirectionOfTravel.RIGHT -> listOf(coordinate.copy(x = coordinate.x + 1) to directionOfTravel)
            }
        }

        else -> throw Error("Invalid tile found")
    }

private fun Set<Coordinate>.print(energisedTiles: Set<Coordinate>) {
    val rows = this.groupBy { it.y }
    val columns = this.groupBy { it.x }

    rows.forEach { (y, _) ->
        columns.forEach { (x, _) ->
            if(energisedTiles.contains(Coordinate(x, y))) {
                print('#')
            } else {
                print('.')
            }
        }
        println()
    }
}

data class Coordinate(val x: Int, val y: Int)
enum class DirectionOfTravel {
    UP,
    DOWN,
    LEFT,
    RIGHT
}