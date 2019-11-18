package com.coolslow.test;

import com.coolslow.datastruct.MyLinkedList;
import com.coolslow.utils.MyUtils;

public class LinkTest {

    public static void test() {

        MyUtils.printStartLine();

        MyLinkedList<String> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(String.valueOf(i));
        }
        foreach(linkedList);
        MyUtils.printEndLine();
    }


    public static void foreach(MyLinkedList<String> linkedList) {
        linkedList.iterator(s -> MyUtils.print(s + " , "));
        MyUtils.printLine();
    }


}
