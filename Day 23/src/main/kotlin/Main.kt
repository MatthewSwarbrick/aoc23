import java.time.LocalDateTime
import java.util.*

fun main() {
  //  part1()
    part2()
}

private fun part1() {
    val result = input
        .toPathTiles()
        .toLongestPath()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val result = input
        .toPathTiles()
        .toLongestPath(canTravelUpSlopes = true)

    println("Part 2 | Answer: $result")
}

private fun List<String>.toPathTiles(): List<PathTile> =
    this.flatMapIndexed { y, row ->
        row.mapIndexed { x, pathTileChar ->
            val coordinate = Coordinate(x, y)
            val pathType = when (pathTileChar) {
                '.' -> PathType.PATH
                '>', '<', '^', 'v' -> PathType.SLOPE
                else -> return@mapIndexed null
            }

            val slopeDirection = when (pathTileChar) {
                '>' -> Direction.EAST
                '<' -> Direction.WEST
                '^' -> Direction.NORTH
                'v' -> Direction.SOUTH
                else -> null
            }

            PathTile(coordinate, pathType, slopeDirection)
        }
    }.filterNotNull()

var arbitraryQueueSizeReached = false
var minQueueSize = 40

private fun List<PathTile>.toLongestPath(canTravelUpSlopes: Boolean = false): Int {
    val maxY = this.maxOf { it.coordinate.y }
    val startBlock = this.first { it.coordinate.y == 0 }
    val endCoord = this.last { it.coordinate.y == maxY }.coordinate
    val longestPathLengths = mutableListOf<Int>()
    val visited = mutableMapOf<List<Coordinate>, Int>()
    val queue = PriorityQueue(compareByDescending<LongestPathState> { it.pathLength })

    queue.add(LongestPathState(listOf(startBlock.coordinate), startBlock, 0))
    while (queue.isNotEmpty()) {
        if(queue.size > 30) {
            arbitraryQueueSizeReached = true
        }
        if(arbitraryQueueSizeReached && queue.size < minQueueSize ) {
            minQueueSize = queue.size
            println("${LocalDateTime.now()} | New queue size: $minQueueSize")
        }

        val (currentPath, currentTile, currentLength) = queue.poll()

        Direction.values().forEach { direction ->
            val newPathLength = currentLength + 1
            val nextCoord = direction.move(canTravelUpSlopes, currentTile)
            if (nextCoord == endCoord) {
                longestPathLengths.add(newPathLength)
                return@forEach
            }

            this.firstOrNull { it.coordinate == nextCoord }?.let { nextTile ->
                if (!currentPath.contains(nextTile.coordinate)) {
                    val newPath = currentPath.plus(nextTile.coordinate)
//                    val visitedPath = newPath.takeLast(20)
//                    if (newPathLength > (visited[visitedPath] ?: 0)) {
//                        visited[visitedPath] = newPathLength
                        val newState =
                            LongestPathState(newPath, nextTile, currentLength + 1)
                        queue.add(newState)
//                    }
                }
            }
        }
    }

    return longestPathLengths.max()
}

private fun Direction.move(canTravelUpSlopes: Boolean, tile: PathTile): Coordinate? =
    when (this) {
        Direction.NORTH -> if (tile.slopeDirection != null && !canTravelUpSlopes) {
            when (tile.slopeDirection) {
                Direction.NORTH -> tile.coordinate.copy(y = tile.coordinate.y - 1)
                else -> null
            }
        } else {
            tile.coordinate.copy(y = tile.coordinate.y - 1)
        }

        Direction.EAST -> if (tile.slopeDirection != null && !canTravelUpSlopes) {
            when (tile.slopeDirection) {
                Direction.EAST -> tile.coordinate.copy(x = tile.coordinate.x + 1)
                else -> null
            }
        } else {
            tile.coordinate.copy(x = tile.coordinate.x + 1)
        }

        Direction.SOUTH -> if (tile.slopeDirection != null && !canTravelUpSlopes) {
            when (tile.slopeDirection) {
                Direction.SOUTH -> tile.coordinate.copy(y = tile.coordinate.y + 1)
                else -> null
            }
        } else {
            tile.coordinate.copy(y = tile.coordinate.y + 1)
        }

        Direction.WEST -> if (tile.slopeDirection != null && !canTravelUpSlopes) {
            when (tile.slopeDirection) {
                Direction.WEST -> tile.coordinate.copy(x = tile.coordinate.x - 1)
                else -> null
            }
        } else {
            tile.coordinate.copy(x = tile.coordinate.x - 1)
        }
    }

data class PathTile(val coordinate: Coordinate, val type: PathType, val slopeDirection: Direction?)
data class Coordinate(val x: Int, val y: Int)
data class LongestPathState(val currentPath: List<Coordinate>, val currentPathTile: PathTile, val pathLength: Int)
enum class PathType {
    PATH, SLOPE
}

enum class Direction {
    NORTH, EAST, SOUTH, WEST
}


