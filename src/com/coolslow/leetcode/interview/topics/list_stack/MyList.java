package com.coolslow.leetcode.interview.topics.list_stack;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    // 用于存储元素(假设存储的是整数)
    private List<Integer> data;
    // 使用一个指针来标记起始位置
    private int start;

    public MyList() {
        data = new ArrayList<>();
        start = 0;
    }
    // 插入操作
    public boolean insert(int x) {
        data.add(x);
        return true;
    }
    // 删除操作
    public boolean delete() {
        if(isEmpty()) {
            return false;
        }
        start++;
        return true;
    }

    // 从队列前端取数据
    public int front() {
        return data.get(start);
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return start >= data.size();
    }
}
