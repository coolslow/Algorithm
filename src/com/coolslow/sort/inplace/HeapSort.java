package com.coolslow.sort.inplace;

public class HeapSort {


    /**
     * 堆的特点就是堆顶的元素是一个最值。(大顶堆的堆顶是最大值，小顶堆则是最小值。)
     * <p>
     * 1 将随机数组构建成二叉堆。
     * 2 把堆顶的元素与最后一个元素交换。
     * 3 交换之后破坏了堆的特性，我们再把堆中剩余的元素再次构成一个大顶堆。
     * 4 然后再把堆顶元素与最后第二个元素交换….如此往复下去，等到剩余的元素只有一个的时候，此时的数组就是有序的了。
     */

    public static <T extends Comparable<T>> void sort(T[] data) {
        if (data == null) {
            return;
        }
        int count = data.length;
        for (int i = (count - 2) / 2; i >= 0; i--) {
            downAdjust(data, i, count - 1);
        }

        for (int i = count - 1; i >= 1; i--) {
            T temp = data[i];
            data[i] = data[0];
            data[0] = temp;
            downAdjust(data, 0, i - 1);
        }

    }

    private static <T extends Comparable<T>> void downAdjust(T[] data, int parentId, int length) {

        int childId = 2 * parentId + 1;
        while (childId <= length) {
            T parent = data[parentId];
            T left = data[childId];
            if (childId + 1 <= length && left.compareTo(data[childId + 1]) < 0) {
                childId++;
            }
            if (parent.compareTo(data[childId]) >= 0) {
                break;
            }
            data[parentId] = data[childId];
            data[childId] = parent;
            parentId = childId;
            childId = 2 * parentId + 1;

        }

    }


}
