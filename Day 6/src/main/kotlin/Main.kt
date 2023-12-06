fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toRaces()
        .toPossibleRecordBreakers()
        .map { it.count() }
        .reduce { acc, i -> acc * i }

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = listOf(input.toRace())
        .toPossibleRecordBreakers()
        .map { it.count() }
        .reduce { acc, i -> acc * i }

    println("Part 2 | Answer: $result")
}

private fun List<String>.toRaces(): List<Race> {
    val times = this[0].extractNumbers()
    val distances = this[1].extractNumbers()

    return times.mapIndexed { index, time ->
        Race(time = time, currentRecord = distances[index])
    }
}

private fun List<String>.toRace(): Race {
    val time = this[0].extractNumbers().joinToString(separator = "").toLong()
    val distance = this[1].extractNumbers().joinToString(separator = "").toLong()

    return Race(time, distance)
}

private fun List<Race>.toPossibleRecordBreakers(): List<List<Long>> =
    this.map { race ->
        (0..race.time)
            .map { speed ->
                val timeRemaining = race.time - speed
                timeRemaining * speed
            }
            .filter { it > race.currentRecord}
    }

private fun String.extractNumbers(): List<Long> =
    this.split(":")[1].trim().split(" ").filter { it.isNotBlank() }.map { it.toLong() }

data class Race(val time: Long, val currentRecord: Long)