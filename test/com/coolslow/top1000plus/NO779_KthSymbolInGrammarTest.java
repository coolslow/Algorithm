package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO779_KthSymbolInGrammar;
import org.junit.Assert;
import org.junit.Test;

public class NO779_KthSymbolInGrammarTest {
    @Test
    public void findKthSymbolInGrammarCorrectly() {
        int result = NO779_KthSymbolInGrammar.kthGrammar(1, 1);
        int result1 = NO779_KthSymbolInGrammar.kthGrammar(2, 1);
        int result2 = NO779_KthSymbolInGrammar.kthGrammar(2, 2);

        int result3 = NO779_KthSymbolInGrammar.kthGrammarWithRecursive(1, 1);
        int result4 = NO779_KthSymbolInGrammar.kthGrammarWithRecursive(1, 1);

        Assert.assertEquals(0, result);
        Assert.assertEquals(0, result1);
        Assert.assertEquals(1, result2);

        Assert.assertEquals(0, result3);
        Assert.assertEquals(0, result4);
    }
}
