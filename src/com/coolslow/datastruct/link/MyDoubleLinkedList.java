package com.coolslow.datastruct.link;


import com.coolslow.datastruct.utils.MyIterator;

/**
 * 双链表
 * <p>
 * by MrThanksgiving
 */
public class MyDoubleLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    public MyDoubleLinkedList() {
        size = 0;
    }

    public void addFirst(T data) {
        Node h = head;
        Node newNode = new Node(null, data, h);
        head = newNode;
        if (h == null) {
            tail = newNode;
        } else {
            h.prev = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node t = tail;
        Node newNode = new Node(t, data, null);
        tail = newNode;
        if (t == null) {
            head = newNode;
        } else {
            t.next = newNode;
        }
        size++;
    }

    public void add(int idx, T data) {
        if (!isPositionIndex(idx)) {
            return;
        }
        if (idx == size()) {
            addLast(data);
            return;
        }
        Node curr = searchNode(idx);
        Node newNode = new Node(curr.prev, data, curr);
        if (curr.prev != null) {
            curr.prev.next = newNode;
        } else {
            head = newNode;
        }
        curr.prev = newNode;
        size++;
    }

    public T remove(int idx) {
        if (isIndexValid(idx)) {
            return null;
        }
        Node curr = searchNode(idx);
        Node prev = curr.prev;
        Node next = curr.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
        size--;
        return curr.data;
    }

    public void set(int idx, T data) {
        Node curr = searchNode(idx);
        curr.data = data;
    }

    public T get(int idx) {
        if (isIndexValid(idx)) {
            return null;
        }
        Node curr = searchNode(idx);
        return curr.data;
    }

    private Node searchNode(int idx) {
        if (idx < (size() >> 1)) {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            Node temp = tail;
            for (int i = size() - 1; i > idx; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private boolean isIndexValid(int index) {
        return index < 0 || index >= size;
    }

    public void iterator(MyIterator<T> iterator) {
        Node temp = head;
        while (temp != null) {
            iterator.call(temp.data);
            temp = temp.next;
        }
    }

    public int size() {
        return size;
    }

    private final class Node {
        Node prev;
        Node next;
        T data;

        Node(Node prev, T data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

}
