package com.coolslow.sort;

import com.coolslow.utils.MyData;
import com.coolslow.utils.MyUtils;
import org.junit.Test;

public class Sort {

    /**
     * 选择排序
     */
    @Test
    public void test1() {

        Integer[] data = MyData.generateRandomData(3);
        MyData.print(data);

        SelectSort.sort(data);
        MyData.print(data);

    }


    /**
     * 选择排序 百万级
     */
    @Test
    public void test2() {
        MyUtils.startTime();

        MyUtils.printMarkLine("开始创建百万级(1048576个)数据");
        Integer[] data = MyData.generateRandomData(20);
        MyUtils.endTime("创建百万级(1048576个)数据 耗时");

        MyUtils.printMarkLine("开始验证数据");
        MyData.verifyDataNoRepeat(data);
        MyUtils.endTime("验证数据 耗时");

        MyUtils.printMarkLine("开始选择排序");
        SelectSort.sort(data);
        MyUtils.endTime("选择排序 耗时");

        MyUtils.printMarkLine("开始排序正确性验证");
        MyData.verifySortRight(data);
        MyUtils.endTime("排序正确性验证 耗时");
    }


    /**
     * 插入排序
     */
    @Test
    public void test3() {

        Integer[] data = MyData.generateRandomData(5);
        MyData.print(data);
        InsertSort.sort(data);
        MyData.print(data);
    }

    /**
     * 插入排序 百万级
     */
    @Test
    public void test4() {


        MyUtils.startTime();

        MyUtils.printMarkLine("开始创建百万级(1048576个)数据");
        Integer[] data = MyData.generateRandomData(20);
        MyUtils.endTime("创建百万级(1048576个)数据 耗时");

        MyUtils.printMarkLine("开始验证数据");
        MyData.verifyDataNoRepeat(data);
        MyUtils.endTime("验证数据 耗时");

        MyUtils.printMarkLine("开始插入排序");
        InsertSort.sort(data);
        MyUtils.endTime("插入排序 耗时");

        MyUtils.printMarkLine("开始排序正确性验证");
        MyData.verifySortRight(data);
        MyUtils.endTime("排序正确性验证 耗时");

    }

    /**
     * 冒泡排序
     */
    @Test
    public void test5() {

        Integer[] data = MyData.generateRandomData(5);
        MyData.print(data);
        BubbleSort.sort(data);
        MyData.print(data);
    }


    /**
     * 冒泡排序 百万级
     */
    @Test
    public void test6() {


        MyUtils.startTime();

        MyUtils.printMarkLine("开始创建百万级(1048576个)数据");
        Integer[] data = MyData.generateRandomData(20);
        MyUtils.endTime("创建百万级(1048576个)数据 耗时");

        MyUtils.printMarkLine("开始验证数据");
        MyData.verifyDataNoRepeat(data);
        MyUtils.endTime("验证数据 耗时");

        MyUtils.printMarkLine("开始冒泡排序");
        BubbleSort.sort(data);
        MyUtils.endTime("冒泡排序 耗时");

        MyUtils.printMarkLine("开始排序正确性验证");
        MyData.verifySortRight(data);
        MyUtils.endTime("排序正确性验证 耗时");


    }


    /**
     * 希尔排序
     */
    @Test
    public void test7() {
        Integer[] data = MyData.generateRandomData(5);
        MyData.print(data);
        ShellSort.sort(data);
        MyData.print(data);
    }

    /**
     * 希尔排序
     */
    @Test
    public void test8() {

        MyUtils.startTime();

        MyUtils.printMarkLine("开始创建百万级(1048576个)数据");
        Integer[] data = MyData.generateRandomData(20);
//        Integer[] data = MyData.generateDataAscending(20);
//        Integer[] data = MyData.generateDataDescending(20);
        MyUtils.endTime("创建百万级(1048576个)数据 耗时");

        MyUtils.printMarkLine("开始验证数据");
        MyData.verifyDataNoRepeat(data);
        MyUtils.endTime("验证数据 耗时");

        MyUtils.printMarkLine("开始希尔排序");
        ShellSort.sort(data);
        MyUtils.endTime("希尔排序 耗时");

        MyUtils.printMarkLine("开始排序正确性验证");
        MyData.verifySortRight(data);
        MyUtils.endTime("排序正确性验证 耗时");

    }


    /**
     * 快速排序
     */
    @Test
    public void test9() {
        Integer[] data = MyData.generateRandomData(5);
        MyData.print(data);
        QuickSort.sort(data);
        MyData.print(data);
    }


    /**
     * 快速排序 百万级
     */
    @Test
    public void test10() {

        MyUtils.startTime();

        MyUtils.printMarkLine("开始创建百万级(1048576个)数据");

        Integer[] data;
//        data = MyData.generateDataAscending(20);  //升序。耗时 9分钟7秒。加随机因子后会提升到500ms内
//        data = MyData.generateDataDescending(20); //降序。 耗时24分钟。加随机因子后会提升到500ms内
        data = MyData.generateRandomData(20);// 随机。耗时545毫秒。加随机因子后会提升到500ms内

        MyUtils.endTime("创建百万级(1048576个)数据 耗时");

        MyUtils.printMarkLine("开始验证数据");
        MyData.verifyDataNoRepeat(data);
        MyUtils.endTime("验证数据 耗时");

        MyUtils.printMarkLine("开始快速排序");
        QuickSort.sort(data);
        MyUtils.endTime("快速排序 耗时");

        MyUtils.printMarkLine("开始排序正确性验证");
        MyData.verifySortRight(data);
        MyUtils.endTime("排序正确性验证 耗时");

    }

}
