package com.coolslow.datastruct;

import com.coolslow.utils.MyIterator;

public class MyStack<T> {

    private Node head;
    private int size;

    public MyStack() {
    }

    public void push(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            newNode.next = curr;
            head = newNode;
        }
        size++;
    }

    public T peek() {
        return head.data;
    }

    public T pop() {
        if(head == null){
            return null;
        }
        Node result = head;
        head = result.next;
        size--;
        return result.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
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

        public Node(T d) {
            this.data = d;
        }
    }

}
