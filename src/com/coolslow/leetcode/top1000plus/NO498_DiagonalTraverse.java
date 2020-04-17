package com.coolslow.leetcode.top1000plus;

/**
 * 498. 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 * 示例:
 *  输入:
 *  [
 *      [ 1, 2, 3 ],
 *      [ 4, 5, 6 ],
 *      [ 7, 8, 9 ]
 *  ]
 * 输出:  [1, 2, 4, 7, 5, 3, 6, 8, 9]
 */
public class NO498_DiagonalTraverse {

    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length==0){
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] r = new int[m*n];
        int row = 0, clo = 0;
        // 总数量确定，根据总数量循环获取
        for(int i = 0; i < r.length; i++){
            r[i] = matrix[row][clo];
            // 根据下标索引之和来确认下一个元素
            if((row + clo) % 2 == 0 ){
                if(clo == n-1){
                    row++;
                }else if(row == 0){
                    clo++;
                }else{
                    row--;
                    clo++;
                }
            }else{
                if(row == m - 1){
                    clo++;
                }else if(clo == 0){
                    row++;
                }else{
                    row++;
                    clo--;
                }
            }
        }
        return r;


//        if (matrix == null || matrix.length == 0) {
//            return new int[0];
//        }
//
//        // 获取matrix的长度（矩阵高度 - 列）
//        int n = matrix.length;
//        // 获取matrix每个数组的长度（矩阵宽度 - 行）
//        int m = matrix[0].length;
//
//        int row = 0, column = 0;
//        int direction = 1;
//        int[] result = new int[n * m];
//
//        // 一纬数组的下标
//        int r = 0;
//        while(row < n && column < m) {
//            result[r++] = matrix[row][column];
//
//            int newRow = row + (direction == 1 ? -1 : 1);
//            int newColumn = column + (direction == 1 ? 1 : -1);
//
//            if (newRow < 0 || newRow == n || newColumn < 0 || newColumn == m) {
//                if (direction == 1) {
//                    row += (column == m - 1 ? 1 : 0) ;
//                    column += (column < n - 1 ? 1 : 0);
//                } else {
//                    column += (row == n - 1 ? 1 : 0);
//                    row += (row < m - 1 ? 1 : 0);
//                }
//                direction = 1 - direction;
//            } else {
//                row = newRow;
//                column = newColumn;
//            }
//        }
//        return result;
    }
}
