package com.coolslow.leetcode.top1000plus;

/**
 * 896. 单调数列
 * 如果数组是单调递增或递减的，那么它就是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组A是单调递增的。
 * 如果对于所有 i <= j，A[i] >= A[j]，那么数组A是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 */
public class NO896_MonotonicArray {
    public boolean isMonotonic(int[] A) {
        return isSorted(A, true) || isSorted(A, false);
    }

    public boolean isSorted(int[] A, boolean increasing) {
        int n = A.length;
        if (increasing) {
            for (int i = 0; i < n - 1; i++) {
                if (A[i] > A[i + 1]) {
                    return false;
                }
            }
        } else {
            for(int i = 0; i < n- 1; i++) {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
