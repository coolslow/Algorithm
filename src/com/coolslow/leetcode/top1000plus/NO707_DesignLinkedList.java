package com.coolslow.leetcode.top1000plus;

/**
 * 707. 设计链表
 *
 * 设计链表的实现，可以选择单链表或双链表。单链表中的节点应该具有两个属性：
 * val 和 next。val 是当前节点的值，next是指向下一个节点的引用（指针）。
 * 如果要使用双向链表，则还需要一个属性prev以只是链表中的上一个节点。假设链表中的所有节点都是0-index的。
 *
 * 在链表的类中实现如下功能：
 *  - get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回 -1。
 *  - addAtHead(val)：在链表的第一个原始之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 *  - addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 *  - addAtHead(index, val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度。
 *    则该节点将附加到链表的末尾。如果 index 大于链表的长度，则不会插入节点。如果 index 小于 0，则在头部插入节点。
 *  - deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 *
 * 示例：
 *    MyLinkedList linkedList = new MyLinkedList();
 *    inkedList.addAtHead(1);
 *    linkedList.addAtTail(3);
 *    linkedList.addAtIndex(1,2);   // 链表变为1-> 2-> 3
 *    linkedList.get(1);            // 返回2
 *    linkedList.deleteAtIndex(1);  // 现在链表是1-> 3
 *    linkedList.get(1);            // 返回3
 *
 * 提示：
 *  - 所有val值都在 [1, 1000] 之内。
 *  - 操作次数将在  [1, 1000] 之内。
 *  - 请不要使用内置的 LinkedList 库。
 *
 */
public class NO707_DesignLinkedList {

    /**
     * 单链表结构定义
     */
    public class SingleListNode {
        int val;
        SingleListNode next;
        public SingleListNode(int x) {
            val = x;
        }
    }

    class MyLinkedList {
        int size;
        SingleListNode head; // 将哨兵节点作为伪头节点

        public MyLinkedList() {
            size = 0;
            head = new SingleListNode(0);
        }
    }
}
