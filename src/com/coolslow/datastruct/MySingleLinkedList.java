package com.coolslow.datastruct;

import com.coolslow.utils.MyIterator;

public class MySingleLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    public MySingleLinkedList() {
    }

    public void addFirst(T data) {
        Node temp = head;

        Node newNode = new Node(data);
        head = newNode;

        if (tail == null) {
            tail = newNode;
        } else {
            newNode.next = temp;
        }
        size++;
    }

    public void addLast(T data) {
        Node temp = tail;

        Node newNode = new Node(data);
        tail = newNode;
        if (head == null) {
            head = newNode;
        } else {
            temp.next = newNode;
        }
        size++;
    }

    public void add(int idx, T data) {
        if (idx < 0 || idx > size()) {
            return;
        }
        if (idx == 0) {
            addFirst(data);
        } else if (idx == size()) {
            addLast(data);
        } else {
            Node prev = findNode(idx - 1);
            if (prev != null) {
                Node temp = prev.next;
                Node newNode = new Node(data);
                newNode.next = temp;
                prev.next = newNode;
                size++;
            }
        }
    }

    public T remove(int idx) {
        if (idx < 0) {
            return null;
        } else if (idx == 0) {
            Node temp = head;
            if (temp != null) {
                head = temp.next;
                size--;
                if (isEmpty()) {
                    tail = null;
                }
                return temp.data;
            }
            return null;
        } else if (idx > 0 && idx < size()) {
            Node prev = findNode(idx - 1);
            if (prev != null) {
                Node result = prev.next;
                if (result != null) {
                    prev.next = result.next;
                    size--;
                    if (isEmpty()) {
                        tail = null;
                    }
                    return result.data;
                }
            }
        }
        return null;
    }

    public void set(int idx, T data) {
        if (idx < 0 || idx >= size()) {
            return;
        }
        Node node = findNode(idx);
        if (node != null) {
            node.data = data;
        }
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size()) {
            return null;
        }
        Node node = findNode(idx);
        if (node != null) {
            return node.data;
        }
        return null;
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    private Node findNode(int idx) {
        Node temp = head;
        int index = 0;
        while (index != idx && temp != null) {
            index++;
            temp = temp.next;
        }
        return temp;
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


    private class Node {
        T data;
        Node next;

        Node(T t) {
            data = t;
        }
    }

}
