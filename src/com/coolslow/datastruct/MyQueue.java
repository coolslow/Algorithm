package com.coolslow.datastruct;

import com.coolslow.utils.MyIterator;

public class MyQueue<T> {


    private Node head;
    private Node tail;
    private int size;

    public MyQueue() {
    }

    public void add(T data) {
        Node newNode = new Node(data);
        Node temp = tail;
        tail = newNode;
        if (head == null) {
            head = newNode;
        } else {
            temp.next = newNode;
        }
        size++;
    }

    public T peek() {
        if (head == null) {
            return null;
        }
        Node node = head;
        return node.data;
    }

    public T remove() {
        if (head == null) {
            return null;
        }
        Node result = head;
        head = result.next;
        return result.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void iterator(MyIterator<T> iterator) {
        Node temp = head;
        while (temp != null) {
            if (iterator != null) {
                iterator.call(temp.data);
            }
            temp = temp.next;
        }
    }

    private final class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

}
