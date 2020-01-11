<<<<<<< HEAD:src/com/coolslow/leetcode/top100/NO07_ReverseInteger.java
package com.coolslow.leetcode.top100;
=======
package com.coolslow.leetcode.top100plus;
>>>>>>> develop:src/com/coolslow/leetcode/top100plus/NO07_ReverseInteger.java

/**
 * 7. 整数反转
 *
 * 给出一个32位的有符号整数，需要将这个整数中每位上的数字进行反转。
 *
 * 示例1：
 *      输入：123
 *      输出：321
 *
 * 示例2：
 *      输入：-123
 *      输出：-321
 *
 * 示例3：
 *      输入：120
 *      输出：21
 *
 * 注意：假设我们的环境只能存储32位的有符号整数，则其数值范围位[-2^31, 2^31 - 1]。
 * 请根据这个假设，如果反转后这个整数溢出那么就返回0。
 *
 * 思路：
 * 反转一个整数和反转一个string有些相似。
 *
 * 我们希望重复的pop出给定有符号数字的最后一个数，并将其反向推入rev中。最后，rev将会成为x的反转数。
 * 在不借助 stack/array "pop" 和 "push"数字的情况下，我们需要利用数学方法。
 *
 * // pop operation:
 * pop = x % 10;
 * x /= 10;
 *
 * // push operation:
 * temp = rev * 10 + pop;
 * rev = temp;
 */
public class NO07_ReverseInteger {

    public static int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            // If reverse == Integer.MAX_VALUE/10, then reverse = 2,147,483,640.
            // We know that anything over 2,147,483,647 causes integer overflow, so pop cannot be greater than 7.
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7))
                return 0;
            // Likewise, if reverse == Integer.MIN_VALUE/10, then reverse = -2,147,483,640.
            // We know that anything under -2,147,483,648 causes integer underflow, so pop cannot be less than -8.
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
