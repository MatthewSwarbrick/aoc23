const val POSSIBLE_REDS_MAX = 12
const val POSSIBLE_GREENS_MAX = 13
const val POSSIBLE_BLUES_MAX = 14

fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toGames()
        .toPossibleGames()
        .sumOf { it.id }

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toGames()
        .toRequiredCubes()
        .toPowers()
        .sum()

    println("Part 2 | Answer: $result")
}

private fun List<String>.toGames() =
    this.map {
        val gameId = it.getGameId()
        val gameSets = it.getGameSets()
        Game(id = gameId, sets = gameSets)
    }

private fun List<Game>.toPossibleGames(): List<Game> =
    this.filter { game ->
        val maxReds = game.sets.maxOf { it.reds }
        val maxGreens = game.sets.maxOf { it.greens }
        val maxBlues = game.sets.maxOf { it.blues }

        maxReds <= POSSIBLE_REDS_MAX && maxGreens <= POSSIBLE_GREENS_MAX && maxBlues <= POSSIBLE_BLUES_MAX
    }

private fun List<Game>.toRequiredCubes(): List<Cubes> =
    this.map {game ->
        val maxReds = game.sets.maxOf { it.reds }
        val maxGreens = game.sets.maxOf { it.greens }
        val maxBlues = game.sets.maxOf { it.blues }

        Cubes(reds = maxReds, greens = maxGreens, blues = maxBlues)
    }

private fun List<Cubes>.toPowers(): List<Int> =
    this.map {
        it.reds * it.greens * it.blues
    }

private fun String.getGameId() =
    this.split(":")[0].removePrefix("Game ").toInt()

private fun String.getGameSets() =
    this.split(":")[1].trim()
        .split(";")
        .map { gameSetString ->
            val cubes = gameSetString.split(",")
            val reds = cubes.getColourCubeCount("red")
            val greens = cubes.getColourCubeCount("green")
            val blues = cubes.getColourCubeCount("blue")
            Cubes(reds = reds, greens = greens, blues = blues)
        }

private fun List<String>.getColourCubeCount(colour: String): Int {
    val colourCount = this
        .firstOrNull { it.contains(colour) } ?: return 0

    return colourCount.removeSuffix(colour)
        .trim()
        .toInt()
}

data class Game(val id: Int, val sets: List<Cubes>)
data class Cubes(val reds: Int, val greens: Int, val blues: Int)