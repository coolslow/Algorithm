# 字符串匹配算法: KMP

Knuth-Morris-Pratt(KMP)算法是一种改进的字符串匹配算法，它的核心是利用匹配失败后的信息，尽量减少
模式串与主串的匹配次数以达到快速匹配的目的。

它的时间复杂度为：`O(m + n)`



## 参考
* https://blog.csdn.net/v_july_v/article/details/7041827