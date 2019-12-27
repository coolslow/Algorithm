package com.coolslow.leetcode.topics.array;

/**
 * 颜色分类
 * by MrThanksgiving
 */
public class Code0075SortColors {

    /**
     * <pre>
     * 题目：
     *      给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *      此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *      注意:
     *      不能使用代码库中的排序函数来解决这道题。
     *
     * 示例:
     *      输入: [2,0,2,1,1,0]
     *      输出: [0,0,1,1,2,2]
     *
     * 进阶：
     *      一个直观的解决方案是使用计数排序的两趟扫描算法。
     *      首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     *      你能想出一个仅使用常数空间的一趟扫描算法吗？
     *
     * </pre>
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int first = 0;
        int curr = 0;
        int last = nums.length - 1;
        int temp;
        while (curr <= last) {
            if (nums[curr] == 0) {
                temp = nums[first];
                nums[first] = nums[curr];
                nums[curr] = temp;
                first++;
                curr++;
            } else if (nums[curr] == 2) {
                temp = nums[last];
                nums[last] = nums[curr];
                nums[curr] = temp;
                last--;
            } else {
                curr++;
            }
        }
    }

    /*
     * 思路：
     *      两个指针。first表示first之前的都是红色，last表示last之后的都是蓝色。
     *      遍历整个数组，如果是红色与first位置上的元素互换，并向后移动first一位。
     *      如果是蓝色与last位置上的元素互换，并向前移动last一位。
     */
}
