package com.coolslow.leetcode.interview.topics.sort;

/**
 * 快速排序
 * 参考：https://www.cnblogs.com/MOBIN/p/4681369.html
 *
 * 核心思想：
 *    1. 在待排序的元素任取一个元素作为基准（通常选第一个元素，称为基准元素）
 *    2. 将待排序的元素进行分块，比基准元素大的元素移动到基准元素的右侧，比基准元素小的移动到作左侧，从而一趟排序过程，就可以锁定基准元素的最终位置
 *    3. 对左右两个分块重复以上步骤直到所有元素都是有序的（递归过程）
 *
 *    具体算法流程如下：
 *        待排序元素的初始状态：
 *        5， 7， 1， 8， 4
 *        这里把第一个元素5作为与其它元素比较的基准元素，设置两个指针 right 和 left。
 *
 *        a. 把元素 5 拆出放到一遍作为基准元素
 *
 *         left             right
 *           |               ｜
 *         (  )， 7， 1， 8， 4
 *
 *        b. right 指针从右向左扫描，首先 4 和 5 比较， 4 < 5，拆4，补原元素5的位置
 *
 *              left         right
 *                |           |
 *        ( 4 )， 7， 1， 8，（  ）
 *
 *        c. 7 和 5 比较， 7 > 5，拆 7 补元素 4 的空缺位，right 指针向左移动
 *
 *           left       right
 *             |          |
 *        4，（  ）， 1，  8，  7
 *
 *            left  right
 *             |     |
 *        4，（  ）， 1，   8，   7
 *        -----------------------
 *        5，  7，   1，   8，   4
 *
 *        d. 8 和 5 比较，8 > 5，保持不变，right指针继续向左移动
 *
 *
 *        e. 1 和 5 比较，1 < 5, 拆 1 补元素 7的位置 left 指针右移
 *           此时，left == right， 则将基准元素 5 补充到right == left 的位置
 *
 *              right == left
 *                    |
 *        4，   1，   5，   8，   7
 *        ________________________
 *        5，   7，   1，   8，   4
 *
 *
 *
 *
 *
 */
public class QuickSort {

    public static void quickSort(int[] nums, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        int temp = 0;

        if(left <= right) {
            temp = nums[left];
            //从左右两边交替扫描，直到left = right
            while(left != right) {
                while(left < right && nums[right] >= temp) {
                    right--;
                }
                nums[left] = nums[right];

                while(left < right && nums[left] <= temp) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[right] = temp;
            quickSort(nums, leftIndex, left - 1);
            quickSort(nums, right + 1, rightIndex);
        }
    }
}
