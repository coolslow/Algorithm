package com.coolslow.datastruct.link;

import com.coolslow.datastruct.utils.MyIterator;

import java.lang.reflect.Array;

/**
 * 单链表
 * <p>
 * by MrThanksgiving
 */
public class MySingleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MySingleLinkedList() {
    }

    public void addFirst(T data) {
        Node<T> temp = head;

        Node<T> newNode = new Node<>(data);
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

        Node<T> newNode = new Node<>(data);
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
            Node<T> prev = findNode(idx - 1);
            if (prev != null) {
                Node<T> temp = prev.next;
                Node<T> newNode = new Node<>(data);
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
            Node<T> temp = head;
            if (temp != null) {
                head = temp.next;
                size--;
                if (isEmpty()) {
                    tail = null;
                }
                return temp.data;
            }
            return null;
        } else if (idx < size()) {
            Node<T> prev = findNode(idx - 1);
            if (prev != null) {
                Node<T> result = prev.next;
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
        Node<T> node = findNode(idx);
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

    private Node<T> findNode(int idx) {
        Node<T> temp = head;
        int index = 0;
        while (index != idx && temp != null) {
            index++;
            temp = temp.next;
        }
        return temp;
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

    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        if (a.length != size)
            a = (E[]) Array.newInstance(a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (Node<T> x = head; x != null; x = x.next)
            result[i++] = x.data;
        return a;
    }


    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T t) {
            data = t;
        }
    }

}
