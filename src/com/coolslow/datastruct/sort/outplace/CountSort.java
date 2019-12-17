package com.coolslow.datastruct.sort.outplace;

/**
 * 基数排序
 * <p>
 * by MrThanksgiving
 */
public class CountSort {

    /**
     * 1 把数组元素作为数组的下标.
     * 2 用一个临时数组统计该元素出现的次数.
     * 3 最后再把临时数组统计的数据从小到大汇总起来，此时汇总起来是数据是有序的。
     */

    public static void sort(Integer[] data) {
        if (data == null) {
            return;
        }
        int count = data.length;
        Integer max = data[0];
        Integer min = data[0];
        for (int i = 1; i < count; i++) {
            Integer temp = data[i];
            if (temp.compareTo(max) > 0) {
                max = temp;
            }
            if (temp.compareTo(min) < 0) {
                min = temp;
            }
        }
        int[] countArray = new int[max - min + 1];
        for (int i = 0; i < count; i++) {
            countArray[data[i] - min] += 1;
        }
        int k = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                data[k++] = min + i;
            }
        }
    }

}
