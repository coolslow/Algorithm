package com.coolslow.utils;

import com.coolslow.datastruct.MyArrayList;
import com.coolslow.datastruct.MySingleLinkedList;

import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 * 测试数据生产类
 * <p>
 * by MrThanksgiving
 */
public class MyData {

    /*
     * 2^0  = 1
     * 2^1  = 2
     * 2^2  = 4
     * 2^3  = 8
     * 2^4  = 16
     * 2^5  = 32
     * 2^6  = 64
     * 2^7  = 128           百级别
     * 2^8  = 256
     * 2^9  = 512
     * 2^10 = 1024          千级别
     * 2^11 = 2048
     * 2^12 = 4096
     * 2^13 = 8192
     * 2^14 = 16384         万级别
     * 2^15 = 32768
     * 2^16 = 65535
     * 2^17 = 131072        十万级别
     * 2^18 = 262144
     * 2^19 = 524288
     * 2^20 = 1048576       百万级别
     * 2^21 = 2097152
     * 2^22 = 4194304
     * 2^23 = 8388608
     * 2^24 = 16777216      千万级别
     * 2^25 = 33554432
     * 2^26 = 67108864
     * 2^27 = 134217728     亿级别（个人电脑创建不出来这么多的数据啊）
     * 2^28 = 268435456
     * 2^29 = 536870912
     * 2^30 = 1073741824    十亿级别
     *
     * int 的最大值为 MAX_VALUE = 0x7fffffff
     *        2147483647    二十亿级别
     *
     */

    /**
     * 2的n次幂个节点的满二叉树节点序列（无重复，已排好序）
     *
     * @param powerBy2 2的n次幂
     * @return MySingleLinkedList<Integer>
     */
    public static MySingleLinkedList<Integer> generateBinaryTree(long powerBy2) {
        return generateBinaryTree(powerBy2, false, false);
    }

    public static MySingleLinkedList<Integer> generateBinaryTree(long powerBy2, boolean isOpenPrintLog, boolean isOpenCostTimeLog) {
        MySingleLinkedList<Integer> list = new MySingleLinkedList<>();
        if (isOpenCostTimeLog) {
            MyUtils.startTime();
        }

        if (powerBy2 < 0) {
            if (isOpenCostTimeLog) {
                MyUtils.endTime(" " + 0 + "个节点构建耗时：");
            }
            return list;
        }
        if (powerBy2 >= 30) {
            powerBy2 = 30;
        }
        int capacity = (int) Math.pow(2, powerBy2);
        long count = powerBy2;

        for (int i = 0; i < count; i++) {
            if (isOpenPrintLog) {
                MyUtils.printMarkLine("第" + (i + 1) + "层");
            }
            if (i == 0) {
                list.addLast(capacity / 2);
                if (isOpenPrintLog) {
                    MyUtils.print((capacity / 2) + ", ");
                }
                continue;
            }
            int offset = (int) (capacity / Math.pow(2, i));
            int base = (int) (capacity / Math.pow(2, i + 1));
            for (int k = 0; k < Math.pow(2, i); k++) {
                list.addLast(base + (offset * k));
                if (isOpenPrintLog) {
                    MyUtils.print((base + (offset * k)) + ", ");
                    if (k != 0 && k % 100 == 0) {
                        MyUtils.print("\n<- ");
                    }
                }
            }

        }
        if (isOpenCostTimeLog) {
            MyUtils.endTime(" " + capacity + "个节点构建耗时：");
        }
        return list;
    }

