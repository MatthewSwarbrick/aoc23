import kotlin.math.abs

fun main() {
    part1()
}

private fun part1() {
    val result = input
        .toSpaceMap().apply { print() }.apply { println() }
        .expand().apply { print() }
        .toGalaxyPairs()
        .toGalaxyPairDistances()
        .sum()

    println("Part 1 | Answer: $result")
}

private fun List<String>.toSpaceMap(): List<Space> =
    this.flatMapIndexed { y, row ->
        row.mapIndexed { x, spaceChar ->
            val coordinate = Coordinate(x, y)
            val spaceType = if (spaceChar == '.') {
                SpaceType.EMPTY
            } else {
                SpaceType.GALAXY
            }
            Space(coordinate, spaceType)
        }
    }

private fun List<Space>.expand(): List<Space> {
    val columnsToExpand = this.groupBy { it.coordinate.x }
        .filter { column -> column.value.all { it.type == SpaceType.EMPTY } }
        .map { it.key }.sorted()

    var expandedSpace = this
    columnsToExpand.forEach { columnToExpand ->
        val newColumn = expandedSpace.filter { it.coordinate.x == columnToExpand }
        expandedSpace = expandedSpace.map {
            if (it.coordinate.x <= columnToExpand) {
                it.copy(coordinate = Coordinate(x = it.coordinate.x - 1, y = it.coordinate.y))
            } else {
                it
            }
        }.plus(newColumn)
    }

    val rowsToExpand = expandedSpace.groupBy { it.coordinate.y }
        .filter { column -> column.value.all { it.type == SpaceType.EMPTY } }
        .map { it.key }.sorted()

    rowsToExpand.forEach { rowToExpand ->
        val newColumn = expandedSpace.filter { it.coordinate.y == rowToExpand }
        expandedSpace = expandedSpace.map {
            if (it.coordinate.y <= rowToExpand) {
                it.copy(coordinate = Coordinate(x = it.coordinate.x, y = it.coordinate.y - 1))
            } else {
                it
            }
        }.plus(newColumn)
    }

    return expandedSpace
}

private fun List<Space>.toGalaxyPairs(): List<Pair<Space, Space>> {
    val galaxySpaces = this.filter { it.type == SpaceType.GALAXY }
    return galaxySpaces.flatMapIndexed { index, leftSpace ->
        galaxySpaces.drop(index + 1)
            .map { rightSpace ->
                leftSpace to rightSpace
            }
    }
}

private fun List<Pair<Space, Space>>.toGalaxyPairDistances(): List<Int> =
    this.map { (left, right) ->
        (abs(left.coordinate.x - right.coordinate.x) + abs(left.coordinate.y - right.coordinate.y))
    }

private fun List<Space>.print() {
    val rows = this.groupBy { it.coordinate.y }.toSortedMap()
    rows.map { (_, spaces) ->
        spaces.sortedBy {
            it.coordinate.x
        }.map {
            val symbol = if (it.type == SpaceType.EMPTY) {
                "."
            } else {
                "#"
            }
            print(symbol)
        }
        println()
    }
}

data class Space(val coordinate: Coordinate, val type: SpaceType)
data class Coordinate(val x: Int, val y: Int)

enum class SpaceType {
    EMPTY,
    GALAXY
}