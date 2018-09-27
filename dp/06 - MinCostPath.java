/*
https://www.geeksforgeeks.org/min-cost-path-dp-6/

Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns
cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost
to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on
that path (including both source and destination). You can only traverse down, right and diagonally
lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1)
can be traversed. You may assume that all costs are positive integers.

Example:
Input: {{1, 2, 3},
        {4, 8, 2},
        {1, 5, 3}};
The path with minimum cost is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2).
The cost of the path is 8 (1 + 2 + 2 + 3).
*/

class Solution {
    public int minCostPathRecursive(int[][] cost, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        } else if (m == 0 && n == 0) {
            return cost[0][0];
        } else {
            return cost[m][n] + min(
                    minCostPathRecursive(cost, m - 1, n),
                    minCostPathRecursive(cost, m - 1, n - 1),
                    minCostPathRecursive(cost, m, n - 1));
        }
    }

    private int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public int minCostPathIterative(int[][] cost, int m, int n) {
        int[][] cache = new int[m + 1][n + 1];
        cache[0][0] = cost[0][0];
        for (int i = 1; i <= m; i++) {
            cache[i][0] = cost[i][0] + cache[i - 1][0];
        }

        for (int j = 1; j <= n; j++) {
            cache[0][j] = cost[0][j] + cache[0][j - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cache[i][j] = cost[i][j] + min(cache[i - 1][j - 1], cache[i - 1][j], cache[i][j - 1]);
            }
        }

        return cache[m][n];
    }
}
