package com.coolslow.datastruct.sort.inplace;


import com.coolslow.datastruct.utils.MyUtils;


/**
 * 冒泡排序
 * <p>
 * by MrThanksgiving
 */
public class BubbleSort {


    /**
     * 1 把第一个元素与第二个元素比较，如果第一个比第二个大，则交换他们的位置。接着继续比较第二个与第三个元素，如果第二个比第三个大，则交换他们的位置….
     * 2 我们对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样一趟比较交换下来之后，排在最右的元素就会是最大的数。
     * 3 除去最右的元素，我们对剩余的元素做同样的工作，如此重复下去，直到排序完成
     */
    public static <T extends Comparable<T>> void sort(T[] data) {
        if (data == null) {
            return;
        }
        int count = data.length;
        for (int i = 0; i < count; i++) {
            for (int k = 1; k < count - i; k++) {
                if (data[k - 1].compareTo(data[k]) > 0) {
                    T temp = data[k - 1];
                    data[k - 1] = data[k];
                    data[k] = temp;
                }
            }

            MyUtils.printProgressing(i, count);
        }

    }


    /*
     * ====================================== 开始创建百万级(1048576个)数据 =======================================
     * ====================================== 创建百万级(1048576个)数据 耗时866毫秒 =======================================
     * ====================================== 开始验证数据 =======================================
     * 1048576个数，没有重复值
     * ====================================== 验证数据 耗时67毫秒 =======================================
     * ====================================== 开始冒泡排序 =======================================
     * ====================================== 冒泡排序 耗时6470550毫秒 (1小时47分8秒)=======================================
     * ====================================== 开始排序正确性验证 =======================================
     * 排序正确
     * ====================================== 排序正确性验证 耗时11毫秒 =======================================
     */


}