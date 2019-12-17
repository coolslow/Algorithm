package com.coolslow.sort.outplace;

import com.coolslow.datastruct.MyArrayList;

import java.lang.reflect.Array;

/**
 * 归并排序
 * <p>
 * by MrThanksgiving
 */
public class MergeSort {

    /**
     * 1 将一个大的无序数组有序，我们可以把大的数组分成两个，然后对这两个数组分别进行排序，
     * 2 之后在把这两个数组合并成一个有序的数组。由于两个小的数组都是有序的，所以在合并的时候是很快的。
     * 3 通过递归的方式将大的数组一直分割，直到数组的大小为 1，此时只有一个元素，那么该数组就是有序的了。
     * 之后再把两个数组大小为1的合并成一个大小为2的，再把两个大小为2的合并成4的 ….. 直到全部小的数组合并起来。
     */
    public static <T extends Comparable<T>> void sort(T[] data) {

        if (data == null) {
            return;
        }
        int count = data.length;
        int step = 1;
        while (step < count) {
            for (int i = 0; i + step < count; i += 2 * step) {
                int s = i;
                int e = i + 2 * step - 1;
                if (e > count - 1) {
                    e = count - 1;
                }
                merge(data, s, (s + step - 1), e);
            }
            step = 2 * step;
        }

    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] data, int start, int mid, int end) {
//        Object[] container = new Object[end - start + 1];
        T[] container = (T[]) Array.newInstance(data.getClass().getComponentType(), end - start + 1);

        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (data[i].compareTo(data[j]) < 0) {
                container[k++] = data[i++];
            } else {
                container[k++] = data[j++];
            }
        }
        while (i <= mid) {
            container[k++] = data[i++];
        }
        while (j <= end) {
            container[k++] = data[j++];
        }
        for (i = 0; i < k; i++) {
            data[start++] = container[i];
        }
    }


    @SuppressWarnings("UnnecessaryLocalVariable")
    public static <T extends Comparable<T>> void sort(MyArrayList<T> data) {

        if (data == null) {
            return;
        }
        int count = data.size();
        int step = 1;

        while (step < count) {
            for (int i = 0; i + step < count; i += 2 * step) {
                int s = i;
                int e = i + 2 * step - 1;
                if (e > count - 1) {
                    e = count - 1;
                }
                merge(data, s, (s + step - 1), e);
            }
            step = 2 * step;
        }
    }

    private static <T extends Comparable<T>> void merge(MyArrayList<T> data, int start, int mid, int end) {
        MyArrayList<T> container = new MyArrayList<>(end - start + 1);

        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (data.get(i).compareTo(data.get(j)) < 0) {
                container.add(k++, data.get(i++));
            } else {
                container.add(k++, data.get(j++));
            }
        }
        while (i <= mid) {
            container.add(k++, data.get(i++));
        }
        while (j <= end) {
            container.add(k++, data.get(j++));
        }
        for (i = 0; i < k; i++) {
            data.set(start++, container.get(i));
        }
    }


    static class KV {
        int start;
        int end;

        KV(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
