import kotlin.math.floor

fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toPlatform()
        .tiltNorth()
        .toLoad()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toPlatform()
        .cycle(1_000_000_000)
        .toLoad()

    println("Part 2 | Answer: $result")
}

private fun List<String>.toPlatform(): Platform =
    Platform(this.toRocks())

private fun Platform.tiltNorth(): Platform {
    val rockColumns = this.rocks.groupBy { it.coordinate.x }
    val updatedColumns = rockColumns.flatMap { (_, rocks) ->
        var updatedColumn = rocks
        val roundRocks = rocks.filter { it.type == RockType.ROUND }
        roundRocks.forEach { roundRock ->
            val columnAboveRock = updatedColumn.take(roundRock.coordinate.y).reversed()
            if (columnAboveRock.isEmpty()) {
                return@forEach
            }
            val rockToSwapWith = columnAboveRock.takeWhile { it.type == RockType.NONE }.lastOrNull()
                ?: return@forEach

            updatedColumn = updatedColumn.map { rock ->
                when (rock) {
                    roundRock -> rockToSwapWith.copy(coordinate = roundRock.coordinate)
                    rockToSwapWith -> roundRock.copy(coordinate = rockToSwapWith.coordinate)
                    else -> rock
                }
            }
        }
        updatedColumn
    }

    return Platform(updatedColumns)
}

private fun Platform.tiltWest(): Platform {
    val rockRows = this.rocks.groupBy { it.coordinate.y }
    val updatedRows = rockRows.flatMap { (_, rocks) ->
        var updatedRow = rocks
        val roundRocks = rocks.filter { it.type == RockType.ROUND }
        roundRocks.forEach { roundRock ->
            val rowBeforeRock = updatedRow.take(roundRock.coordinate.x).reversed()
            if (rowBeforeRock.isEmpty()) {
                return@forEach
            }
            val rockToSwapWith = rowBeforeRock.takeWhile { it.type == RockType.NONE }.lastOrNull()
                ?: return@forEach

            updatedRow = updatedRow.map { rock ->
                when (rock) {
                    roundRock -> rockToSwapWith.copy(coordinate = roundRock.coordinate)
                    rockToSwapWith -> roundRock.copy(coordinate = rockToSwapWith.coordinate)
                    else -> rock
                }
            }
        }
        updatedRow
    }

    return Platform(updatedRows)
}

private fun Platform.tiltSouth(): Platform {
    val rockColumns = this.rocks.groupBy { it.coordinate.x }
    val updatedColumns = rockColumns.flatMap { (_, rocks) ->
        var updatedColumn = rocks
        val roundRocks = rocks.filter { it.type == RockType.ROUND }.reversed()
        roundRocks.forEach { roundRock ->
            val columnBelowRock = updatedColumn.drop(roundRock.coordinate.y + 1)
            if (columnBelowRock.isEmpty()) {
                return@forEach
            }
            val rockToSwapWith = columnBelowRock.takeWhile { it.type == RockType.NONE }.lastOrNull()
                ?: return@forEach

            updatedColumn = updatedColumn.map { rock ->
                when (rock) {
                    roundRock -> rockToSwapWith.copy(coordinate = roundRock.coordinate)
                    rockToSwapWith -> roundRock.copy(coordinate = rockToSwapWith.coordinate)
                    else -> rock
                }
            }
        }
        updatedColumn
    }

    return Platform(updatedColumns)
}

private fun Platform.tiltEast(): Platform {
    val rockRows = this.rocks.groupBy { it.coordinate.y }
    val updatedRows = rockRows.flatMap { (_, rocks) ->
        var updatedRow = rocks
        val roundRocks = rocks.filter { it.type == RockType.ROUND }.reversed()
        roundRocks.forEach { roundRock ->
            val rowAfterRock = updatedRow.drop(roundRock.coordinate.x + 1)
            if (rowAfterRock.isEmpty()) {
                return@forEach
            }
            val rockToSwapWith = rowAfterRock.takeWhile { it.type == RockType.NONE }.lastOrNull()
                ?: return@forEach

            updatedRow = updatedRow.map { rock ->
                when (rock) {
                    roundRock -> rockToSwapWith.copy(coordinate = roundRock.coordinate)
                    rockToSwapWith -> roundRock.copy(coordinate = rockToSwapWith.coordinate)
                    else -> rock
                }
            }
        }
        updatedRow
    }

    return Platform(updatedRows)
}

private fun Platform.cycle(numberOfCycles: Int): Platform {
    val allPlatformsSeen = mutableMapOf<Int, Platform>()
    var latestPlatform = this
    (1..numberOfCycles).forEach { iteration ->
        if (iteration % 100_000_000 == 0) {
            println("${floor(100 * (iteration.toDouble() / numberOfCycles.toDouble())).toInt()}% complete")
        }

        val platformHash = latestPlatform.hashCode()

        if (allPlatformsSeen.containsKey(platformHash)) {
            latestPlatform = allPlatformsSeen[platformHash]!!
            return@forEach
        }

        val after = latestPlatform.tiltNorth()
            .tiltWest()
            .tiltSouth()
            .tiltEast()

        if (!allPlatformsSeen.containsKey(platformHash)) {
            allPlatformsSeen[platformHash] = after
        }

        latestPlatform = after
    }
    return latestPlatform
}

private fun Platform.toLoad(): Int {
    val numberOfRows = this.rocks.maxOf { it.coordinate.y } + 1
    val rows = this.rocks.groupBy { it.coordinate.y }
    return rows.map { (y, rocks) ->
        val rowStrength = numberOfRows - y
        rowStrength * rocks.count { it.type == RockType.ROUND }
    }.sum()
}

private fun List<String>.toRocks(): List<Rock> =
    this.flatMapIndexed { y, row ->
        row.mapIndexed { x, rockChar ->
            val coordinate = Coordinate(x, y)
            val rockType = when (rockChar) {
                '#' -> RockType.CUBE
                'O' -> RockType.ROUND
                else -> RockType.NONE
            }
            Rock(coordinate, rockType)
        }
    }

private fun Platform.print() {
    val rows = this.rocks.groupBy { it.coordinate.y }.toSortedMap()
    rows.map { (_, rocks) ->
        rocks.sortedBy {
            it.coordinate.x
        }.map {
            print(it.type.toChar())
        }
        println()
    }
}

private fun RockType.toChar() =
    when (this) {
        RockType.ROUND -> 'O'
        RockType.CUBE -> '#'
        RockType.NONE -> '.'
    }

data class Platform(val rocks: List<Rock>)
data class Rock(val coordinate: Coordinate, val type: RockType)
data class Coordinate(val x: Int, val y: Int)
enum class RockType {
    ROUND,
    CUBE,
    NONE
}