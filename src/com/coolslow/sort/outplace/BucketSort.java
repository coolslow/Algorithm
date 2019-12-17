package com.coolslow.sort.outplace;

import com.coolslow.datastruct.MyArrayList;

/**
 * 桶排序
 * <p>
 * by MrThanksgiving
 */
public class BucketSort {


    /**
     * 1 桶排序就是把最大值和最小值之间的数进行瓜分，例如分成  10 个区间，10个区间对应10个桶.
     * 2 我们把各元素放到对应区间的桶中去.
     * 3 再对每个桶中的数进行排序，可以采用归并排序，也可以采用快速排序之类的。
     */
    public static void sort(Double[] data) {
        if (data == null) {
            return;
        }

        double max = data[0];
        double min = data[0];
        for (double d : data) {
            if (d > max)
                max = d;
            if (d < min)
                min = d;
        }
        int count = data.length;
        int bucketRange = 5;
        int bucketCount = (int) ((max - min) / bucketRange + 1);
        MyArrayList<MyArrayList<Double>> buckets = new MyArrayList<>();

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new MyArrayList<>());
        }
        for (Double d : data) {
            int bucketNo = (int) ((d - min) / bucketRange);
            MyArrayList<Double> bucket = buckets.get(bucketNo);
            bucket.add(d);
        }
        for (int i = 0; i < buckets.size(); i++) {
            MergeSort.sort(buckets.get(i));
//            QuickSort.sort(buckets.get(i));
        }
        int k = 0;
        for (int i = 0; i < buckets.size(); i++) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                data[k++] = buckets.get(i).get(j);
            }
        }

    }

}
