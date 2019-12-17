package com.coolslow.datastruct.link;

import com.coolslow.datastruct.utils.MyUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * 链表 测试类
 * <p>
 * by MrThanksgiving
 */
public class LinkTest {

    @Test
    public void test1() {

        MyUtils.printStartLine();

        MyDoubleLinkedList<String> linkedList = new MyDoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(String.valueOf(i));
        }
        foreach1(linkedList);
        linkedList.remove(8);
        foreach1(linkedList);
        MyUtils.printEndLine();
        Assert.assertTrue(true);
    }

    @Test
    public void test2() {

        MyUtils.printStartLine();

        MySingleLinkedList<String> linkedList = new MySingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(String.valueOf(i));
        }
        foreach2(linkedList);

        MyUtils.printEndLine();
        Assert.assertTrue(true);
    }

    public void foreach1(MyDoubleLinkedList<String> linkedList) {
        linkedList.iterator(s -> MyUtils.print(s + " , "));
        MyUtils.printLine();
    }

    public void foreach2(MySingleLinkedList<String> linkedList) {
        linkedList.iterator(s -> MyUtils.print(s + " , "));
        MyUtils.printLine();
    }


}
