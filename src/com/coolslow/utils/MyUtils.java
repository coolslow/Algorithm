package com.coolslow.utils;

/**
 * By MrZ
 * 2019-11-15
 */
public class MyUtils {

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

    public static void endTime(String mark) {
        long duration = System.currentTimeMillis() - performanceTime;
        printMarkLine(mark + duration + "毫秒");
    }

}
