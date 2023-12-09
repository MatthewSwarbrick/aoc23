fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toSequences()
        .sumOf { it.numbers.last() }

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toSequences(isExtrapolateBack = true)
        .sumOf { it.numbers.first() }

    println("Part 1 | Answer: $result")
}

private fun List<String>.toSequences(isExtrapolateBack: Boolean = false): List<Sequence> =
    this.map { input ->
        input
            .toSequence()
            .let { if(isExtrapolateBack) { it.extrapolateBack() } else { it.extrapolate()} }
            .toNewSequence(isExtrapolateBack)[0]
    }

private fun String.toSequence(): Sequence =
    this.split(" ")
        .map{ it.trim().toInt() }
        .let { Sequence(it) }

private fun Sequence.extrapolate(): List<Sequence> {
    val sequences = mutableListOf(this)

    var sequenceToExtrapolate = this.numbers
    while(!sequenceToExtrapolate.all { it == 0 }) {
        sequenceToExtrapolate = sequenceToExtrapolate
            .mapIndexedNotNull { index, value ->
                if(index == sequenceToExtrapolate.count() - 1) {
                    null
                } else {
                    sequenceToExtrapolate[index + 1] - value
                }
            }

        val sequence = Sequence(sequenceToExtrapolate)
        sequences.add(sequence)
    }

    return sequences
}

private fun Sequence.extrapolateBack(): List<Sequence> {
    val sequences = mutableListOf(this)

    var sequenceToExtrapolate = this.numbers
    while(!sequenceToExtrapolate.all { it == 0 }) {
        sequenceToExtrapolate = sequenceToExtrapolate
            .mapIndexedNotNull { index, value ->
                if(index == 0) {
                    null
                } else {
                    value - sequenceToExtrapolate[index - 1]
                }
            }

        val sequence = Sequence(sequenceToExtrapolate)
        sequences.add(sequence)
    }

    return sequences
}

private fun List<Sequence>.toNewSequence(isExtrapolateBack: Boolean): List<Sequence> {
    if(this.count() == 1) return this

    val previousSequenceValue = if(isExtrapolateBack) {
        this.getFirstValue()
    } else {
        this.getLastValue()
    }

    val filteredSequences = this.take(this.count() - 1)
    val currentSequenceValue = if(isExtrapolateBack) {
        filteredSequences.getFirstValue()
    } else {
        filteredSequences.getLastValue()
    }

    val newValue = if(isExtrapolateBack) {
        currentSequenceValue - previousSequenceValue
    } else {
        previousSequenceValue + currentSequenceValue
    }
    
    return filteredSequences.mapIndexed { index, sequence ->
        if(index != filteredSequences.count() - 1) {
            sequence
        } else {
            if(isExtrapolateBack) {
                val newNumbers = listOf(newValue).plus(sequence.numbers)
                Sequence(newNumbers)
            } else {
                Sequence(sequence.numbers.plus(newValue))
            }
        }
    }.toNewSequence(isExtrapolateBack)
}

private fun List<Sequence>.getLastValue(): Int =
    this.last().numbers.last()

private fun List<Sequence>.getFirstValue(): Int =
    this.last().numbers.first()

data class Sequence(val numbers: List<Int>)