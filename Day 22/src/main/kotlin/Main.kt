import kotlin.math.max
import kotlin.math.min

fun main() {
    part1()
}

private fun part1() {
    val result = input
        .toSuspendedBricks()
        .toFallenBricks().apply { this.print() }
        .toDisintegratedBricks()

    println("Part 1 | Answer: ${result.count()}")
}

private fun List<String>.toSuspendedBricks(): List<Brick> {
    return this.map {
        val brickParts = it.split("~")
        val (x1, y1, z1) = brickParts[0].split(",")
        val (x2, y2, z2) = brickParts[1].split(",")

        val startCoord = Coordinate(x1.toInt(), y1.toInt(), z1.toInt())
        val endCoord = Coordinate(x2.toInt(), y2.toInt(), z2.toInt())
        Brick(startCoord, endCoord)
    }
}

private fun List<Brick>.toFallenBricks(): List<Brick> {
    val test = this
        .sortedBy { min(it.start.z, it.end.z) }
        .fold(emptyList<Brick>()) { acc, fallingBrick ->
            val zToDropTo = acc
                .filter { brickUnderneath ->
                    val xRange = min(brickUnderneath.start.x, brickUnderneath.end.x)..max(
                        brickUnderneath.start.x,
                        brickUnderneath.end.x
                    )
                    val yRange = min(brickUnderneath.start.y, brickUnderneath.end.y)..max(
                        brickUnderneath.start.y,
                        brickUnderneath.end.y
                    )

                    val startX = min(fallingBrick.start.x, fallingBrick.end.x)
                    val endX = max(fallingBrick.start.x, fallingBrick.end.x)
                    val startY = min(fallingBrick.start.y, fallingBrick.end.y)
                    val endY = max(fallingBrick.start.y, fallingBrick.end.y)

                    val overlapsOnY = startY <= yRange.last && yRange.first <= endY ||
                            startY < yRange.first && endY > yRange.last

                    val overlapsOnX = startX <= xRange.last && xRange.first <= endX ||
                            startX < xRange.first && endX > xRange.last

                    overlapsOnX && overlapsOnY

                }.let { bricksUnder ->
                    if (bricksUnder.isEmpty()) 1 else bricksUnder.maxOf {
                        max(
                            it.start.z + 1,
                            it.end.z + 1
                        )
                    }
                }

            var updatedBrick = fallingBrick
            while (updatedBrick.start.z != zToDropTo && updatedBrick.end.z != zToDropTo) {
                updatedBrick = updatedBrick.copy(
                    start = updatedBrick.start.copy(z = updatedBrick.start.z - 1),
                    end = updatedBrick.end.copy(z = updatedBrick.end.z - 1)
                )
            }
            acc.plus(updatedBrick)
        }

    return test
}

private fun List<Brick>.toDisintegratedBricks(): List<Brick> {
    val maxZ = this.maxOf { max(it.start.z, it.end.z) }
    return this.filter { brickToCheck ->
        val maxBrickZ = max(brickToCheck.start.z, brickToCheck.end.z)
        if (maxBrickZ == maxZ) {
            true
        } else {
            val bricksAbove = this.filter { min(it.start.z, it.end.z) == maxBrickZ + 1 }
            val otherBricksAtSameZ = this.filter {
                max(it.start.z, it.end.z) == maxBrickZ &&
                        it != brickToCheck
            }
            val result = bricksAbove.isEmpty() || bricksAbove.all { brickAbove ->
                otherBricksAtSameZ.any { brickUnderneath ->
                    val xRange = min(brickUnderneath.start.x, brickUnderneath.end.x)..max(
                        brickUnderneath.start.x,
                        brickUnderneath.end.x
                    )
                    val yRange = min(brickUnderneath.start.y, brickUnderneath.end.y)..max(
                        brickUnderneath.start.y,
                        brickUnderneath.end.y
                    )

                    val startX = min(brickAbove.start.x, brickAbove.end.x)
                    val endX = max(brickAbove.start.x, brickAbove.end.x)
                    val startY = min(brickAbove.start.y, brickAbove.end.y)
                    val endY = max(brickAbove.start.y, brickAbove.end.y)

                    val overlapsOnY = startY <= yRange.last && yRange.first <= endY ||
                            startY < yRange.first && endY > yRange.last

                    val overlapsOnX = startX <= xRange.last && xRange.first <= endX ||
                            startX < xRange.first && endX > xRange.last

                    overlapsOnX && overlapsOnY
                }
            }

            result
        }
    }
}

private fun List<Brick>.print() {
    val minZ = 0
    val maxZ = this.maxOf { max(it.start.z, it.end.z) }
    val minX = 0
    val maxX = this.maxOf { max(it.start.x, it.end.x) }
    val minY = 0
    val maxY = this.maxOf { max(it.start.y, it.end.y) }

    println("Printing X Z")
    println(" x ")
    (minX..maxX).forEach {
        print("$it")
    }
    println()
    (minZ..maxZ).reversed().forEach { z ->
        (minX..maxX).forEach { x ->
            val brick = this.firstOrNull { it.start.z <= z && it.end.z >= z && (it.start.x <= x && it.end.x >= x) }
            if (brick == null) {
                print(".")
            } else {
                print("${this.indexOf(brick).toLetter()}")
            }
        }
        println()
    }

    println()
    println("Printing Y Z")
    println(" y ")
    (minY..maxY).forEach {
        print("$it")
    }
    println()
    (minZ..maxZ).reversed().forEach { z ->
        (minY..maxY).forEach { y ->
            val brick = this.firstOrNull { it.start.z <= z && it.end.z >= z && (it.start.y <= y && it.end.y >= y) }
            if (brick == null) {
                print(".")
            } else {
                print("${this.indexOf(brick).toLetter()}")
            }
        }
        println()
    }
}

private fun Int.toLetter(): String =
    when (this % 10) {
        0 -> "A"
        1 -> "B"
        2 -> "C"
        3 -> "D"
        4 -> "E"
        5 -> "F"
        6 -> "G"
        7 -> "H"
        8 -> "I"
        9 -> "J"
        else -> throw Error("Invalid letter")
    }

data class Brick(val start: Coordinate, val end: Coordinate)
data class Coordinate(val x: Int, val y: Int, val z: Int)

