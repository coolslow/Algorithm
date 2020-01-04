package com.coolslow.top100;

import com.coolslow.leetcode.top100.playground.RemoveElementFromArrayPlayground;
import org.junit.Assert;
import org.junit.Test;

public class NO27RemoveElementFromArrayTest {
    @Test
    public void shouldRemoveCorrectElementFromArray() {
        int[] testArray1 = new int[] {1, 1, 2, 3, 4, 6};
        int[] testArray2 = new int[] {3, 2, 2, 3};
        int[] testArray3 = new int[] {2}; // 只有一个元素，目标元素与数组中的元素不match
        int result1 = RemoveElementFromArrayPlayground.removeElement(testArray1, 4);
        int result2 = RemoveElementFromArrayPlayground.removeElement(testArray2, 2);
        int result3 = RemoveElementFromArrayPlayground.removeElement(testArray3, 1);
        Assert.assertEquals(5, result1);
        Assert.assertEquals(2, result2);
        Assert.assertEquals(1, result3);
    }
}
