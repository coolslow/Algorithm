package com.coolslow.datastruct.sort;

import com.coolslow.datastruct.sort.inplace.*;
import com.coolslow.datastruct.utils.MyCallBack;
import com.coolslow.datastruct.utils.MyData;
import com.coolslow.datastruct.utils.MyUtils;
import org.junit.Test;


/**
 * 内排 测试类
 * <p>
 * by MrThanksgiving
 */
public class SortInPlace {

    /**
     * 选择排序
     */
    @Test
    public void test1() {

        Integer[] data = MyData.generateRandomDataNoRepeat(3);
        MyData.print(data);

        SelectSort.sort(data);
        MyData.print(data);

    }


    /**
     * 选择排序 百万级
     */
    @Test
    public void test2() {
        print("选择排序", 20, SortType.Random, SelectSort::sort);
    }


    /**
     * 插入排序
     */
    @Test
    public void test3() {
        Integer[] data = MyData.generateRandomDataNoRepeat(5);
        MyData.print(data);
        InsertSort.sort(data);
        MyData.print(data);
    }

    /**
     * 插入排序 百万级
     */
    @Test
    public void test4() {
        print("插入排序", 20, SortType.Random, InsertSort::sort);
    }

    /**
     * 冒泡排序
     */
    @Test
    public void test5() {
        Integer[] data = MyData.generateRandomDataNoRepeat(5);
        MyData.print(data);
        BubbleSort.sort(data);
        MyData.print(data);
    }


    /**
     * 冒泡排序 百万级
     */
    @Test
    public void test6() {
        print("冒泡排序", 20, SortType.Random, BubbleSort::sort);
    }


    /**
     * 希尔排序
     */
    @Test
    public void test7() {
        Integer[] data = MyData.generateRandomDataNoRepeat(5);
        MyData.print(data);
        ShellSort.sort(data);
        MyData.print(data);
    }

    /**
     * 希尔排序 百万级
     */
    @Test
    public void test8() {
        print("希尔排序", 20, SortType.Random, ShellSort::sort);
    }


    /**
     * 快速排序
     */
    @Test
    public void test9() {
        Integer[] data = MyData.generateRandomDataNoRepeat(5);
        MyData.print(data);
        QuickSort.sort(data);
        MyData.print(data);
    }


    /**
     * 快速排序 百万级
     */
    @Test
    public void test10() {
        print("快速排序", 20, SortType.Random, QuickSort::sort);
    }

    /**
     * 堆排序
     */
    @Test
    public void test11() {
        Integer[] data = MyData.generateRandomDataNoRepeat(6);
        MyData.print(data);
        HeapSort.sort(data);
        MyData.print(data);
    }

    /**
     * 堆排序 百万级
     */
    @Test
    public void test12() {
        print("堆排序", 20, SortType.Random, HeapSort::sort);
    }


    enum SortType {
        Ascending, Descending, Random,
    }

    private void print(String sortName, int powerBy2, SortType sortType, MyCallBack<Integer[]> callback) {

        String dataLevel;
        int count = (int) Math.pow(2, powerBy2);
        if (powerBy2 >= 1 && powerBy2 <= 3) {
            dataLevel = "个位级(" + count + "个)";
        } else if (powerBy2 >= 4 && powerBy2 <= 6) {
            dataLevel = "十位级(" + count + "个)";
        } else if (powerBy2 >= 7 && powerBy2 <= 9) {
            dataLevel = "百位级(" + count + "个)";
        } else if (powerBy2 >= 10 && powerBy2 <= 13) {
            dataLevel = "千位级(" + count + "个)";
        } else if (powerBy2 >= 14 && powerBy2 <= 16) {
            dataLevel = "万级(" + count + "个)";
        } else if (powerBy2 >= 17 && powerBy2 <= 19) {
            dataLevel = "十万级(" + count + "个)";
        } else if (powerBy2 >= 20 && powerBy2 <= 23) {
            dataLevel = "百万级(" + count + "个)";
        } else if (powerBy2 >= 24 && powerBy2 <= 26) {
            dataLevel = "千万级(" + count + "个)";
        } else {
            return;
        }
        MyUtils.startTime();

        MyUtils.println("开始创建" + dataLevel + "数据");

        Integer[] data;
        if (sortType == SortType.Ascending) {
            data = MyData.generateDataAscending(20);  //升序。耗时 281毫秒。
        } else if (sortType == SortType.Descending) {
            data = MyData.generateDataDescending(20); //降序。 耗时 329毫秒。
        } else {
            data = MyData.generateRandomDataNoRepeat(20);// 随机。耗时 570毫秒。
        }

        MyUtils.endTime("创建" + dataLevel + "数据 耗时");

        MyUtils.println("开始验证数据");
        MyData.verifyDataNoRepeat(data);
        MyUtils.endTime("验证数据 耗时");

        MyUtils.println("开始" + sortName);
        if (callback != null) {
            callback.call(data);
        }
        MyUtils.endTime(sortName + " 耗时");
        MyUtils.println("开始排序正确性验证");
        MyData.verifySortRightAscending(data);
        MyUtils.endTime("排序正确性验证 耗时");

    }


}
