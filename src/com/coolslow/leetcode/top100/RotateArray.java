package com.coolslow.leetcode.top100;

/**
 * 189. 旋转数组
 *
 * 给定一个数组，将数组的元素向右移动k个位置，其中k为非负数。
 *
 * 示例1：
 *      输入：[1, 2, 3, 4, 5, 6, 7] 和 k = 3
 *      输出：[5, 6, 7, 1, 2, 3, 4]
 *      解释：
 *      向右旋转1步：[7, 1, 2, 3, 4, 5, 6]
 *      向右旋转2步：[6, 7, 1, 2, 3, 4, 5]
 *      向右旋转3步：[5, 6, 7, 1, 2, 3, 4]
 *
 * 示例2：
 *      输入：[-1, -100, 3, 99] 和 k = 2
 *      输出：[3, 99, -1, 100]
 *      解释：
 *      向右旋转1步：[99, -1, -100, 3]
 *      向右旋转2步：[3, 99, -1, -100]
 *
 * 说明：
 *      - 尽可能相处更多解决方案，至少右三种不同的方法可以解决这个问题
 *      - 要求使用空间复杂度为O(1)的"原地"算法
 *
 * 思路：在《编程珠玑》里，旋转数组的解法可以通过如下步骤拆解完成：
 * 1. 根据传入的k值，将数组从下标k处进行拆分 [1, 2, 3, 4, 5, 6, 7] -> [1, 2, 3, 4] + [5, 6, 7]
 * 2. 然后将两个数组分别进行逆序排列 -> [4, 3, 2, 1] + [7, 6, 5]
 * 3. 将两个数组合并为 -> [4, 3, 2, 1, 7, 6, 5]再整体逆序排列 -> [5, 6, 7, 1, 2, 3, 4]
 *
 *
 */
public class RotateArray {

    /**
     * 暴力解法，时间复杂度O(n^2)
     * @param nums 输入的数组
     * @param k 指定的下标k
     * @return 返回一个旋转后的数组
     */
    public static int[] rotateArrayWithBruteForce(int[] nums, int k) {
        int temp, previous;
        for(int i = 0; i < k; i ++) {
            previous = nums[nums.length - 1];
            for(int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        return nums;
    }

    /**
     * 利用额外的数组，时间复杂度O(n)，空间复杂度O(n)
     * @param nums 输入的数组
     * @param k 指定的下标k
     * @return 返回一个旋转后的数组
     */
    public static int[] rotateArrayWithExtraArray(int[] nums, int k) {
        int[] a = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
        return nums;
    }

    /**
     * 循环替换：
     * 我们可以将数组中的每一个数值直接放置所需的正确位置上。但这样做会破坏原来的数组。
     * 因此，需要将替换的数字存储在temp变量中。然后，我们可以将替换的数字（temp）放置在正确的位置上，一次类推。
     * 执行n次，n的大小为数组的长度。
     * @param nums 输入的数组
     * @param k 输入的数组
     * @return 返回一个旋转后的数组
     */
    public static int[] rotateArrayWithCycleReplacement(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for(int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
        return nums;
    }
}
