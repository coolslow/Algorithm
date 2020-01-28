package com.coolslow.leetcode.topics.backtracking;

/**
 * 单词搜索
 * by MrThanksgiving
 */
public class Code79WordSearch {

    /**
     * <pre>
     * 题目：
     *      给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     *      单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     *      同一个单元格内的字母不允许被重复使用。
     *
     * 示例:
     *      board =
     *      [
     *        ['A','B','C','E'],
     *        ['S','F','C','S'],
     *        ['A','D','E','E']
     *      ]
     *
     *      给定 word = "ABCCED", 返回 true.
     *      给定 word = "SEE", 返回 true.
     *      给定 word = "ABCB", 返回 false.
     *
     * </pre>
     */
    private String target;
    private boolean[][] visited;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        this.board = board;
        target = word;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean result = helper(i, j, 0);
                if (result) return true;
            }
        }
        return false;
    }

    public boolean helper(int r, int c, int index) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length) return false;
        if (visited[r][c] || index >= target.length() || board[r][c] != target.charAt(index)) return false;
        if (index == target.length() - 1) return true;
        visited[r][c] = true;
        if (helper(r - 1, c, index + 1)) return true;
        if (helper(r + 1, c, index + 1)) return true;
        if (helper(r, c - 1, index + 1)) return true;
        if (helper(r, c + 1, index + 1)) return true;
        visited[r][c] = false;
        return false;
    }

//    public boolean exist(char[][] board, String word) {
//        if (board == null || board.length == 0 || board[0].length == 0) return false;
//        target = word;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                visited = new boolean[board.length][board[0].length];
//                boolean result = helper(board, Character.toString(board[i][j]), i, j, 0);
//                if (result) return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean helper(char[][] board, String word, int r, int c, int d) {
//        if (board == null || r < 0 || c < 0 ||
//                r >= board.length || c >= board[0].length || visited[r][c]) {
//            return false;
//        }
//        if (target.equals(word)) return true;
//        if (!target.startsWith(word) || word.length() > target.length()) return false;
//        visited[r][c] = true;
//        if (d == 0) {// from init
//            if (c - 1 >= 0) {
//                if (helper(board, word + board[r][c - 1], r, c - 1, 3)) return true;
//            }
//            if (c + 1 < board[r].length) {
//                if (helper(board, word + board[r][c + 1], r, c + 1, 1)) return true;
//            }
//            if (r - 1 >= 0) {
//                if (helper(board, word + board[r - 1][c], r - 1, c, 2)) return true;
//            }
//            if (r + 1 < board.length) {
//                if (helper(board, word + board[r + 1][c], r + 1, c, 4)) return true;
//            }
//        } else if (d == 1) {// from left
//            if (c + 1 < board[r].length) {
//                if (helper(board, word + board[r][c + 1], r, c + 1, 1)) return true;
//            }
//            if (r - 1 >= 0) {
//                if (helper(board, word + board[r - 1][c], r - 1, c, 2)) return true;
//            }
//            if (r + 1 < board.length) {
//                if (helper(board, word + board[r + 1][c], r + 1, c, 4)) return true;
//            }
//        } else if (d == 2) {// from bottom
//            if (r - 1 >= 0) {
//                if (helper(board, word + board[r - 1][c], r - 1, c, 2)) return true;
//            }
//            if (c + 1 < board[r].length) {
//                if (helper(board, word + board[r][c + 1], r, c + 1, 1)) return true;
//            }
//            if (c - 1 >= 0) {
//                if (helper(board, word + board[r][c - 1], r, c - 1, 3)) return true;
//            }
//        } else if (d == 3) {// from right
//            if (r + 1 < board.length) {
//                if (helper(board, word + board[r + 1][c], r + 1, c, 4)) return true;
//            }
//            if (r - 1 >= 0) {
//                if (helper(board, word + board[r - 1][c], r - 1, c, 2)) return true;
//            }
//            if (c - 1 >= 0) {
//                if (helper(board, word + board[r][c - 1], r, c - 1, 3)) return true;
//            }
//        } else {// from top
//            if (r + 1 < board.length) {
//                if (helper(board, word + board[r + 1][c], r + 1, c, 4)) return true;
//            }
//            if (c + 1 < board[r].length) {
//                if (helper(board, word + board[r][c + 1], r, c + 1, 1)) return true;
//            }
//            if (c - 1 >= 0) {
//                if (helper(board, word + board[r][c - 1], r, c - 1, 3)) return true;
//            }
//        }
//        visited[r][c] = false;
//        return false;
//    }


}
