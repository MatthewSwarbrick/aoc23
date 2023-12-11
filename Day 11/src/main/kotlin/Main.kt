import kotlin.math.abs

fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toSpaceMap()
        .expand().apply { print() }
        .toGalaxyPairs()
        .toGalaxyPairDistances()
        .sum()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toSpaceMap()
        .expand(999_999)
        .toGalaxyPairs()
        .toGalaxyPairDistances()
        .sum()

    println("Part 2 | Answer: $result")
}

private fun List<String>.toSpaceMap(): List<Space> =
    this.flatMapIndexed { y, row ->
        row.mapIndexed { x, spaceChar ->
            val coordinate = Coordinate(x.toLong(), y.toLong())
            val spaceType = if (spaceChar == '.') {
                SpaceType.EMPTY
            } else {
                SpaceType.GALAXY
            }
            Space(coordinate, spaceType)
        }
    }

private fun List<Space>.expand(expandSize: Int = 1): List<Space> {
    val columnsToExpand = this.groupBy { it.coordinate.x }
        .filter { column -> column.value.all { it.type == SpaceType.EMPTY } }
        .map { it.key }.sorted()

    val rowsToExpand = this.groupBy { it.coordinate.y }
        .filter { column -> column.value.all { it.type == SpaceType.EMPTY } }
        .map { it.key }.sorted()

    var expandedSpace = this.filter { it.type == SpaceType.GALAXY }
    columnsToExpand.forEach { columnToExpand ->
        repeat(expandSize) {
            expandedSpace = expandedSpace.map {
                if (it.coordinate.x <= columnToExpand) {
                    it.copy(coordinate = Coordinate(x = it.coordinate.x - 1, y = it.coordinate.y))
                } else {
                    it
                }
            }
        }
    }

    rowsToExpand.forEach { rowToExpand ->
        repeat(expandSize) {
            expandedSpace = expandedSpace.map {
                if (it.coordinate.y <= rowToExpand) {
                    it.copy(coordinate = Coordinate(x = it.coordinate.x, y = it.coordinate.y - 1))
                } else {
                    it
                }
            }
        }
    }

    return expandedSpace
}

private fun List<Space>.toGalaxyPairs(): List<Pair<Space, Space>> =
    this.flatMapIndexed { index, leftSpace ->
        this.drop(index + 1)
            .map { rightSpace ->
                leftSpace to rightSpace
            }
    }

private fun List<Pair<Space, Space>>.toGalaxyPairDistances(): List<Long> =
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
data class Coordinate(val x: Long, val y: Long)

enum class SpaceType {
    EMPTY,
    GALAXY
}