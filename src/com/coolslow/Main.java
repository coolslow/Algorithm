package com.coolslow;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String greeting = "Hello World Algorithm";
        System.out.println(greeting);

        String s = "(()))";
        isValid(s);

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == '(') {
//                stack.push('(');
//            } else if(!stack.empty() && stack.peek() == '(') {
//                stack.pop();
//            } else {
//                return false;
//            }
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' && !stack.empty()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}

