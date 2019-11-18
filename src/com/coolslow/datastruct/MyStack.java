package com.coolslow.datastruct;

import com.coolslow.utils.MyIterator;

/**
 * By MrZ
 * 2019-11-15
 */
public class MyStack<T> {

    private Node header = new Node();
    private int count = 0;

    public void push(T t) {
        Node node = new Node();
        node.data = t;
        node.next = null;
        Node currNode = header.next;
        if (currNode != null) {
            node.next = currNode;
        }
        header.next = node;
        count++;
    }

    public T pop() {
        Node node = header.next;
        if (node != null) {
            Node next = node.next;
            header.next = next;
            count--;
            return node.data;
        }
        return null;
    }

    public T peek() {
        Node node = header.next;
        if (node != null) {
            return node.data;
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public void iterator(MyIterator iterator) {
        Node p = header.next;
        while (p != null) {
            if (iterator != null) {
                iterator.call(p.data);
            }
            p = p.next;
        }
    }

    private final class Node {
        T data;
        Node next;
    }


}
