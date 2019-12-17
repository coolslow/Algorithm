package com.coolslow.sort;

import com.coolslow.datastruct.MyArrayList;
import com.coolslow.sort.outplace.BucketSort;
import com.coolslow.sort.outplace.CountSort;
import com.coolslow.sort.outplace.MergeSort;
import com.coolslow.sort.outplace.RadixSort;
import com.coolslow.utils.MyCallBack;
import com.coolslow.utils.MyData;
import com.coolslow.utils.MyUtils;
import org.junit.Test;

/**
 * 外排 测试类
 * <p>
 * by MrThanksgiving
 */
public class SortOutPlace {

    @Test
    public void test1() {
        print("归并排序", 5, SortType.Random, MergeSort::sort);
    }

    @Test
    public void test2() {
        print("归并排序", 24, SortType.Random, MergeSort::sort);
    }

    @Test
    public void test3() {
        Integer[] data = new Integer[]{14, 15, 16, 17, 13};
        MergeSort.sort(data);
        MyData.print(data);
    }

    /**
     * 计数排序
     */
    @Test
    public void test4() {
        Integer[] data = new Integer[]{9, 8, 1, 1, 1, 1, 1, 6, 5, 8, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 5};
        CountSort.sort(data);
        MyData.print(data);
    }


    /**
     * 桶排序
     */
    @Test
    public void test5() {

        int powerBy2 = 20;
        String sortName = "桶排序";
        String dataLevel = getDataLevel(powerBy2);
        if (dataLevel == null) return;

        MyUtils.startTime();
        MyUtils.println("开始创建" + dataLevel + "数据");
        Double[] data = MyData.generateRandomDataCanRepeatDouble(powerBy2);
        MyUtils.endTime("创建" + dataLevel + "数据 耗时");
        MyUtils.println("开始" + sortName);
        BucketSort.sort(data);
        MyUtils.endTime(sortName + " 耗时");
        MyUtils.println("开始排序正确性验证");
        MyData.verifySortRightAscending(data);
        MyUtils.endTime("排序正确性验证 耗时");


    }


    /**
     * 桶排序
     */
    @Test
    public void test6() {

        int powerBy2 = 20;
        String sortName = "桶排序";
        String dataLevel = getDataLevel(powerBy2);
        if (dataLevel == null) return;
        long time = 0;
        int count = 100;
        MyArrayList<Boolean> verifys = new MyArrayList<>();

        for (int i = 0; i < count; i++) {
            Double[] data = MyData.generateRandomDataCanRepeatDouble(powerBy2);
            MyUtils.println("第" + (i + 1) + "次 " + sortName + " 开始");
            MyUtils.startTime();
            BucketSort.sort(data);
            time += MyUtils.endTime(sortName + " 耗时");
            verifys.add(MyData.verifySortRightAscending(data));
        }

        MyUtils.println(count + "次 平均耗时 " + (time * 1.0 / count));
        boolean isSuccess = true;
        for (int i = 0; i < verifys.size(); i++) {
            if (!verifys.get(i)) {
                isSuccess = false;
                break;
            }
        }
        MyUtils.println(count + "次 排序" + (isSuccess ? "都正确" : "有错误"));

    }

    /**
     * 基数排序
     */
    @Test
    public void test7() {
        Integer[] data = MyData.generateRandomDataCanRepeatInteger(4);
        MyData.print(data);
        RadixSort.sort(data);
        MyData.print(data);
    }

    /**
     * 基数排序
     */
    @Test
    public void test8() {
        print("基数排序", 20, SortType.Random, RadixSort::sort);
    }

    /**
     * 基数排序 百万级
     * 100次 平均耗时 478.72
     * 100次 排序都正确
     */
    @Test
    public void test9() {

        int powerBy2 = 20;
        String sortName = "基数排序";
        String dataLevel = getDataLevel(powerBy2);
        if (dataLevel == null) return;
        long time = 0;
        int count = 100;
        MyArrayList<Boolean> verifys = new MyArrayList<>();

        for (int i = 0; i < count; i++) {
            Integer[] data = MyData.generateRandomDataCanRepeatInteger(powerBy2);
            MyUtils.println("第" + (i + 1) + "次 " + sortName + " 开始" + "    " + data[10]);
            MyUtils.startTime();
            RadixSort.sort(data);
            time += MyUtils.endTime(sortName + MyUtils.ANSI_RED + " 耗时" + MyUtils.ANSI_RESET);
            verifys.add(MyData.verifySortRightAscending(data));
        }

        MyUtils.println(count + "次 平均耗时 " + (time * 1.0 / count));
        boolean isSuccess = true;
        for (int i = 0; i < verifys.size(); i++) {
            if (!verifys.get(i)) {
                isSuccess = false;
                break;
            }
        }
        MyUtils.println(count + "次 排序" + (isSuccess ? "都正确" : "有错误"));


    }

    enum SortType {
        Ascending, Descending, Random,
    }

    private void print(String sortName, int powerBy2, SortType sortType, MyCallBack<Integer[]> callback) {

        String dataLevel = getDataLevel(powerBy2);
        if (dataLevel == null) return;

        MyUtils.startTime();

        MyUtils.println("开始创建" + dataLevel + "数据");

        Integer[] data;
        if (sortType == SortType.Ascending) {
            data = MyData.generateDataAscending(powerBy2);  //升序。
        } else if (sortType == SortType.Descending) {
            data = MyData.generateDataDescending(powerBy2); //降序。
        } else {
            data = MyData.generateRandomDataNoRepeat(powerBy2);// 随机。
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

    private String getDataLevel(int powerBy2) {
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
            return null;
        }
        return dataLevel;
    }


}
