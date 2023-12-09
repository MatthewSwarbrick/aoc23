fun main() {
    part1()
}

private fun part1() {
    val result = input
        .toSequences()
        .sumOf { it.numbers.last() }

    println("Part 1 | Answer: $result")
}

private fun List<String>.toSequences(): List<Sequence> =
    this.map { input ->
        input
            .toSequence()
            .extrapolate()
            .toNewSequence()[0]
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

private fun List<Sequence>.toNewSequence(): List<Sequence> {
    if(this.count() == 1) return this

    val lastSequenceValue = this.getLastValue()
    val filteredSequences = this.take(this.count() - 1)
    val newLastSequenceValue = lastSequenceValue + filteredSequences.getLastValue()
    return filteredSequences.mapIndexed { index, sequence ->
        if(index != filteredSequences.count() - 1) {
            sequence
        } else {
            Sequence(sequence.numbers.plus(newLastSequenceValue))
        }
    }.toNewSequence()
}

private fun List<Sequence>.getLastValue(): Int =
    this.last().numbers.last()

data class Sequence(val numbers: List<Int>)