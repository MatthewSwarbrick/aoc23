import kotlin.Comparable

fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toHands()
        .sortedDescending()
        .toWinnings()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toHands(isJTheJoker = true)
        .sortedDescending()
        .toWinnings()

    println("Part 2 | Answer: $result")
}

private fun List<String>.toHands(isJTheJoker: Boolean = false): List<Hand> =
    this.map {
        val parts = it.split(" ")
        val cards = parts[0].trim()
            .map { cardChar ->
                val cardAsString = cardChar.toString()
                Card(cardAsString, cardAsString.toRank(isJTheJoker))
            }
        val bid = parts[1].toInt()
        Hand(cards, bid, cards.toResult(isJTheJoker))
    }

private fun List<Hand>.toWinnings(): Int =
    this.mapIndexed { index, hand -> hand.bid * (index + 1) }
        .sum()

private fun List<Card>.toResult(isJTheJoker: Boolean): HandResult {
    val groupedCards = this.groupBy { it.value }
    val totalJokers = this.count { it.value == "J" }
    return if (!isJTheJoker) {
        when {
            groupedCards.any { it.value.count() == 5 } -> HandResult.FIVE_OF_A_KIND
            groupedCards.any { it.value.count() == 4 } -> HandResult.FOUR_OF_A_KIND
            groupedCards.any { it.value.count() == 3 } && groupedCards.count() == 2 -> HandResult.FULL_HOUSE
            groupedCards.any { it.value.count() == 3 } && groupedCards.count() > 2 -> HandResult.THREE_OF_A_KIND
            groupedCards.count { it.value.count() == 2 } == 2 -> HandResult.TWO_PAIR
            groupedCards.count { it.value.count() == 2 } == 1 && groupedCards.count() == 4 -> HandResult.ONE_PAIR
            else -> HandResult.HIGH_CARD
        }
    } else {
        when {
            groupedCards.any { it.value.count() == 5 } ||
                    (groupedCards.any { it.value.count() == 4 } && totalJokers == 1) ||
                    (groupedCards.any { it.value.count() == 3 } && totalJokers == 2) ||
                    (groupedCards.any { it.value.count() == 2 } && totalJokers == 3) ||
                    (groupedCards.any { it.value.count() == 1 } && totalJokers == 4) -> HandResult.FIVE_OF_A_KIND

            groupedCards.any { it.value.count() == 4 } ||
                    (groupedCards.any { it.value.count() == 3 } && totalJokers == 1) ||
                    (groupedCards.any { it.value.count() == 2 && it.key != "J" } && totalJokers == 2) ||
                    (groupedCards.any { it.value.count() == 1 } && totalJokers == 3) -> HandResult.FOUR_OF_A_KIND

            (groupedCards.any { it.value.count() == 3 } && groupedCards.count() == 2) ||
                    (groupedCards.count { it.value.count() == 2 } == 2 && totalJokers == 1) -> HandResult.FULL_HOUSE

            (groupedCards.any { it.value.count() == 3 } && groupedCards.count() > 2) ||
                    (groupedCards.count { it.value.count() == 2 } == 1 && totalJokers == 1) ||
                    (groupedCards.count() == 4 && totalJokers == 2) -> HandResult.THREE_OF_A_KIND

            groupedCards.count { it.value.count() == 2 } == 2 -> HandResult.TWO_PAIR

            (groupedCards.count { it.value.count() == 2 } == 1 && groupedCards.count() == 4) ||
                    (groupedCards.count() == 5 && totalJokers == 1) -> HandResult.ONE_PAIR

            else -> HandResult.HIGH_CARD
        }
    }
}

private fun List<Card>.isBetterThan(other: List<Card>): Boolean =
    this.forEachIndexed { index, card ->
        if (card.rank == other[index].rank) {
            return@forEachIndexed
        }

        if (card.rank > other[index].rank) {
            return true
        }

        return false
    }.let { false }

private fun String.toRank(isJTheJoker: Boolean): Int {
    val strength = this.toIntOrNull()
    if (strength != null) {
        return strength
    }

    return when (this) {
        "A" -> 14
        "K" -> 13
        "Q" -> 12
        "J" -> if (isJTheJoker) 1 else 11
        "T" -> 10
        else -> throw Error("Invalid card found")
    }
}

class Hand(private val cards: List<Card>, val bid: Int, private val result: HandResult) :
    Comparable<Hand> {
    override operator fun compareTo(other: Hand): Int =
        when {
            other.cards == this.cards -> 0
            other.result == HandResult.FIVE_OF_A_KIND && other.result.rank > this.result.rank -> 1
            other.result == HandResult.FOUR_OF_A_KIND && other.result.rank > this.result.rank -> 1
            other.result == HandResult.FULL_HOUSE && other.result.rank > this.result.rank -> 1
            other.result == HandResult.THREE_OF_A_KIND && other.result.rank > this.result.rank -> 1
            other.result == HandResult.TWO_PAIR && other.result.rank > this.result.rank -> 1
            other.result == HandResult.ONE_PAIR && other.result.rank > this.result.rank -> 1
            other.result == this.result -> if (other.cards.isBetterThan(this.cards)) 1 else -1
            else -> -1
        }
}

data class Card(val value: String, val rank: Int)
enum class HandResult(val rank: Int) {
    FIVE_OF_A_KIND(7),
    FOUR_OF_A_KIND(6),
    FULL_HOUSE(5),
    THREE_OF_A_KIND(4),
    TWO_PAIR(3),
    ONE_PAIR(2),
    HIGH_CARD(1)
}
