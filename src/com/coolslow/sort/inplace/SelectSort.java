package com.coolslow.sort.inplace;


import com.coolslow.utils.MyUtils;

public class SelectSort {


    /**
     * 1 找到数组中最小的那个元素，
     * 2 将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。
     * 3 在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。
     * 4 如此往复，直到将整个数组排序。这种方法我们称之为选择排序。
     */

    static <T extends Comparable<T>> void sort(T[] data) {
        if (data == null) {
            return;
        }
        int count = data.length;
        for (int i = 0; i < count; i++) {

            MyUtils.printProgressing(i, count);

            for (int k = i + 1; k < count; k++) {
                if (data[i].compareTo(data[k]) > 0) {
                    T temp = data[i];
                    data[i] = data[k];
                    data[k] = temp;
                }
            }
        }

    }

    public static <T extends Comparable<T>> void sort2(T[] data) {
        if (data == null) {
            return;
        }
        int count = data.length;
        for (int i = 0; i < count; i++) {

            MyUtils.printProgressing(i, count);

            int min = i;
            for (int k = i + 1; k < count; k++) {
                if (data[min].compareTo(data[k]) > 0) {
                    min = k;
                }
            }
            T temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
    }

    /*
     *      ====================================== 开始创建百万级(1048576个)数据 =======================================
     *      ====================================== 创建百万级(1048576个)数据 耗时894毫秒 =======================================
     *      ====================================== 开始验证数据 =======================================
     *      1048576个数，没有重复值
     *      ====================================== 验证数据 耗时66毫秒 =======================================
     *      ====================================== 开始选择排序 =======================================
     *      ====================================== 选择排序 耗时4723442毫秒 (1小时18分钟)=======================================
     *      ====================================== 开始排序正确性验证 =======================================
     *      排序正确
     *      ====================================== 排序正确性验证 耗时13毫秒 =======================================
     */

}
