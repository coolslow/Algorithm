package com.coolslow.leetcode.topics.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 * by MrThanksgiving
 */
public class Code200NumberOfIslands {

    /**
     * <pre>
     * 题目：
     *      给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
     *      一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
     *      你可以假设网格的四个边均被水包围。
     *
     * 示例 1:
     *      输入:
     *      11110
     *      11010
     *      11000
     *      00000
     *      输出: 1
     *
     * 示例 2:
     *      输入:
     *      11000
     *      11000
     *      00100
     *      00011
     *      输出: 3
     *
     * </pre>
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int numbers = 0, rc = grid.length, cc = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int r = 0; r < rc; r++) {
            for (int c = 0; c < cc; c++) {
                if (grid[r][c] == '1') {
                    numbers++;
                    queue.add(r * cc + c);
                    while (!queue.isEmpty()) {
                        int index = queue.poll();
                        int i = index / cc;
                        int j = index % cc;
                        grid[i][j] = '0';
                        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                            queue.add((i - 1) * cc + j);
                            grid[i - 1][j] = '0';
                        }
                        if (i + 1 < rc && grid[i + 1][j] == '1') {
                            queue.add((i + 1) * cc + j);
                            grid[i + 1][j] = '0';
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                            queue.add(i * cc + j - 1);
                            grid[i][j - 1] = '0';
                        }
                        if (j + 1 < cc && grid[i][j + 1] == '1') {
                            queue.add(i * cc + j + 1);
                            grid[i][j + 1] = '0';
                        }
                    }
                }
            }
        }
        return numbers;
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int numbers = 0, rc = grid.length, cc = grid[0].length;
        for (int r = 0; r < rc; r++) {
            for (int c = 0; c < cc; c++) {
                if (grid[r][c] == '1') {
                    numbers++;
                    dfs(grid, r, c);
                }
            }
        }
        return numbers;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (grid == null || //
                r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || //
                grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

}
