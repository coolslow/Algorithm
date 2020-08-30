package com.coolslow.leetcode.top1000plus.playground;

import java.util.Arrays;
import java.util.Stack;

public class StackPlayground {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        if (s.empty()) {
            System.out.println("Stack is empty!");
        }

        s.pop();
        s.pop();
        s.pop();
        System.out.println("Stack contains items: " + Arrays.toString(s.toArray()));
        System.out.println("Stack size become: " + s.size());

        String hex = toHex(12500);
        System.out.println(hex);
    }

    // 利用Stack进行整数的进制转换
    public static String toHex(int n) {
        Stack<String> s = new Stack<>();
        while (n > 0) {
            int tmp = n % 16;
            n = n / 16;
            switch (tmp) {
                case 15:
                    s.push("F");
                    break;
                case 14:
                    s.push("E");
                    break;
                case 13:
                    s.push("D");
                    break;
                case 12:
                    s.push("C");
                    break;
                case 11:
                    s.push("B");
                    break;
                case 10:
                    s.push("A");
                    break;
                default:
                    s.push(Integer.toString(tmp));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }

        return sb.toString();
    }
}
