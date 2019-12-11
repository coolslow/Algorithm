package com.coolslow.sort;

import com.coolslow.datastruct.MyQueue;
import com.coolslow.utils.MyUtils;

import java.util.Random;

public class QuickSort {

    /**
     * 1 我们从数组中选择一个元素，我们把这个元素称之为中轴元素吧，
     * 2 然后把数组中所有小于中轴元素的元素放在其左边，所有大于或等于中轴元素的元素放在其右边，
     * 3 从中轴元素那里开始把大的数组切割成两个小的数组(两个数组都不包含中轴元素)，
     * 4 接着我们通过递归的方式，让中轴元素左边的数组和右边的数组也重复同样的操作，直到数组的大小为1，此时每个元素都处于有序的位置。
     */
    static <T extends Comparable<T>> void sort(T[] data) {
        if (data == null) {
            return;
        }
        Random random = new Random();
        MyQueue<KV> myQueue = new MyQueue<>();
        myQueue.add(new KV(0, data.length - 1));
        while (!myQueue.isEmpty()) {
            KV kv = myQueue.remove();
            int start = kv.start;
            int end = kv.end;
            int index = random.nextInt(end) % (end - start + 1) + start;
            T base = data[index];
            while (start < end) {
                while (start <= end && base.compareTo(data[start]) > 0) {
                    start++;
                }
                while (start < end && base.compareTo(data[end]) < 0) {
                    end--;
                }
                if (start < end) {
                    T temp = data[start];
                    data[start] = data[end];
                    data[end] = temp;
                }
            }
            int leftStart = kv.start;
            int leftEnd = start;
            if (leftStart < leftEnd) {
                myQueue.add(new KV(leftStart, leftEnd));
            }
            int rightStart = end + 1;
            int rightEnd = kv.end;
            if (rightStart < rightEnd) {
                myQueue.add(new KV(rightStart, rightEnd));
            }

//            MyUtils.printProgressing(myQueue.size(),myQueue.size());
        }

    }

    static class KV {
        int start;
        int end;

        public KV(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


}