    /**
     * 2的n次幂个节点升序排列
     *
     * @param powerBy2 2的n次幂
     * @return Integer[]
     */
    public static Integer[] generateDataAscending(int powerBy2) {
        int capacity = (int) Math.pow(2, powerBy2);
        Integer[] list = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            list[i] = i;
        }
        return list;
    }

    /**
     * 2的n次幂个节点降序排列
     *
     * @param powerBy2 2的n次幂
     * @return Integer[]
     */
    public static Integer[] generateDataDescending(int powerBy2) {
        int capacity = (int) Math.pow(2, powerBy2);
        Integer[] list = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            list[i] = capacity - i;
        }
        return list;
    }

    /**
     * 2的n次幂个节点的随机
     *
     * @param powerBy2 2的n次幂
     * @return Integer[]
     */
    public static Integer[] generateRandomDataNoRepeat(int powerBy2) {
        return generateRandomDataNoRepeat(powerBy2, false, false);
    }

    public static Integer[] generateRandomDataNoRepeat(int powerBy2, boolean isOpenPrintLog, boolean isOpenCostTimeLog) {

        if (isOpenCostTimeLog) {
            MyUtils.startTime();
        }

        if (powerBy2 < 0) {
            if (isOpenCostTimeLog) {
                MyUtils.endTime(" " + 0 + "个节点构建耗时：");
            }
            return new Integer[0];
        }

        if (powerBy2 >= 30) {
            powerBy2 = 30;
        }

        int capacity = (int) Math.pow(2, powerBy2);
        Integer[] list = new Integer[capacity];

        Set<Integer> isVisited = new HashSet<>();
        Random random = new Random();

        int lastIndexPosition = 0;

        for (int data = 1; data <= capacity; data++) {
            int randomIndex = random.nextInt(capacity);
            if (!isVisited.contains(randomIndex)) {
                isVisited.add(randomIndex);
                list[randomIndex] = data;
            } else {
                while (isVisited.contains(lastIndexPosition)) {
                    lastIndexPosition++;
                }
                isVisited.add(lastIndexPosition);
                list[lastIndexPosition] = data;
            }
            if (isOpenPrintLog) {
                if (isVisited.size() % 1000 == 0) {
                    MyUtils.println("当前进度：" + (isVisited.size() / 1000) + " , 总进度：" + (capacity / 1000));
                }
            }

        }
        if (isOpenCostTimeLog) {
            MyUtils.endTime(" " + capacity + "个节点构建耗时：");
        }
        return list;
    }


    /**
     * 2的n次幂个节点的随机 可能会重复
     *
     * @param powerBy2 2的n次幂
     * @return Integer[]
     */
    public static Double[] generateRandomDataCanRepeatDouble(int powerBy2) {
        return generateRandomDataCanRepeatDouble(powerBy2, false, false);
    }

    public static Double[] generateRandomDataCanRepeatDouble(int powerBy2, boolean isOpenPrintLog, boolean isOpenCostTimeLog) {

        if (isOpenCostTimeLog) {
            MyUtils.startTime();
        }
        if (powerBy2 < 0) {
            if (isOpenCostTimeLog) {
                MyUtils.endTime(" " + 0 + "个节点构建耗时：");
            }
            return new Double[0];
        }

        if (powerBy2 >= 30) {
            powerBy2 = 30;
        }
        Random random = new Random();
        int capacity = (int) Math.pow(2, powerBy2);

        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMinimumIntegerDigits(0);
        format.setMaximumIntegerDigits(0);
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);

        Double[] list = new Double[capacity];
        for (int i = 0; i < capacity; i++) {
            double d = random.nextDouble();
            int integer = random.nextInt(capacity) % 500;
            double fraction = random.nextDouble();
            list[i] = Double.parseDouble(integer + format.format(fraction));
            if (isOpenPrintLog) {
                if (i % 10000 == 0) {
                    MyUtils.println("当前进度：" + (i / 10000) + " , 总进度：" + (capacity / 10000));
                } else if (i == list.length - 1) {
                    MyUtils.println("当前进度：" + (i / 10000) + " , 总进度：" + (capacity / 10000));
                }
            }
        }
        if (isOpenCostTimeLog) {
            MyUtils.endTime(" " + capacity + "个节点构建耗时：");
        }
        return list;

    }


    /**
     * 2的n次幂个节点的随机 可能会重复
     *
     * @param powerBy2 2的n次幂
     * @return Integer[]
     */
    public static Integer[] generateRandomDataCanRepeatInteger(int powerBy2) {
        return generateRandomDataCanRepeatInteger(powerBy2, false, false);
    }

    public static Integer[] generateRandomDataCanRepeatInteger(int powerBy2, boolean isOpenPrintLog, boolean isOpenCostTimeLog) {

        if (isOpenCostTimeLog) {
            MyUtils.startTime();
        }
        if (powerBy2 < 0) {
            if (isOpenCostTimeLog) {
                MyUtils.endTime(" " + 0 + "个节点构建耗时：");
            }
            return new Integer[0];
        }

        if (powerBy2 >= 30) {
            powerBy2 = 30;
        }
        Random random = new Random();
        int capacity = (int) Math.pow(2, powerBy2);

        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMinimumIntegerDigits(0);
        format.setMaximumIntegerDigits(0);
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);

        Integer[] list = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            list[i] = random.nextInt(capacity);
            if (isOpenPrintLog) {
                if (i % 10000 == 0) {
                    MyUtils.println("当前进度：" + (i / 10000) + " , 总进度：" + (capacity / 10000));
                } else if (i == list.length - 1) {
                    MyUtils.println("当前进度：" + (i / 10000) + " , 总进度：" + (capacity / 10000));
                }
            }
        }
        if (isOpenCostTimeLog) {
            MyUtils.endTime(" " + capacity + "个节点构建耗时：");
        }
        return list;

    }


    public static <T> void print(T[] data) {
        if (data == null) {
            return;
        }
        for (T i : data) {
            MyUtils.print(i + ", ");
        }
        MyUtils.printLine();
    }


    public static <T> void printMyArrayList(MyArrayList<T> data) {
        if (data == null)
            return;
        printMyArrayList(data, 0, data.size() - 1);
    }

    public static <T> void printMyArrayList(MyArrayList<T> data, int s, int e) {
        if (data == null)
            return;
        for (int i = s; i <= e; i++) {
            MyUtils.print(data.get(i) + ", ");
        }
        MyUtils.println("");
    }


    public static void verifyDataNoRepeat(Integer[] data) {
        if (data == null) {
            return;
        }
        boolean success = true;
        Set<Integer> repeat = new HashSet<>();
        for (Integer i : data) {
            if (!repeat.contains(i)) {
                repeat.add(i);
            } else {
                success = false;
                break;
            }
        }

        if (success) {
            MyUtils.println(data.length + "个数，没有重复值");
        } else {
            MyUtils.println("重复值");
        }

    }

    public static <T extends Comparable<T>> void verifySortRightAscendingByMyArrayList(MyArrayList<T> data) {
        if (data == null) {
            return;
        }
        boolean success = true;
        T lastData = data.get(0);
        for (int i = 0; i < data.size(); i++) {
            T d = data.get(i);
            if (d.compareTo(lastData) < 0) {
                success = false;
                break;
            }
            lastData = d;
        }
        if (success) {
            MyUtils.println("排序正确");
        } else {
            MyUtils.println("排序错误" + lastData);
        }

    }

    public static <T extends Comparable<T>> void verifySortRightDescending(T[] data) {
        if (data == null) {
            return;
        }
        boolean success = true;
        T lastData = data[0];
        for (T i : data) {
            if (i.compareTo(lastData) > 0) {
                success = false;
                break;
            }
            lastData = i;
        }
        if (success) {
            MyUtils.println("排序正确");
        } else {
            MyUtils.println("排序错误" + lastData);
        }

    }

    public static <T extends Comparable<T>> boolean verifySortRightAscending(T[] data) {
        return verifySortRightAscending(data, true);
    }

    public static <T extends Comparable<T>> boolean verifySortRightAscending(T[] data, boolean isOpenLog) {
        if (data == null) {
            return true;
        }
        boolean success = true;
        T lastData = data[0];
        for (T i : data) {
            if (i.compareTo(lastData) < 0) {
                success = false;
                break;
            }
            lastData = i;
        }
        if (success) {
            if (isOpenLog) {
                MyUtils.println("排序正确");
            }
        } else {
            if (isOpenLog) {
                MyUtils.println("排序错误" + lastData);
            }
        }
        return success;
    }

}
