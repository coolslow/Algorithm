package com.coolslow.leetcode.top1000plus.datastructure;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private List<Integer> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    // 入栈
    public void push(int x) {
        data.add(x);
    }

    // 出栈
    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 获取栈顶元素
    public int top() {
        return data.get(data.size() - 1);
    }
}
