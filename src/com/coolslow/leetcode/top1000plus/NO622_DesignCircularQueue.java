package com.coolslow.leetcode.top1000plus;

/**
 * 622. 设计循环队列
 *
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 *
 * 你的实现应该支持如下操作：
 *
 * - MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * - Front: 从队首获取元素。如果队列为空，返回 -1 。
 * - Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * - enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * - deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * - isEmpty(): 检查循环队列是否为空。
 * - isFull(): 检查循环队列是否已满。
 *  
 * 示例：
 *
 * <code>
 *     MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 *     circularQueue.enQueue(1);  // 返回 true
 *     circularQueue.enQueue(2);  // 返回 true
 *     circularQueue.enQueue(3);  // 返回 true
 *     circularQueue.enQueue(4);  // 返回 false，队列已满
 *     circularQueue.Rear();      // 返回 3
 *     circularQueue.isFull();    // 返回 true
 *     circularQueue.deQueue();   // 返回 true
 *     circularQueue.enQueue(4);  // 返回 true
 *     circularQueue.Rear();      // 返回 4
 * </code>
 *
 */
public class NO622_DesignCircularQueue {

    /**
     * 循环队列，对于一个固定大小的数组，只要知道队列长度，就可以根据如下公式计算出队尾位置：
     *
     * tailIndex = (headIndex + count - 1) mod capacity
     * capacity: 数组长度
     * count: 队列长度
     * headIndex: 队首 head 索引
     * tailIndex: 队尾 tail 索引
     */
    public class MyCircularQueue {
        private int[] queue; // 队列
        private int headIndex;
        private int tailIndex;
        private int capacity;

        public MyCircularQueue(int k) {
            this.queue = new int[k];
            this.headIndex = -1;
            this.tailIndex = -1;
            this.capacity = k;
        }

        // 入队操作
        public boolean enQueue(int value) {
            // 如果队列长度已经达到容积，无法入队
            if (isFull()) {
                return false;
            }

            if(isEmpty()) {
                this.headIndex = 0;
            }

            this.tailIndex = (this.tailIndex + 1) % this.capacity;
            this.queue[this.tailIndex] = value;
            return true;
        }

        // 出队操作
        public boolean deQueue() {
            // 表示循环队列中没有元素
            if (isEmpty()) {
                return false;
            }

            // 头尾指针重合，表示队列已经为空了，可以直接返回
            if (this.tailIndex == this.headIndex) {
                this.headIndex = -1;
                this.tailIndex = -1;
                return true;
            }

            // 出队是从队头拿掉元素，因此需要重新计算headIndex下标
            this.headIndex = (this.headIndex + 1) % this.capacity;
            return true;
        }

        // 从队头获取元素
        public int Front() {
            if (isEmpty()) {
                return -1;
            }

            return this.queue[this.headIndex];
        }

        // 获取队尾的元素
        public int Rear() {
            if(isEmpty()) {
                return -1;
            }

            return this.queue[this.tailIndex];
        }

        public boolean isEmpty() {
            return this.headIndex == -1;
        }

        public boolean isFull() {
            return (this.tailIndex + 1) % this.capacity == this.headIndex;
        }
    }
}
