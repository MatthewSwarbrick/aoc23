fun main() {
    part1()
    part2()
}

private fun part1() {
    val seeds = input.toSeeds()
    val seedToSoilMap = input.toSeedMap("seed", "soil")
    val soilToFertilizerMap = input.toSeedMap("soil", "fertilizer")
    val fertilizerToWaterMap = input.toSeedMap("fertilizer", "water")
    val waterToLightMap = input.toSeedMap("water", "light")
    val lightToTemperatureMap = input.toSeedMap("light", "temperature")
    val temperatureToHumidityMap = input.toSeedMap("temperature", "humidity")
    val humidityToLocationMap = input.toSeedMap("humidity", "location")

    val result = seeds.toLocations(
        seedToSoilMap,
        soilToFertilizerMap,
        fertilizerToWaterMap,
        waterToLightMap,
        lightToTemperatureMap,
        temperatureToHumidityMap,
        humidityToLocationMap
    ).min()

    println("Part 1 | Answer: $result")
}

private fun part2() {
    val seedRanges = input.toSeedRanges()
    val seedToSoilMap = input.toSeedMap("seed", "soil")
    val soilToFertilizerMap = input.toSeedMap("soil", "fertilizer")
    val fertilizerToWaterMap = input.toSeedMap("fertilizer", "water")
    val waterToLightMap = input.toSeedMap("water", "light")
    val lightToTemperatureMap = input.toSeedMap("light", "temperature")
    val temperatureToHumidityMap = input.toSeedMap("temperature", "humidity")
    val humidityToLocationMap = input.toSeedMap("humidity", "location")

    val result = seedRanges.minOf { seedRange ->
        seedRange.toMinLocation(
            seedToSoilMap,
            soilToFertilizerMap,
            fertilizerToWaterMap,
            waterToLightMap,
            lightToTemperatureMap,
            temperatureToHumidityMap,
            humidityToLocationMap
        )
    }

    println("Part 2 | Answer: $result")
}

private fun List<String>.toSeeds(): List<Long> =
    this.first {
        it.startsWith("seeds:")
    }
        .split(":")[1].trim()
        .split(" ")
        .map { it.toLong() }

private fun List<String>.toSeedRanges(): List<LongRange> {
    val ranges = this.first {
        it.startsWith("seeds:")
    }
        .split(":")[1].trim()
        .split(" ")
        .map { it.toLong() }
        .chunked(2)

    return ranges.map { (startSeed, rangeLength) ->
        (startSeed .. startSeed + rangeLength)
    }
}

private fun List<String>.toSeedMap(source: String, destination: String): List<SeedMap> {
    val startOfMap = this.dropWhile { it != "$source-to-$destination map:" }
    val seedMap = startOfMap.drop(1).takeWhile { it.isNotEmpty() }
    return seedMap.map { mapEntry ->
        val values = mapEntry.split(" ")
            .map { it.trim().toLong() }
        SeedMap(destRangeStart = values[0], sourceRangeStart = values[1], rangeLength = values[2])
    }
}

private fun List<Long>.toLocations(vararg seedMaps: List<SeedMap>): List<Long> =
    this.map { seed ->
        var input = seed
        seedMaps.map {
            input = input.mapTo(it)
        }
        input
    }

private fun LongRange.toMinLocation(vararg seedMaps: List<SeedMap>): Long =
    this.minOf { seed ->
        var input = seed
        seedMaps.map {
            input = input.mapTo(it)
        }
        input
    }

private fun Long.mapTo(seedMap: List<SeedMap>): Long {
    val matchingMap = seedMap.firstOrNull { (it.sourceRangeStart until (it.sourceRangeStart + it.rangeLength)).contains(this) }
    return if(matchingMap != null) {
        matchingMap.destRangeStart + (this - matchingMap.sourceRangeStart)
    } else {
        this
    }
}

data class SeedMap(val destRangeStart: Long, val sourceRangeStart: Long, val rangeLength: Long)



