package com.coolslow.leetcode.top100plus;

import com.coolslow.leetcode.top100plus.datastructure.ListNode;

/**
 * @author ming
 *
 * 2. 两数相加
 * 给定两个 [非空] 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 [逆序] 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加，则会返回一个新的链表来表示它们的和。
 * 你可以假设：除了数字 0 之外，这两个数都不会以0开头。
 *
 * 示例：
 *      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      输出：7 -> 0 -> 8
 *      原因：342 + 456 = 807
 *
 * 相关标签：链表、数字
 *
 */
public final class NO02_AddTwoNumbers {

    /**
     * 方法：初等数学
     *
     * 思路：
     * 使用变量跟踪进位，并从包含最低有效位的表头开始模拟逐位相加的过程。
     *
     * 伪代码如下：
     *   - 将当前节点初始化为返回列表的哑节点
     *   - 将进位 carry 初始化为0
     *   - 将 p 和 q 分别初始化为列表 l1 he l2 的头部
     *   - 编列列表 l1 和 l2 直至到达他们各自的尾端
     *     a. 将x设置为节点p的值。如果p已经到达l1的末尾，则将其值设置为0
     *     b. 将y设置为节点q的值。如果q已经到达l2的末尾，则将其值设置为0
     *     c. 设定 sum = x + y + carry
     *     d. 更新进位的值，carry = sum / 10
     *     e. 创建一个数值为(sum mod 10)的新节点，并将其设置为当前节点的下一个节点，然后将当前节点前进到下一个节点
     *     f. 同时，将p和q前进到下一个节点。
     *   - 检查 carry = 1 是否成立，如果成立，则向返回列表追加一个含有数字1的新节点。
     *   - 返回哑节点的下一个节点。
     *
     *
     * 复杂度分析：
     *   - 时间复杂度：O(max(m, n))，假设 m 和 n 分别表示 l1 和 l2 的长度，上面的算法最多重复 max(m, n) 次。
     *   - 空间复杂度：O(max(m, n))，新列表的长度最多为 max(m,n) + 1。
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 新的包含 l1 和 l2 的排序链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 设置一个哑节点
        ListNode head = new ListNode(0);
        // 将当前指针指向head，即新创建的链表的头部
        ListNode curr = head, p = l1, q = l2;
        // 进位
        int carry = 0;

        while(p!= null || q != null) {
            // 将 x 设为结点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0
            int x = (p != null) ? p.val : 0;
            // 将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
            int y = (q != null) ? q.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            // 指针向后移动
            curr = curr.next;

            if(p != null) {
                p = p.next;
            }

            if(q != null) {
                q = q.next;
            }
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }
}
