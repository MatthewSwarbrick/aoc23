fun main() {
    val calibrations = input
        .toCalibrations()

    val result = calibrations.sum()

    println("Part 1 | Answer: $result")
}

private fun List<String>.toCalibrations(): List<Int> =
    this.map { amendedCalibration ->
        val firstDigit = amendedCalibration.first { it.isDigit() }
        val lastDigit = amendedCalibration.lastOrNull { it.isDigit() } ?: firstDigit
        "$firstDigit$lastDigit".toInt()
    }