package com.coolslow.datastruct.queue;

import com.coolslow.datastruct.utils.MyUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * 队列 测试类
 * <p>
 * by MrThanksgiving
 */
public class QueueTest {

    @Test
    public  void test() throws InterruptedException {

        MyUtils.printStartLine();
        MyUtils.startTime();

        MyQueue<String> queue = new MyQueue<>();
        for (int i = 0; i < 1000; i++) {
            queue.add(String.valueOf(i));
        }
        MyUtils.endTime("queue add 1000 times cost ");
        MyUtils.print(queue.remove()+","+queue.remove()+","+queue.remove()+","+queue.remove());
        MyUtils.printLine();
        foreach(queue);

        MyUtils.endTime("queue foreach cost ");

        MyUtils.printEndLine();
        Assert.assertTrue(true);
    }


    public  void foreach(MyQueue<String> list) {
        list.iterator(s -> {
            MyUtils.print(s + " , ");
        });
        MyUtils.printLine();
    }


}
