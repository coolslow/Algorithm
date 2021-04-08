package com.coolslow.playground.linkedlist;

final class Node {
    public Node prev, next;
    public int key, val;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class DequeueLinkedList {
    private Node head, tail;
    private int size;

    public DequeueLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addLast(Node x) {
        // 向尾部添加Node
        x.prev = tail.prev;
        x.next = tail;

        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public Node removeFirst() {
        if(head.next == tail) {
            return null;
        }
        Node first = head.next;
        // 去除旧的头结点
        remove(first);
        // first已经变为头结点
        return first;
    }

    public int size() {
        return size;
    }
}
