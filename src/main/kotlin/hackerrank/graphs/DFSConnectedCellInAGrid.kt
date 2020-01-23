package hackerrank.graphs

import kotlin.math.max

fun maxRegion(grid: Array<Array<Int>>): Int {

    var result = 0
    val visited = Array(grid.size) {
        Array(grid.first().size) {
            false
        }
    }

    grid.indices.forEach { row ->
        grid.first().indices.forEach inner@{ col ->
            if (visited[row][col]) return@inner

            val size = calculateRegion(
                grid,
                visited,
                row,
                col
            )

            result = max(result, size)
        }
    }

    return result
}

fun calculateRegion(
    grid: Array<Array<Int>>,
    visited: Array<Array<Boolean>>,
    row: Int,
    col: Int
): Int {

    if (0 > row || row >= grid.size) return 0
    if (0 > col || col >= grid.first().size) return 0
    if (grid[row][col] == 0) return 0
    if (visited[row][col]) return 0

    visited[row][col] = true
    var count = 1

    (row - 1..row + 1).forEach { r ->
        (col - 1..col + 1).forEach { c ->
            count += calculateRegion(grid, visited, r, c)
        }
    }

    return count
}
