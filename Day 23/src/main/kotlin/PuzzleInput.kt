val sample = listOf(
    "#.#####################",
    "#.......#########...###",
    "#######.#########.#.###",
    "###.....#.>.>.###.#.###",
    "###v#####.#v#.###.#.###",
    "###.>...#.#.#.....#...#",
    "###v###.#.#.#########.#",
    "###...#.#.#.......#...#",
    "#####.#.#.#######.#.###",
    "#.....#.#.#.......#...#",
    "#.#####.#.#.#########v#",
    "#.#...#...#...###...>.#",
    "#.#.#v#######v###.###v#",
    "#...#.>.#...>.>.#.###.#",
    "#####v#.#.###v#.#.###.#",
    "#.....#...#...#.#.#...#",
    "#.#########.###.#.#.###",
    "#...###...#...#...#.###",
    "###.###.#.###v#####v###",
    "#...#...#.#.>.>.#.>.###",
    "#.###.###.#.###.#.#v###",
    "#.....###...###...#...#",
    "#####################.#"
)

val input = listOf(
    "#.###########################################################################################################################################",
    "#...#...#...#...#...#.....#####.........#...#.............#...#...#...#...#...#...........#.....#.......#...#.....#.......#...###...#...#####",
    "###.#.#.#.#.#.#.#.#.#.###.#####.#######.#.#.#.###########.#.#.#.#.#.#.#.#.#.#.#.#########.#.###.#.#####.#.#.#.###.#.#####.#.#.###.#.#.#.#####",
    "#...#.#.#.#...#.#.#.#...#.......#.......#.#.#...........#.#.#.#.#...#...#.#.#.#.........#.#.#...#.....#.#.#.#...#...#.....#.#...#.#...#.....#",
    "#.###.#.#.#####.#.#.###.#########.#######.#.###########.#.#.#.#.#########.#.#.#########.#.#.#.#######.#.#.#.###.#####.#####.###.#.#########.#",
    "#...#.#...#.....#.#...#.#.........#...###.#.#...###...#.#.#.#.#.........#...#.#...#####.#...#.#...#...#.#.#...#.....#...#...#...#...#.......#",
    "###.#.#####.#####.###.#.#.#########.#.###.#.#.#.###.#.#.#.#.#.#########.#####.#.#.#####.#####.#.#.#.###.#.###.#####.###.#.###.#####.#.#######",
    "###...###...#...#...#.#.#...#.......#...#.#.#.#.#...#...#.#.#.#.....#...#.....#.#...#...#.....#.#.#.#...#.#...#...#.#...#.#...#.....#.......#",
    "#########v###.#.###.#.#.###.#.#########.#.#.#.#.#.#######.#.#.#.###.#.###.#####.###.#.###.#####.#.#.#.###.#.###.#.#.#.###.#.###.###########.#",
    "#.......#.>...#...#.#.#.#...#.#...#.....#.#.#.#.#.......#.#.#.#...#.#...#.#...#.#...#.#...#...#.#.#.#...#.#...#.#...#...#.#...#.#...........#",
    "#.#####.#v#######.#.#.#.#.###.#.#.#.#####.#.#.#.#######.#.#.#.###.#.###.#.#.#.#.#.###.#.###.#.#.#.#.###.#.###.#.#######.#.###.#.#.###########",
    "#...#...#.#.......#.#.#.#...#.#.#...#####.#.#.#.#...#...#...#...#.#...#.#.#.#.#.#.>.>.#...#.#.#.#.#.#...#...#.#.....#...#.#...#.#.###...#...#",
    "###.#.###.#.#######.#.#.###.#.#.#########.#.#.#.#.#.#.#########.#.###.#.#.#.#.#.###v#####.#.#.#.#.#.#.#####.#.#####.#.###.#.###.#.###.#.#.#.#",
    "#...#.....#.....#...#.#.#...#.#.###...#...#.#.#...#.#.........#...###...#.#.#...###.....#.#.#.#.#.#.#.>.>...#.#...#.#.#...#.....#.....#...#.#",
    "#.#############.#.###.#.#.###.#.###.#.#.###.#.#####.#########.###########.#.###########.#.#.#.#.#.#.###v#####.#.#.#.#.#.###################.#",
    "#.....#.......#.#.#...#.#.....#...#.#.#...#.#...#...#####...#.......#.....#.......###...#.#.#.#.#.#...#...#...#.#.#.#.#...#.................#",
    "#####.#.#####.#.#.#.###.#########.#.#.###.#.###.#.#######.#.#######.#.###########.###.###.#.#.#.#.###.###.#.###.#.#.#.###.#.#################",
    "#...#...#...#.#.#.#.###...#.......#.#.#...#.....#.#...>.>.#.#.......#...#...#.....#...###...#...#.#...#...#.#...#.#.#...#.#...#...#.........#",
    "#.#.#####.#.#.#.#.#.#####.#.#######.#.#.#########.#.###v###.#.#########.#.#.#.#####.#############.#.###.###.#.###.#.###.#.###.#.#.#.#######.#",
    "#.#.#...#.#...#.#.#...#...#...>.>.#.#.#.#.........#.###...#.#.........#.#.#.#.#.....#...###...###.#...#...#...###.#.#...#.#...#.#.#.#.......#",
    "#.#.#.#.#.#####.#.###.#.#######v#.#.#.#.#.#########.#####.#.#########.#.#.#.#.#.#####.#.###.#.###.###.###.#######.#.#.###.#.###.#.#.#.#######",
    "#.#...#...#...#...###.#.#####...#.#.#.#.#...#.....#.#.....#...........#.#.#.#.#.......#...#.#...#...#.###.......#.#.#.#...#.....#...#.......#",
    "#.#########.#.#######.#.#####.###.#.#.#.###.#.###.#.#.#################.#.#.#.###########.#.###.###.#.#########.#.#.#.#.###################.#",
    "#.#...#.....#.......#...###...###...#.#.###...###...#...#...#.........#.#.#.#.#...........#.#...###...###.......#...#...###.................#",
    "#.#.#.#.###########.#######.#########.#.###############.#.#.#.#######.#.#.#.#.#.###########.#.###########.#################.#################",
    "#.#.#.#.#...........###...#.........#...#...#...###...#.#.#.#.#.......#.#.#...#.......#.....#.###.......#.........#...#...#.#...............#",
    "#.#.#.#.#.#############.#.#########.#####.#.#.#.###.#.#.#.#.#.#.#######.#.###########.#.#####.###.#####.#########.#.#.#.#.#.#.#############.#",
    "#.#.#.#.#...........#...#...........#...#.#.#.#.....#...#.#...#.......#...#...#.....#...#...#...#.....#.#.........#.#...#.#...#.............#",
    "#.#.#.#.###########.#.###############.#.#.#.#.###########.###########.#####.#.#.###.#####.#.###.#####.#.#.#########.#####.#####.#############",
    "#.#.#...###.........#.....#.......###.#.#.#.#.............#...#.......#.....#.#...#.#.....#.....#...#.#.#.#...#...#.....#.#...#.....#.......#",
    "#.#.#######v#############.#.#####.###.#.#.#.###############.#.#.#######.#####.###.#.#.###########.#.#.#.#v#.#.#.#.#####.#.#.#.#####.#.#####.#",
    "#...#.....#.>...###.....#...#...#...#.#.#.#.#.....#.........#...#...###.....#...#.#.#.........#...#...#.>.>.#...#.#.....#.#.#.#...#.#.#.....#",
    "#####.###.#v###.###.###.#####.#.###.#.#.#.#.#.###.#.#############.#.#######.###.#.#.#########.#.#########v#######.#.#####.#.#.#.#.#.#.#.#####",
    "#...#...#.#.###...#.#...#...#.#.....#.#.#.#.#...#.#.........#.....#...#...#...#.#.#.###.......#.......#...###.....#.....#...#.#.#.#...#.....#",
    "#.#.###.#.#.#####.#.#.###.#.#.#######.#.#.#.###.#.#########v#.#######.#.#.###.#.#.#.###.#############.#.#####.#########.#####.#.#.#########.#",
    "#.#.#...#...#.....#.#.###.#.#.#...#...#.#.#...#.#.#...#...>.>.#.......#.#.#...#.#.#...#.........#.....#.....#.###...#...#...#.#.#...........#",
    "#.#.#.#######.#####.#.###.#.#v#.#.#.###.#.###.#.#.#.#.#.###v###.#######.#.#.###.#.###.#########.#.#########.#.###.#.#.###.#.#.#.#############",
    "#.#.#.....###.....#.#...#.#.>.>.#.#...#.#.#...#.#...#.#.###.#...###...#.#.#...#.#.#...###.......#.#...#.....#...#.#...#...#...#.............#",
    "#.#.#####.#######.#.###.#.###v###.###.#.#.#.###.#####.#.###.#.#####.#.#.#.###.#.#.#.#####v#######.#.#.#.#######.#.#####.###################.#",
    "#.#.....#.......#.#...#...###...#...#.#.#.#.#...#.....#.#...#.....#.#.#.#...#.#.#.#...#.>.>.#...#.#.#.#.......#.#.#.....#...#...#...........#",
    "#.#####.#######.#.###.#########.###.#.#.#.#.#.###.#####.#.#######.#.#.#.###.#.#.#.###.#.#v#.#.#.#.#.#.#######.#.#.#.#####.#.#.#.#.###########",
    "#.#...#.......#.#.#...###.......###...#.#.#.#...#.....#.#...###...#.#.#...#...#.#.#...#.#.#...#...#.#.#...#...#.#.#.....#.#.#.#.#...#.......#",
    "#.#.#.#######.#.#.#.#####.#############.#.#.###.#####.#.###.###.###.#.###.#####.#.#.###.#.#########.#.#.#.#.###.#.#####.#.#.#.#.###v#.#####.#",
    "#...#.......#.#.#.#.#.....#.........###...#...#.....#...###...#.....#.#...#.....#.#.#...#...###.....#...#...#...#.#.....#.#.#.#.#.>.#.#.....#",
    "###########.#.#.#.#.#.#####.#######.#########.#####.#########.#######.#.###.#####.#.#.#####.###.#############.###.#.#####.#.#.#.#.#v#.#.#####",
    "#...........#.#.#...#.......#.......#.......#.#...#.#.....#...#.......#.###.....#.#...#...#.#...#.....#.....#.#...#.......#.#.#.#.#...#.....#",
    "#.###########.#.#############.#######.#####.#.#.#.#.#.###.#.###.#######.#######.#.#####.#.#.#.###.###.#.###.#.#.###########.#.#.#.#########.#",
    "#.#.........#...#.............#...###.#.....#...#...#...#...###...#...#.......#.#.#.....#...#.....#...#.#...#...#...........#.#.#.#.........#",
    "#.#.#######.#####.#############.#.###.#.###############.#########.#.#.#######.#.#.#.###############.###.#.#######.###########.#.#.#.#########",
    "#...#...#...#...#...#.....#.....#...#.#...#...#.....#...#.......#...#.#.......#...#.........#.....#.....#.......#.....#...#...#...#.........#",
    "#####.#.#.###.#.###.#.###.#.#######.#.###.#.#.#.###.#.###.#####.#####.#.###################.#.###.#############.#####.#.#.#.###############.#",
    "#.....#...#...#...#.#...#...#.......#.#...#.#.#...#.#.....#.....#...#.#...#...#.............#...#...........#...#...#...#...#...............#",
    "#.#########.#####.#.###.#####.#######.#.###.#.###.#.#######.#####.#.#.###.#.#.#.###############.###########.#.###.#.#########.###############",
    "#...........#.....#.....#...#...#.....#...#.#.#...#.#.....#.....#.#.#.....#.#.#...............#...........#...###.#.###...#...#.............#",
    "#############.###########.#.###.#.#######.#.#.#.###.#.###.#####.#.#.#######.#.###############.###########.#######.#.###.#.#.###.###########.#",
    "#.............#...###...#.#...#.#.#.......#.#.#...#.#.#...#.....#.#.###...#.#...#...#...#...#...#.........#.......#...#.#.#.....###.........#",
    "#.#############.#.###.#.#.###.#.#.#.#######.#.###.#.#.#.###v#####.#.###.#.#.###.#.#.#.#.#.#.###.#.#########.#########.#.#.#########.#########",
    "#...............#.###.#.#...#.#...#.#...#...#.....#...#...>.>...#.#.#...#.#.#...#.#.#.#.#.#.....#.....#...#.....#.....#.#.....#.....#.......#",
    "#################.###.#.###.#.#####v#.#.#.#################v###.#.#.#.###.#.#.###.#.#.#.#.###########.#.#.#####.#.#####.#####.#.#####.#####.#",
    "#...#...#.........#...#.#...#...#.>.>.#...###.............#.#...#.#.#...#.#.#.###.#.#.#...###.........#.#.....#.#.#...#.....#.#.......#.....#",
    "#.#.#.#.#.#########.###.#.#####.#.#v#########.###########.#.#.###.#.###.#.#.#.###.#.#.#######.#########.#####.#.#.#.#.#####.#.#########.#####",
    "#.#...#...#.......#...#...#...#...#.#...#...#.....#.....#.#.#...#.#.#...#.#.#.....#...###...#...........#.....#.#.#.#...###.#.#.....###.....#",
    "#.#########.#####.###.#####.#.#####.#.#.#.#.#####.#.###.#.#.###.#.#.#.###.#v#############.#.#############.#####.#.#.###.###.#.#.###.#######.#",
    "#.#...#...#.....#...#.#.....#.......#.#...#...###.#.#...#.#.###.#.#...###.>.>...###.....#.#.#...#.........#...#.#.#...#.###.#.#...#.#...#...#",
    "#.#.#.#.#v#####.###.#.#.#############.#######.###.#.#.###.#.###.#.#########v###.###.###.#.#.#.#.#.#########.#.#.#.###.#.###.#.###.#.#.#.#v###",
    "#.#.#...#.>.#...#...#.#...#...#...#...###...#...#...#...#...#...#.........#...#...#...#.#.#.#.#.#...#...#...#...#.#...#.#...#...#.#.#.#.>.###",
    "#.#.#####v#.#.###.###.###.#.#.#.#.#.#####.#.###.#######.#####.###########.###.###.###.#.#.#.#.#.###v#.#.#.#######.#.###.#.#####.#.#.#.###v###",
    "#...###...#...###...#.#...#.#.#.#...#.....#...#.#.......#...#...#.........###...#.....#.#.#.#.#...>.>.#.#...#.....#...#.#...###.#.#...###...#",
    "#######.###########.#.#.###.#.#.#####.#######.#.#.#######.#.###.#.#############.#######.#.#.#.#####v###.###.#.#######.#.###.###.#.#########.#",
    "#.......#...#...###...#...#.#.#.#.....#...###...#.......#.#.....#.#.....###...#.......#...#...#.....###...#.#...#...#.#.#...#...#.#.........#",
    "#.#######.#.#.#.#########.#.#.#.#.#####.#.#############.#.#######.#.###.###.#.#######.#########.#########.#.###.#.#.#.#.#.###.###.#.#########",
    "#.........#...#.....#...#...#.#.#...#...#...#.....#.....#.....#...#.#...#...#.#.......###.......#.......#...###...#.#.#.#...#.#...#...#.....#",
    "###################.#.#.#####.#.###.#.#####.#.###.#.#########.#.###.#.###.###.#.#########.#######.#####.###########.#.#.###.#.#.#####.#.###.#",
    "###...#.............#.#...###...###.#.#.....#.#...#...#...###...###.#.#...#...#...###...#.....#...#.....#.........#.#.#.....#...#####...#...#",
    "###.#.#.#############.###.#########.#.#.#####.#.#####v#.#.#########.#.#.###.#####.###.#.#####.#.###.#####.#######.#.#.###################.###",
    "#...#...#...........#.#...#...#...#...#...#...#.#...>.>.#...###...#.#.#...#.#...#.....#.#...#.#.#...#...#.#.......#.#.#...#####...#...#...###",
    "#.#######.#########.#.#.###.#.#.#.#######.#.###.#.###v#####.###.#.#.#.###.#.#.#.#######v#.#.#.#.#.###.#.#.#.#######.#.#.#.#####.#.#.#.#.#####",
    "#...#...#.#.........#.#...#.#.#.#.#...###.#.###.#.###.#...#...#.#.#.#...#.#.#.#.....#.>.>.#.#...#.....#...#.......#...#.#...#...#.#.#.#.....#",
    "###.#.#.#.#.#########.###.#.#.#.#.#.#.###v#.###.#.###.#.#.###.#.#.#.###.#.#.#.#####.#.#v###.#####################.#####.###.#.###.#.#.#####.#",
    "###...#...#.........#...#.#.#.#.#.#.#...>.>.#...#...#...#.###.#.#.#...#.#.#...#...#...#.#...#.....................#...#...#.#...#.#.#.###...#",
    "###################.###.#.#.#.#.#.#.#####v###.#####.#####.###.#.#.###.#.#.#####.#.#####.#.###.#####################.#.###.#.###.#.#.#.###v###",
    "#.........#...#.....#...#...#.#.#.#.###...###.#...#...#...#...#.#.#...#.#.#.....#.###...#...#.......#...............#.###.#.#...#...#...>.###",
    "#.#######.#.#.#.#####.#######.#.#.#.###.#####.#.#.###.#.###.###.#.#.###.#.#.#####.###.#####.#######.#.###############.###.#.#.###########v###",
    "#.......#.#.#...#...#.......#...#...#...#####...#.....#...#...#.#.#...#...#.....#.#...#...#...#...#...###...#...#.....#...#.#.#...#...#...###",
    "#######.#.#.#####.#.#######.#########.###################.###.#.#.###.#########.#.#.###.#.###.#.#.#######.#.#.#.#.#####.###.#.#.#.#.#.#.#####",
    "#.......#...#...#.#.#...#...#.........#.....#.............#...#.#.#...###...#...#.#.....#.###...#.#.....#.#...#...###...###...#.#...#...#...#",
    "#.###########.#v#.#.#.#.#.###.#########.###.#.#############.###.#.#.#####.#.#.###.#######.#######.#.###.#.###########.#########.#########.#.#",
    "#.......#...#.#.>.#.#.#.#...#...........#...#.............#...#.#.#...#...#.#...#.........#.......#.#...#.......###...#...#...#...........#.#",
    "#######.#.#.#.#v###.#.#.###.#############.###############.###.#.#.###.#.###.###.###########.#######.#.#########v###.###.#.#.#.#############.#",
    "#.......#.#...#...#.#.#.#...#.............#...#...........###...#...#.#...#...#.........###...#...#.#.#.......>.>...#...#.#.#.###...#.......#",
    "#.#######.#######.#.#.#.#.###.#############.#.#.###################.#.###.###.#########.#####.#.#.#.#.#.#######v#####.###.#.#.###.#.#.#######",
    "#.........#...#...#...#.#...#.#...#.......#.#.#...................#...#...#...#...#.....#...#...#.#.#...#...#...#...#...#...#.....#...#...###",
    "###########.#.#.#######.###.#.#.#.#.#####.#.#.###################.#####.###.###.#.#.#####.#.#####.#.#####.#.#.###.#.###.###############.#.###",
    "#...........#...#...###.....#.#.#...#...#.#.#.#.....#.............#...#...#.#...#.#.......#.###...#.#...#.#.#.....#...#...#...........#.#...#",
    "#.###############.#.#########.#.#####.#.#.#.#.#.###.#.#############.#.###.#.#.###.#########.###.###.#.#.#.#.#########.###.#.#########.#.###.#",
    "#.....#.....###...#.........#...#.....#...#.#.#...#.#.............#.#.....#...#...#...#...#...#.#...#.#.#.#.#...#...#.###...#.........#.#...#",
    "#####.#.###.###.###########.#####.#########.#.###.#.#############.#.###########.###.#.#.#.###.#.#.###.#.#.#.#.#.#.#.#.#######.#########.#.###",
    "#.....#.#...#...#...........#...#.....###...#...#.#.#...#.........#...#.......#.#...#...#...#.#...#...#.#.#.#.#.#.#...#...###.......#...#...#",
    "#.#####.#v###.###.###########.#.#####.###.#####.#.#.#.#.#.###########.#.#####.#.#.#########.#.#####.###.#.#.#.#.#.#####.#.#########.#.#####.#",
    "#.......#.>.#...#.#.........#.#.#...#...#...#...#.#.#.#.#.#...###...#...#.....#...#...#...#...#.....###...#...#...#...#.#.#...#.....#.#.....#",
    "#########v#.###.#.#.#######.#.#.#.#.###.###.#.###.#.#.#.#v#.#.###.#.#####.#########.#.#.#.#####.###################.#.#.#.#.#.#.#####.#.#####",
    "#.....#...#...#.#.#...#.....#.#.#.#.#...#...#.#...#.#.#.>.>.#...#.#.#...#...#...#...#.#.#...###.......#...#.....#...#.#.#.#.#.#.......#.....#",
    "#.###.#.#####.#.#.###.#.#####.#.#.#.#v###.###.#.###.#.###v#####.#.#.#.#.###.#.#.#.###.#.###.#########.#.#.#.###.#.###.#.#.#.#.#############.#",
    "#...#.#.....#...#...#.#...#...#.#.#.>.>...###.#...#.#.#...#.....#.#...#.....#.#.#...#...#...#.........#.#.#.#...#.#...#.#.#.#.###...........#",
    "###.#.#####.#######.#.###.#.###.#.###v#######.###.#.#.#.###.#####.###########.#.###.#####.###.#########.#.#.#.###.#.###.#.#.#.###v###########",
    "#...#.......###...#...###.#...#.#.###...#...#.#...#...#...#.#...#...#...#...#.#.###...#...###.......###.#.#.#...#.#...#.#.#.#.#.>.#.........#",
    "#.#############.#.#######.###.#.#.#####.#.#.#.#.#########.#.#.#.###.#.#.#.#.#.#.#####.#.###########v###.#.#.###.#.###.#.#.#.#.#.#v#.#######.#",
    "#.....#.....#...#.....#...#...#.#.#.....#.#.#...#.....###.#.#.#...#...#...#.#.#.#...#.#.#...#...#.>.>...#.#.#...#...#.#.#.#.#.#.#.#.#.......#",
    "#####.#.###.#.#######.#.###.###.#.#.#####.#.#####.###.###.#.#.###.#########v#.#.#.#.#.#.#.#.#.#.#.#v#####.#.#.#####.#.#.#.#.#.#.#.#.#.#######",
    "#.....#.#...#.#.......#...#...#...#.......#.#...#...#.#...#...#...#...#...>.>.#...#...#.#.#...#.#.#.....#...#...#...#...#.#.#...#...#.......#",
    "#.#####.#.###.#.#########.###.#############.#.#.###.#.#.#######.###.#.#.###v###########.#.#####.#.#####.#######.#.#######.#.###############.#",
    "#...#...#.....#.......#...#...#.............#.#.#...#.#...#...#...#.#.#.###.........#...#.....#...#...#.......#.#...#...#.#...###...#.......#",
    "###.#.###############.#.###.###.#############.#.#.###.###.#.#.###.#.#.#.###########.#.#######.#####.#.#######.#.###.#.#.#.###.###.#.#.#######",
    "###...#...###.........#.....###.#...........#.#.#...#...#...#...#...#...#...........#...#...#.#.....#.........#.#...#.#.#.....#...#...#.....#",
    "#######.#.###.#################.#.#########.#.#.###.###.#######.#########.#############.#.#.#.#.###############.#.###.#.#######.#######.###.#",
    "#.......#...#...........#...###...#.......#...#...#...#.........#.....###.............#.#.#.#.#.......#...#...#...###.#.#.....#...#.....#...#",
    "#.#########.###########.#.#.#######.#####.#######.###.###########.###.###############.#.#.#.#.#######.#.#.#.#.#######.#.#.###.###.#.#####.###",
    "#.......#...#...........#.#...#.....#...#.........###.......#.....#...#...............#...#...#.....#.#.#...#.....###.#.#...#.....#.#.....###",
    "#######.#.###.###########.###.#.#####.#.###################.#.#####.###.#######################.###.#.#.#########.###.#.###.#######.#.#######",
    "#.......#...#.....#...###.#...#.......#.........###.........#...#...###...........#...#...#...#...#.#...#.........#...#...#.........#.......#",
    "#.#########.#####.#.#.###.#.###################.###.###########.#.###############.#.#.#.#.#.#.###.#.#####.#########.#####.#################.#",
    "#.#...#...#.......#.#.#...#...###...#...........#...#.......###.#.###.............#.#...#...#.#...#.......###.....#.....#.#.....#.......#...#",
    "#.#.#.#.#.#########.#.#.#####.###.#.#.###########.###.#####v###.#.###.#############.#########.#.#############.###.#####.#.#.###.#.#####.#.###",
    "#...#...#...........#...#.....#...#.#.......#...#.....###.>.>.#.#...#...#.......#...#.........#...............#...#...#.#.#.#...#.....#.#...#",
    "#########################.#####.###.#######.#.#.#########.###.#.###.###.#.#####.#.###.#########################.###.#.#.#.#.#.#######v#.###.#",
    "#...................#...#...###...#.#.......#.#.###.......###.#.###...#...#.....#.#...###...#...#...#...........#...#.#.#...#.....#.>.#...#.#",
    "#.#################.#.#.###.#####.#.#.#######.#.###.#########.#.#####.#####.#####.#.#####.#.#.#.#.#.#.###########.###.#.#########.#.#v###.#.#",
    "#...#...#...#.....#...#.#...#.....#.#.......#.#...#.....###...#.....#...###.......#.....#.#.#.#.#.#.#.....#...#...#...#...###...#.#.#...#...#",
    "###.#.#.#.#.#.###.#####.#.###.#####.#######.#.###.#####.###.#######.###.###############.#.#.#.#.#.#.#####v#.#.#.###.#####.###.#.#.#.###.#####",
    "###...#...#...###...###...###.#...#.........#...#.#...#...#...#.....###...###...........#.#.#.#.#.#...#.>.>.#.#...#...#...#...#...#...#...###",
    "###################.#########.#.#.#############.#.#.#.###.###.#.#########.###.###########.#.#.#.#.###.#.#####.###.###.#.###.#########.###.###",
    "#####...............#...#...#...#...#...###...#.#...#.#...###.#...#.....#...#...........#.#.#.#.#...#.#.#...#...#.#...#.#...#.....#...###...#",
    "#####.###############.#.#.#.#######.#.#.###.#.#.#####.#.#####.###.#.###.###.###########.#.#.#.#.###.#.#.#.#.###.#.#.###.#.###.###.#.#######.#",
    "#.....#...#...#.....#.#...#.#...#...#.#...#.#.#.....#...#...#.#...#...#.#...#...#.......#.#...#.#...#.#...#...#...#.#...#.....###...#...###.#",
    "#.#####.#.#.#.#.###.#.#####.#.#.#.###.###.#.#.#####.#####.#.#.#.#####.#.#.###.#.#.#######.#####.#.###.#######.#####.#.###############.#.###.#",
    "#...#...#...#...#...#.#.....#.#.#.....#...#.#.#...#.......#.#.#.#.....#...###.#.#.....###.....#...###.#...#...#.....#.........#.......#.....#",
    "###.#.###########.###.#.#####.#.#######v###.#.#.#.#########.#.#.#.###########.#.#####v#######.#######.#.#.#.###.#############.#.#############",
    "#...#.#...........#...#.#...#.#.#...#.>.>.#.#.#.#.#...#...#.#.#.#...#.....#...#.#...>.>.#...#.....#...#.#.#.#...#...#...#...#.#.......#.....#",
    "#.###.#.###########.###.#.#.#.#.#.#.#.###.#.#.#.#.#.#.#.#.#.#.#.###.#.###.#.###.#.#####.#.#.#####.#.###.#.#.#.###.#.#.#.#.#.#.#######.#.###.#",
    "#.....#.............###...#...#...#...###...#...#...#...#...#...###...###...###...#####...#.......#.....#...#.....#...#...#...#######...###.#",
    "###########################################################################################################################################.#"
)