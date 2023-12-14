fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toConditionRecords()
        .toCombinations()
        .sumOf { it.second }

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toConditionRecords()
        .unfold()
        .toCombinations()
        .sumOf { it.second }

    println("Part 2 | Answer: $result")
}

private fun List<String>.toConditionRecords(): List<ConditionRecord> =
    this.map { conditionRecord ->
        val parts = conditionRecord.split(" ")
        val incompleteSequence = parts[0]
        val damagedGroups = parts[1].split(",").map { it.toInt() }
        ConditionRecord(incompleteSequence, damagedGroups)
    }

private fun List<ConditionRecord>.unfold(): List<ConditionRecord> =
    this.map { (incompleteSequence, damagedGroups) ->
        ConditionRecord((1..5).joinToString("?") { incompleteSequence }, (1..5).flatMap { damagedGroups })
    }

private fun List<ConditionRecord>.toCombinations(): List<Pair<ConditionRecord, Int>> =
    this.mapIndexed { index, conditionRecord ->
        println("Progress update. On iteration ${index + 1} of ${this.size}")

        val matchingCombinations = conditionRecord.incompleteSequence
            .toAllCombinations(conditionRecord.incompleteSequence.length, conditionRecord.damagedGroups)

        conditionRecord to matchingCombinations.count()
    }

private fun String.toAllCombinations(originalCombinationLength: Int, validGroupLengths: List<Int>): List<String> {
    val firstUnknownIndex = this.indexOfFirst { it == '?' }
    if (firstUnknownIndex == -1) {
        return listOfNotNull(this.toValidCombination(originalCombinationLength, validGroupLengths))
    }

    val replacedWithHash = this.replaceRange(firstUnknownIndex, firstUnknownIndex + 1, "#")
        .substring(0, firstUnknownIndex + 1)
    val replacedWithDot = this.replaceRange(firstUnknownIndex, firstUnknownIndex + 1, ".")
        .substring(0, firstUnknownIndex + 1)

    val stringAfter = this.substring(firstUnknownIndex + 1, this.length)
    return stringAfter.toAllCombinations(originalCombinationLength, validGroupLengths).flatMap {
        listOfNotNull(
            "$replacedWithHash$it".toValidCombination(originalCombinationLength, validGroupLengths),
            "$replacedWithDot$it".toValidCombination(originalCombinationLength, validGroupLengths)
        )
    }
}

private fun String.toValidCombination(originalCombinationLength: Int, validGroupLengths: List<Int>): String? {
    if (originalCombinationLength == this.length) {
        val groups = this.split('.').filter { it.isNotBlank() }
        val isValid = validGroupLengths.size == groups.size &&
                groups.mapIndexed { index, group ->
                    group.length == validGroupLengths[index]
                }.all { it }
        return if(isValid) {
            this
        } else {
            null
        }
    }

    val foundGroups = this.split('.').filter { it.isNotBlank() }
    val firstGroupIsComplete = this.startsWith('.')

    if (foundGroups.size > validGroupLengths.size) {
        return null
    }

    val isValid = foundGroups.reversed().mapIndexed { index, group ->
        if (index == foundGroups.lastIndex && !firstGroupIsComplete) {
            validGroupLengths.reversed()[index] >= group.count()
        } else {
            validGroupLengths.reversed()[index] == group.count()
        }
    }.all { it }

    return if (isValid) {
        this
    } else {
        null
    }
}

data class ConditionRecord(val incompleteSequence: String, val damagedGroups: List<Int>)