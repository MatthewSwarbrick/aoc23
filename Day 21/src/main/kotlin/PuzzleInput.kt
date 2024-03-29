val sample = listOf(
    "...........",
    ".....###.#.",
    ".###.##..#.",
    "..#.#...#..",
    "....#.#....",
    ".##..S####.",
    ".##..#...#.",
    ".......##..",
    ".##.#.####.",
    ".##..##.##.",
    "..........."
)

val input = listOf(
    "...................................................................................................................................",
    "......#...........#................#......................................#.....#......#..##.#.......#....#.#........#...##...#....",
    "...........#.................##...#...##......#............#...........##..#....................#.................#......#....#..#.",
    ".....#.........#.....#.#.....###........###........#..........................##..##.......#.......#.....#...............#.......#.",
    "....#..#......#......................#......#...............................#...........#........................#.............#...",
    ".......#.....................#.............#......#...............#....................#............#.#.........#..#...............",
    ".#.#.....#....#...................##......#..#..................#............................................#...............#.....",
    ".....#....#...#....##...#......#.............#......##........#................#................#................#...............#.",
    ".......#...................#..........#......................................#.........................##.........#..#.#..#........",
    "....#..........#.........#....#......##...........##.................#................#...#............#...#..##....#...........#..",
    "...#..........###............#.............#........................##..................#...##..................##......#...#......",
    ".......#.......#.#..#.......#.......##..........#.........#..............................##.....#..#..........#.....#......#.......",
    "..#.........#.....#..#..#..#..................#.........................#......................#.#..#...#..........#.....#....##.#.",
    "..................................#.....#................#........#..........................#........#.....#...............#....#.",
    "..........#..........#.#.................#.#.........................................#.......#..........#..##...#......#...........",
    ".........#........#...........#...#.#....#.................##..#....................#..........#....#.#....##........#.......#.....",
    "....#........#....................##..#......................#......#.........................#..#............................#....",
    "...#.#...#...#......................#..#..........................#...#.#...............#......#.#........#....#..........#.....#..",
    "..............#.....#.#......#........#...#..........#..#.#..#.........................#.....#..#......#.......#......#.......#....",
    ".......................#.....#.....#................................##...#..#...#...........#..#..........#..#.#...#.........#...#.",
    ".........#........#......#..#................................#.##.........#...#.................##......#.........#.##...#...#.....",
    ".#.#.........##....#..........#..##.....................#..##...#..#..#...#.......#...........................#....................",
    ".#.#......#..#..............##.#...#.#.............#.........#..............#.....#...............#..........................#...#.",
    ".....##.....#.....##..#...#..#..#......................................#......#.............#.............#.....#......#........#..",
    "......................#........#................#.......#..........#.............##............#..........#....#............#......",
    ".....#..............................#.......##......#..#....#..............#.....................................#.....#.........#.",
    "....................##...........#................#.#.....#.............#......#..##...#....................#................#.#...",
    ".................................#...........#.....#..#..#..............#..##.........#..............#......#................#.....",
    "............##.................................#..#...##.#........#...................................#...........#.#........#...#.",
    "...#.......#.#........#......#...........#....#..#.......#....#........#.#.#.............##.......#.................#..............",
    "...###............#......................##..##.........................#.........#......#..............#..#............#..........",
    "..#.......#...##...#..#.......#.......#...#...........................................#...................#........##....#..#......",
    "..#..................#.....#...........#.................#.#.#...........#..................#............#.......#.................",
    "...##..#.............#.....#.....................#................#..........................#.............##...............#......",
    "............#....#....#...#............#....#...........#.#.................#....#..................................#..............",
    "...#.....#.............#...........................#.....##..........#...............#....#...............#........................",
    "......#.....##.........#..........##..#...............#....#..#.#.#.....#.............#.###..............#..#......................",
    "....................#...#...............#....................#...............#.#.#..##.............................#...............",
    "...................#...#...........#...#.#...#...........#..............#............#..#......#............#.............#......#.",
    "...#................#.................#.....#..........#........#.#........#...................#..#...........#.##........#......#.",
    "....................#..........#....................#....#...#.....................#.......#.................#......#........#.....",
    "...#.........#...................#.......##...###......#..#.......#.#..................#............#...........#....#...........#.",
    "......#..#.#...#.#...............#.......................#.........#.......##................#...................#.###.............",
    "...............#..............................................#.....#....#...#..#...#.....#......#.....#...........................",
    ".......#.......#..........#.#.#..#.....#...#......#.................#........#...#..#.#.......#....................................",
    "...........#..#.....................#.........................#...#.#.....#..........#....##.....#.................................",
    ".......#.#.#.#..........#...#.##.##..#....................#.#.#..............#...................#....##...........................",
    ".........................#.#.#...................#......#......#.............#.....#..............#......###..............#.#......",
    "......#...............#...........#...................##..............#.##..#.#.#.#.#......#.....#.##.......#............#.#....##.",
    ".....#....#.............#..##........###...#.......#.....#....#.......###....................#..#.#............................#...",
    ".#........................#.....#......#.#.....................#......#.#...........#..#.....#.#.#..........#..............#...#...",
    ".....##...#.........#.#.#.#...................#..#..#.#..#...#..#.....#.#.....#.........##.........................................",
    ".................#.#...............#...............#...........#...........#.....#..........#...#.............................#....",
    ".......................##...........#..........#...............#..#......................................#...#................#..#.",
    "......#......................#..##.#........#.............#.....#..#....................#......#.........#.....#...#...........#.#.",
    ".....................#.................#....##..#....#....##..#..............#..............#.....#...............#................",
    ".#.................##.....#.#....#.....................#.............#....#......#...................#.#.##....................#...",
    ".##..........##....#.##......#..#.................#...#..##........#....#..#.......#..............#.......#........................",
    "......................#...........###.#.....##.............##........#..................#..............................#........#..",
    "..#........................#...................#.#.#...#........#........#....#.....#.....#........................#...............",
    ".#...........................#........#.....................#.....##.#..#.....#......#....#...#............##......................",
    "............#...#..#..........#..............#...#...#..#..........#.........#...............#....#.#......#.#...#.................",
    "..............................#..##...............#.....#....#.........................#....#...#....#.....#....#..................",
    "..................#.#.........................#.......#........#.......#..##....#...#....#..................................#......",
    "..........................#..#...#....................................#......#...#...#..#...#....#.............#.#.................",
    ".................................................................S.................................................................",
    "..............#...#...#.....##....#..................#....#........##..#.....#.#...#.#..............#.................##...........",
    ".........##.........#............##.............................#.#...#.#.......#..........####....#...........#...........#.......",
    ".........#...............................#...............#........................#......#..#......#.............##................",
    ".............#..............................#...#.................#..........###.#.#.#.........#........#..........................",
    ".#........#..#...........##...........#.#..........................#.........#....#.............#.............##...................",
    "..#..........#..........................#...#..#..#.##...#..............#.....#...#............##........#.#.......#............#..",
    ".................#.........#.......#.......#............#.#.................##...#.##.....................#.....#..................",
    ".#.##..........#...#...................#...#.....##.....#...............#..#.........#..............#.................#............",
    ".....#.......#..##....#..........#........#.#.....#.........#...............##......#.#....#.....#.................#...............",
    "......#.......#.#...#....................#...............#.........#....#..#.#..........##.....#...#........................#......",
    ".#.................#.................#.#....................#..............#.................#......#.......#.....#................",
    ".#..#................................#......#..........#..............#.#.##.......................#...............................",
    "..#.#............#.#......#...............#.#....#...#.#..#.......#...#.....#.......#........#.#...........#...#............##.....",
    ".......#..........#....#....................#................##...........#......#..#...#....#...#......................#...#.#....",
    ".........##........#........#......#.......#........#..#................#..#.............#..................#.#..........#.........",
    "......#....#.................................#..#.#....#..............#........#.....#.##........#..........#.............#....#...",
    ".............#........#.........#...##.....#.....#................##..........#.......#....#.......................................",
    "..........................#.....#..#......#....#....#..##...#.......................#..............#.......#..........#..#......#..",
    "...#.......................#....#.......#......#..................#................#...##........##.#............................#.",
    "....#....................#.####..........#......#.....#......#....#.#.#................#...#..............#.............#.....#....",
    "..........#..#...#..............##..#..#..#..........#.......#.##........##..............#.....#......#............#...#...........",
    "..........................#..#..............#..#....#..#..............#.#...#..........#.....#..#.#................................",
    ".......#.......#...............#.........#..#.#...#.....................#.....#......................#..............#.#..#.........",
    "........#.....#.............#....................#.#........#.................#.....#...#..........#............#...............#..",
    ".............#....##.........#.#................#....#.........#...#.......................#.....#.#..................#......#.....",
    "...............#.....#.............#.....#.......#.......#......#.#..#.....#...#...#.......#................#...#................#.",
    "...................#..#...........#..###....................#......#........#......#...........................#......#.......#....",
    "..#.....#.##......#................#.................#.................##....................#.#...........#....#.#...#........#...",
    "....#......#.#..#........#..............#.......#.........#.................#.............#.#...#...........#.#................#...",
    "..#....#.#.......#...#.................#......#....#................#.......................#...#.........##..........#.........#..",
    "..............#...............................#.##..............................#.......#..#...#...................#...#........#..",
    ".#..#....#......#.....#...#............#..............................#..............#....................#..##..............#..##.",
    ".......##............#..#............######............#................#..........#.#...#...#................#....................",
    "...#..................##....................#.......#.#....##...................##..#....#..#..........#.....#.....................",
    "...#.....#..#..#.#.......................#......................#...........#......###...#.............#........................#..",
    ".....#.............#..........#......................#....#............#.##....#.......#.............#..........#........##........",
    "........#...#.#..................#........#.#......#........#.....##...#...#....#...#......................................#.......",
    "...............#............#..#.......................##.#.....#...#.#........#..................#......#.........................",
    ".............##..#.......#.#.....#............#............#..........##.......#.....##...............................#...#........",
    ".#..##...............#..............#...........#..#..#...##.......#..#.......................#.......##.....................#.#...",
    ".....................###........#..#.....................#........#...#.##...................#....##.........#.........#...........",
    "...#.....#...............#....#..###.......................................#..................#....................................",
    "...#.#.#.....#..#.........#.....#...##.............#................#......#.....#........................#....#..............#....",
    "...........#......#..##.......#......#..................#.....##..................#........#.......#......#...#...#..#...#.........",
    ".........#.#.........#......#............................#.....#............#.................#..........#..............#.......#..",
    "............#.........#.#....#.......#...................................#..............##.##..............#....#...............#..",
    ".............#.....##.........#.........##...............#...............#.............................###........#.....#.#........",
    "......##..........#....#.#.#..........##.#.#................#...#....##.......................#.......#...#.#........#.#..#........",
    "....#....#............#.#......#..#.........#.............#.#..........................#.......#..............#..#..#.....#........",
    "...................#...........#....#...#..#..#.......#..#...#.#........................#.................#.............#..........",
    ".........#..#...#......#......#......#.................#...........#...................#........#.......#......#.#.......#.......#.",
    "..#..#......#.....................#...........................#.....##................#.............................#..............",
    "..#.#.......#........................#.......#..........................#................#.....#...#.........#.#......#............",
    "...............................#....................................#.......................##....#......#.#.........#.#.........#.",
    ".#.....................#......#..........#......#..............#...............##............#...#.##...#......##...#.#.#..........",
    "...............#.#......#..................#......................................................#........................#.#.....",
    "...#...#..#...............##...#...#.....#...#....................#..#..........#.....##......................................#....",
    ".#..#...#........................#....#...##......#...........#.......................#...##......#.......#................#.......",
    "....#...........#.............#.....#..#..#.....#.................................#........#.#..............#......................",
    "....#....#........#..#.#..............#................................................#..............#................#.........#.",
    ".....#..........#.......#..................#................................................#..............##...#..................",
    "................#...............#..........#............##.........................#........#.#...............#...##...............",
    "........#..................#..#.....#.#.........#.....#.#.#..................#.......#.#......#....#.........#..#.........#...#....",
    "..#...........##...............#...........#..#...#...#.#..................##......#.....#.......#........#..#...#......#........#.",
    "..................................................................................................................................."
    )