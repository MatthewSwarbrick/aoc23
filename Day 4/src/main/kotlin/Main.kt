fun main() {
    part1()
}

private fun part1() {
    val result = input
        .toCards()
        .toCardResults()
        .sumOf { it.score }

    println("Part 1 | Answer: $result")
}

private fun List<String>.toCards(): List<Card> =
    this.map { it.toCard() }

private fun List<Card>.toCardResults(): List<CardResult> =
    this.map { it.toCardResult() }

private fun String.toCard(): Card {
    val cardParts = this.split("|")
    val winningNumbersParts = cardParts[0].split(":")
    val id = winningNumbersParts[0].removePrefix("Card").trim().toInt()
    val winningNumbers = winningNumbersParts[1].convertToNumbers()
    val numbersPlayerHas = cardParts[1].convertToNumbers()

    return Card(id, winningNumbers, numbersPlayerHas)
}

private fun Card.toCardResult(): CardResult {
    val matchingNumbers = this.winningNumbers.intersect(this.numbersPlayerHas.toSet())
    val score = matchingNumbers.toScore()
    return CardResult(this.id, matchingNumbers, score)
}

private fun String.convertToNumbers(): List<Int> =
    this.trim().split(" ")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }

private fun Set<Int>.toScore(): Int =
    when {
        this.isEmpty() -> 0
        else -> (0..size)
            .reduce { acc, _ ->
                if (acc == 0) {
                    1
                } else {
                    acc * 2
                }
            }
    }

data class Card(val id: Int, val winningNumbers: List<Int>, val numbersPlayerHas: List<Int>)
data class CardResult(val cardId: Int, val matchingNumbers: Set<Int>, val score: Int)



