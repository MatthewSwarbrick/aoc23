fun main() {
    part1()
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