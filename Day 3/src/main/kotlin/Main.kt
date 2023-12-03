fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toSchematic()
        .getPartNumbers()
        .sum()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toSchematic()
        .getGearRatios()
        .sum()

    println("Part 2 | Answer: $result")
}

private fun List<String>.toSchematic(): Map<Coordinate, SchematicPart> =
    this.toSchematicParts().associateBy {
        it.coordinate
    }

private fun List<String>.toSchematicParts(): List<SchematicPart> =
    this.flatMapIndexed { y, value ->
        val parts = mutableListOf<SchematicPart>()
        var currentPart = ""
        var currentX = 0
        value.forEach { partChar ->
            when {
                partChar.isDigit() -> {
                    currentPart = if (currentPart.toIntOrNull() != null || currentPart.isEmpty()) {
                        currentPart + partChar
                    } else {
                        val type = if (currentPart == ".") {
                            SchematicPartType.NOTHING
                        } else {
                            SchematicPartType.SYMBOL
                        }
                        val part =
                            SchematicPart(Coordinate(x = currentX - currentPart.length, y = y), currentPart, type)
                        parts.add(part)

                        "".plus(partChar)
                    }
                }

                else -> {
                    currentPart = if (currentPart.toIntOrNull() != null) {
                        val part = SchematicPart(
                            Coordinate(x = currentX - currentPart.length, y = y),
                            currentPart,
                            SchematicPartType.NUMBER
                        )
                        parts.add(part)
                        "".plus(partChar)
                    } else {
                        val type = if (currentPart == ".") {
                            SchematicPartType.NOTHING
                        } else {
                            SchematicPartType.SYMBOL
                        }

                        if (currentPart.isNotEmpty()) {
                            val part =
                                SchematicPart(Coordinate(x = currentX - currentPart.length, y = y), currentPart, type)
                            parts.add(part)
                        }

                        "".plus(partChar)
                    }
                }
            }
            currentX++
        }

        when {
            currentPart.toIntOrNull() != null -> {
                val part = SchematicPart(
                    Coordinate(x = currentX - currentPart.length, y = y),
                    currentPart,
                    SchematicPartType.NUMBER
                )
                parts.add(part)
            }

            currentPart == "." -> {
                val part = SchematicPart(
                    Coordinate(x = currentX - currentPart.length, y = y),
                    currentPart,
                    SchematicPartType.NOTHING
                )
                parts.add(part)
            }

            else -> {
                val part = SchematicPart(
                    Coordinate(x = currentX - currentPart.length, y = y),
                    currentPart,
                    SchematicPartType.SYMBOL
                )
                parts.add(part)
            }
        }
        parts
    }

private fun Map<Coordinate, SchematicPart>.getPartNumbers(): List<Int> =
    this.entries
        .filter { it.value.type == SchematicPartType.NUMBER }
        .filter { schematicPart ->
            var coordinateStart = schematicPart.key
            val coordinateEnd =
                Coordinate(x = coordinateStart.x + schematicPart.value.content.length - 1, y = coordinateStart.y)
            val surroundingParts = this.getAdjacentParts(coordinateStart, coordinateEnd)
            surroundingParts.any { it.type == SchematicPartType.SYMBOL }
        }.map {
            it.value.content.toInt()
        }

private fun Map<Coordinate, SchematicPart>.getGearRatios(): List<Int> =
    this.entries
        .filter { it.value.content == "*" }
        .mapNotNull { schematicPart ->
            val surroundingParts = this.getAdjacentParts(schematicPart.key, schematicPart.key)
            val numbersOnly = surroundingParts.filter { it.type == SchematicPartType.NUMBER }
            if (numbersOnly.size == 2) {
                numbersOnly[0].content.toInt() * numbersOnly[1].content.toInt()
            } else {
                null
            }
        }

private fun Map<Coordinate, SchematicPart>.getAdjacentParts(
    startCoordinate: Coordinate,
    endCoordinate: Coordinate
): Set<SchematicPart> {
    val xRange = startCoordinate.x - 1..endCoordinate.x + 1
    val yRange = startCoordinate.y - 1..endCoordinate.y + 1
    val maxY = this.keys.maxOf { it.y }
    return xRange.flatMap { x ->
        yRange.map { y ->
            if ((x >= startCoordinate.x && x <= endCoordinate.x && y == startCoordinate.y) || y < 0 || x < 0 || y > maxY) {
                null
            } else {
                this.getPartUsingCoordinate(Coordinate(x, y))
            }
        }
    }.filterNotNull().toSet()
}

private fun Map<Coordinate, SchematicPart>.getPartUsingCoordinate(coordinate: Coordinate): SchematicPart? =
    if (!this.containsKey(coordinate)) {
        this.getPartUsingCoordinate(coordinate.copy(x = coordinate.x - 1))
    } else {
        this[coordinate]
    }

data class SchematicPart(val coordinate: Coordinate, val content: String, val type: SchematicPartType)
data class Coordinate(val x: Int, val y: Int)
enum class SchematicPartType {
    NOTHING,
    NUMBER,
    SYMBOL
}