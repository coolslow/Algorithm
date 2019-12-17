package com.coolslow.struct;

import com.coolslow.datastruct.MyStack;
import com.coolslow.utils.MyUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 栈 测试类
 * <p>
 * by MrThanksgiving
 */
public class StackTest {

    @Test
    public void test() {
        MyUtils.printStartLine();
        MyUtils.startTime();
        MyStack<String> stack = new MyStack<>();
        for (int i = 0; i < 1000; i++) {
            stack.push(String.valueOf(i));
        }
        stack.pop();
        stack.pop();

        MyUtils.endTime("stack push 1000 times cost ");

        foreach(stack);

        MyUtils.endTime("stack foreach cost ");
        MyUtils.printEndLine();
        Assert.assertTrue(true);
    }

    public void foreach(MyStack<String> list) {
        list.iterator(s -> {
            MyUtils.print(s + " , ");
        });
        MyUtils.printLine();
    }


}
