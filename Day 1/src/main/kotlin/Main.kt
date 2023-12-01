fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toCalibrations(includeWords = false)
        .sum()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toCalibrations(includeWords = true)
        .sum()

    println("Part 2 | Answer: $result")
}

private fun List<String>.toCalibrations(includeWords: Boolean = false): List<Int> =
    this.map { it.toCalibration(includeWords) }

private fun String.toCalibration(includeWords: Boolean): Int {
    val digitsFromInput = this.extractNumbers(includeWords)
    return "${digitsFromInput.first()}${digitsFromInput.last()}".toInt()
}

private fun String.extractNumbers(includeWords: Boolean): List<Int> {
    val validDigits = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    val validWords = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    val valuesToExtract = if (includeWords) {
        validWords.plus(validDigits)
    } else {
        validDigits
    }

    val regex = """(?=(${valuesToExtract.joinToString(separator = "|")}))""".toRegex()
    return regex.findAll(this)
        .map { it.groupValues.last() }
        .map { it.toNumber() }
        .toList()
}

private fun String.toNumber(): Int =
    when (this) {
        "1", "one" -> 1
        "2", "two" -> 2
        "3", "three" -> 3
        "4", "four" -> 4
        "5", "five" -> 5
        "6", "six" -> 6
        "7", "seven" -> 7
        "8", "eight" -> 8
        "9", "nine" -> 9
        else -> this.toInt()
    }