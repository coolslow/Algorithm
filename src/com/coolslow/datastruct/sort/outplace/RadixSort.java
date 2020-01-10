package com.coolslow.datastruct.sort.outplace;

import com.coolslow.datastruct.array.MyArrayList;

/**
 * 基数排序
 * <p>
 * by MrThanksgiving
 */
public class RadixSort {


    /**
     * 1 先以个位数的大小来对数据进行排序，接着以十位数的大小来多数进行排序，接着以百位数的大小……
     * 2 排到最后，就是一组有序的元素了。
     * 不过，他在以某位数进行排序的时候，是用“桶”来排序的。
     * 由于某位数（个位/十位….，不是一整个数）的大小范围为0-9，所以我们需要10个桶。
     * 然后把具有相同数值的数放进同一个桶里，之后再把桶里的数按照0号桶到9号桶的顺序取出来，这样一趟下来，按照某位数的排序就完成了
     */
    public static void sort(Integer[] source) {
        if (source == null) {
            return;
        }

        MyArrayList<MyArrayList<Integer>> buckets = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new MyArrayList<>());
        }

        int max = 0;
        for (Integer data : source) {
            if (data > max) max = data;
        }

        int steps = 0;
        while (max > 0) {

            for (int i = 0; i < buckets.size(); i++) {
                MyArrayList bucket = buckets.get(i);
                bucket.clear();
            }
            for (Integer data : source) {
                int integer = (int) (data / Math.pow(10, steps));
                int module = integer % 10;
                MyArrayList<Integer> bucket = buckets.get(module);
                bucket.add(data);
            }
            int k = 0;
            for (int i = 0; i < buckets.size(); i++) {
                for (int j = 0; j < buckets.get(i).size(); j++) {
                    source[k++] = buckets.get(i).get(j);
                }
            }
            max /= 10;
            steps++;
        }

    }

}
