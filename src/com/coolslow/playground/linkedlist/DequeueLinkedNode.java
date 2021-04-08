package com.coolslow.playground.linkedlist;

/**
 * 自实现的一个双端链表
 */
public class DequeueLinkedNode {
    int key;
    int val;
    DequeueLinkedNode prev;
    DequeueLinkedNode next;
    public DequeueLinkedNode() {}
    public DequeueLinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
