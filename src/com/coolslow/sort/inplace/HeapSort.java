package com.coolslow.sort.inplace;

public class HeapSort {

    public static <T extends Comparable<T>> void sort(T[] data) {
        if (data == null) {
            return;
        }

        int count = data.length;
        int index = 0;
        int parent = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        for (int i = 0; i < count; i++) {

        }


    }


}
