fun main() {
    part1()
    part2()
}

private fun part1() {
    val result = input
        .toMirroredViews()
        .toReflections()
        .toTotal()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toMirroredViews()
        .toSmudgedReflections()
        .toTotal()

    println("Part 2 | Answer: $result")
}

private fun List<String>.toMirroredViews(): List<MirroredView> {
    var all = this
    val allMirroredViews = mutableListOf<MirroredView>()
    while (all.isNotEmpty()) {
        val view = all.takeWhile { it.isNotEmpty() }
        val groundPieces = view
            .flatMapIndexed { y, view ->
                view.mapIndexed { x, char ->
                    val groundType = if (char == '#') {
                        GroundType.ROCK
                    } else {
                        GroundType.ASH
                    }
                    val coordinate = Coordinate(x, y)
                    GroundPiece(coordinate, groundType)
                }
            }
        allMirroredViews.add(MirroredView(groundPieces))
        all = all.drop(view.size + 1)
    }

    return allMirroredViews
}

private fun List<MirroredView>.toReflections(): List<Reflection> =
    this.map { mirroredView -> mirroredView.toReflection() }

private fun List<MirroredView>.toSmudgedReflections(): List<Reflection> =
    this.map { mirroredView ->
        val currentReflection = mirroredView.toReflection()
        val isHorizontal = currentReflection.topY != null

        mirroredView.groundPieces.firstNotNullOf { groundPieceToFlip ->
            val smudgedMirrorView = mirroredView.copy(groundPieces = mirroredView.groundPieces.map {
                if (it == groundPieceToFlip) {
                    when (it.groundType) {
                        GroundType.ASH -> it.copy(groundType = GroundType.ROCK)
                        GroundType.ROCK -> it.copy(groundType = GroundType.ASH)
                    }
                } else {
                    it
                }
            })

            val reflection = smudgedMirrorView.toReflection(currentReflection)
            if(reflection.leftX == null && reflection.topY == null) {
                null
            } else {
                reflection
            }
        }
    }

private fun MirroredView.toReflection(reflectionToIgnore: Reflection? = null): Reflection {
    var possibleReflectionXs = if (reflectionToIgnore == null) {
        (0 until this.groundPieces.maxOf { it.coordinate.x }).toList()
    } else {
        (0 until this.groundPieces.maxOf { it.coordinate.x })
            .filter { x -> x != reflectionToIgnore.leftX?.let { it - 1 } }
            .toList()
    }
    this.groundPieces.groupBy { it.coordinate.y }
        .forEach { (_, row) ->
            possibleReflectionXs = possibleReflectionXs.filter { possibleX ->
                val before = row.filter { it.coordinate.x <= possibleX }
                val after = row.filter { it.coordinate.x > possibleX }
                if (before.size <= after.size) {
                    val beforeString = before.joinToString("") { it.groundType.toChar() }.reversed()
                    val afterString = after.joinToString("") { it.groundType.toChar() }
                    afterString.startsWith(beforeString)
                } else {
                    val beforeString = before.joinToString("") { it.groundType.toChar() }
                    val afterString = after.joinToString("") { it.groundType.toChar() }.reversed()
                    beforeString.endsWith(afterString)
                }
            }
        }

    var possibleReflectionYs = if (reflectionToIgnore == null) {
        (0 until this.groundPieces.maxOf { it.coordinate.y }).toList()
    } else {
        (0 until this.groundPieces.maxOf { it.coordinate.y })
            .filter { y -> y != (reflectionToIgnore.topY?.let { it - 1 }) }
            .toList()
    }
    this.groundPieces.groupBy { it.coordinate.x }
        .forEach { (_, column) ->
            possibleReflectionYs = possibleReflectionYs.filter { possibleY ->
                val before = column.filter { it.coordinate.y <= possibleY }
                val after = column.filter { it.coordinate.y > possibleY }
                if (before.size <= after.size) {
                    val beforeString = before.joinToString("") { it.groundType.toChar() }.reversed()
                    val afterString = after.joinToString("") { it.groundType.toChar() }
                    afterString.startsWith(beforeString)
                } else {
                    val beforeString = before.joinToString("") { it.groundType.toChar() }
                    val afterString = after.joinToString("") { it.groundType.toChar() }.reversed()
                    beforeString.endsWith(afterString)
                }
            }
        }
    return Reflection(
        topY = possibleReflectionYs.firstOrNull()?.let { it + 1 },
        bottomY = possibleReflectionYs.firstOrNull()?.let { it + 2 },
        leftX = possibleReflectionXs.firstOrNull()?.let { it + 1 },
        rightX = possibleReflectionXs.firstOrNull()?.let { it + 2 }
    )
}


private fun List<Reflection>.toTotal() =
    this.sumOf { reflection ->
        var total = 0
        if (reflection.topY != null) {
            total += 100 * reflection.topY
        }

        if (reflection.leftX != null) {
            total += reflection.leftX
        }

        total
    }

private fun MirroredView.print() {
    val rows = this.groundPieces.groupBy { it.coordinate.y }.toSortedMap()
    rows.map { (_, spaces) ->
        spaces.sortedBy {
            it.coordinate.x
        }.map {
            print(it.groundType.toChar())
        }
        println()
    }
}

private fun GroundType.toChar() =
    if (this == GroundType.ROCK) {
        "#"
    } else {
        "."
    }

data class MirroredView(val groundPieces: List<GroundPiece>)
data class GroundPiece(val coordinate: Coordinate, val groundType: GroundType)
data class Coordinate(val x: Int, val y: Int)
data class Reflection(val topY: Int?, val bottomY: Int?, val leftX: Int?, val rightX: Int?)
enum class GroundType {
    ASH,
    ROCK
}