package com.coolslow.datastruct.utils;

/**
 * 工具类
 * <p>
 * by MrThanksgiving
 */
public class MyUtils {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void print(String log) {
        System.out.print(log);
    }

    public static void println(String log) {
        System.out.println(log);
    }

    public static void printStartLine() {
        System.out.println("\n===================================hello world===================================");
    }

    public static void printMarkLine(String mark) {
        System.out.println("\n====================================== " + mark + " =======================================");
    }

    public static void printEndLine() {
        System.out.println("\n=================================================================================");
    }

    public static void printLine() {
        System.out.println("\n=================================================================================");
    }

    private static long performanceTime;

    public static void startTime() {
        performanceTime = System.currentTimeMillis();
    }

    public static long endTime(String mark) {
        long duration = System.currentTimeMillis() - performanceTime;
        printMarkLine(mark + duration + "毫秒");
        performanceTime = System.currentTimeMillis();
        return duration;
    }


    public static void printProgressing(int curr, int total) {
        int per = total / 100;
        if (per == 0) {
            return;
        }
        curr = (curr + 1);
        if (curr % per == 0) {
            MyUtils.println("curr=" + curr + "   total=" + total);
        } else if (curr == total) {
            MyUtils.println("curr=" + curr + "   total=" + total);
        }

    }


    public static void printArray(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int i : data) {
            stringBuilder.append(i).append(" , ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        MyUtils.println(stringBuilder.toString());
    }

    public static void printArray(float[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (float i : data) {
            stringBuilder.append(i).append(" , ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        MyUtils.println(stringBuilder.toString());
    }

    public static <T> void printArray(T[] data) {
        if (data == null || data.length == 0) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (T i : data) {
            stringBuilder.append(i).append(" , ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        MyUtils.println(stringBuilder.toString());
    }

}
