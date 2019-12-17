package com.coolslow.datastruct;

import com.coolslow.utils.MyIterator;

/**
 * 栈
 * <p>
 * by MrThanksgiving
 */
public class MyStack<T> {

    private Node<T> head;
    private int size;

    public MyStack() {
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public T peek() {
        return head.data;
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        Node<T> result = head;
        head = result.next;
        size--;
        return result.data;
    }

    public boolean empty() {
        return size != 0;
    }

    public int size() {
        return size;
    }

    public void iterator(MyIterator<T> iterator) {
        Node<T> temp = head;
        while (temp != null) {
            if (iterator != null) {
                iterator.call(temp.data);
            }
            temp = temp.next;
        }
    }

    private static final class Node<T> {
        T data;
        Node<T> next;

        public Node(T d) {
            this.data = d;
        }
    }

}
