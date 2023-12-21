fun main() {
    part1()
}

private fun part1() {
    val result = input
        .toTerrain()
        .toSteps(64)

    println("Part 1 | Answer: $result")
}

private fun List<String>.toTerrain(): Terrain {
    var startPlot: Coordinate? = null
    val plots = mutableSetOf<Coordinate>()
    val rocks = mutableSetOf<Coordinate>()

    this.mapIndexed { y, row ->
        row.mapIndexed { x, terrainChar ->
            val coordinate = Coordinate(x, y, )
            when(terrainChar) {
                'S' -> {
                    startPlot = coordinate
                    plots.add(startPlot!!)
                }
                '.' -> plots.add(coordinate)
                '#' -> rocks.add(coordinate)
                else -> throw Error("Invalid terrain encountered: $terrainChar")
            }
        }
    }

    return Terrain(startPlot!!, plots, rocks)
}

private fun Terrain.toSteps(numOfSteps: Int): Int {
    var visitedPlots = setOf(this.startPlot)
    repeat(numOfSteps) {
        visitedPlots = visitedPlots.flatMap { visitedPlot ->
            visitedPlot.toEmptyPlots(this.plots.minus(visitedPlots))
        }.toSet()
    }
    return visitedPlots.size
}

private fun Coordinate.toEmptyPlots(availablePlots: Set<Coordinate>): List<Coordinate> {
    val currentPosition = this
    return Direction.values().mapNotNull { direction ->
        when(direction) {
            Direction.NORTH -> availablePlots.firstOrNull {  it == currentPosition.copy(y = currentPosition.y - 1) }
            Direction.EAST -> availablePlots.firstOrNull {  it == currentPosition.copy(x = currentPosition.x + 1) }
            Direction.SOUTH -> availablePlots.firstOrNull {  it == currentPosition.copy(y = currentPosition.y + 1) }
            Direction.WEST -> availablePlots.firstOrNull {  it == currentPosition.copy(x = currentPosition.x - 1) }
        }
    }
}

data class Terrain(val startPlot: Coordinate, val plots: Set<Coordinate>, val rocks: Set<Coordinate>)
data class Coordinate(val x: Int, val y: Int)
enum class Direction {
    NORTH, EAST, SOUTH, WEST
}