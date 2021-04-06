package com.coolslow.datastruct.array;

import com.coolslow.playground.array.Offer03_FindRepeatNumberInArray;
import org.junit.Assert;
import org.junit.Test;

public class Offer03_FindRepeatNumberInArrayTest {

    @Test
    public void testFindRepeatedNumber() {
        Offer03_FindRepeatNumberInArray t = new Offer03_FindRepeatNumberInArray();
        int[] testArray = new int[]{2, 3, 1, 0, 2, 5, 3};
        int res = t.findRepeatNumberII(testArray);

        Assert.assertEquals(2, res);
    }
}
