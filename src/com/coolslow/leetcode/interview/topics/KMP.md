# 字符串匹配算法: KMP

Knuth-Morris-Pratt(KMP)算法是一种改进的字符串匹配算法，它的核心是利用匹配失败后的信息，尽量减少
模式串与主串的匹配次数以达到快速匹配的目的。

它的时间复杂度为：`O(m + n)`

## 在简介之前

> 在了解KMP算法之前，需要先了解一下普通的（暴力）字符串匹配算法是如何进行的
 
### 暴力匹配算法

假设现在我们面临这样一个问题：
有一个文本串S，和一个模式串P，现在要查找P在S中的位置，怎么查找呢？
如果用暴力匹配的思路，并假设现在文本串S匹配到 i 位置，模式串P匹配到 j 位置，则有：
如果当前字符匹配成功（即S[i] == P[j]），则i++，j++，继续匹配下一个字符；
如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0。相当于每次匹配失败时，i 回溯，j 被置为0。

```java
public static int bruteForceStringMatch(String s, String p) {
    int sLen = s.length();
    int pLen = p.length();

    int i = 0, j = 0;
    while(i < sLen && j < pLen) {
        // 如果当前字符匹配成功，则i++，j++
        if (s.charAt(i) == p.charAt(j)) {
            i++;
            j++;
        }
        // 如果失配令：i = i - j + 1，j = 0
        else {
            i = i - j + 1;
            j = 0;
        }
    }

    // 匹配成功，j的位置等于模式串p的长度
    // 返回模式串 p 在文本串 s 中的位置，否则返回 -1
    if (j == pLen) {
        return i - j;
    } else {
        return -1;
    }
}
```

### KMP算法

下面直接给出KMP的算法流程：
> 假设：现在文本串S匹配到 i 位置，模式串P匹配到 j 位置
> - 如果 j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++，继续匹配下一个字符；
> - 如果 j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]。此举意味着失配时，模式串P相对于文本串S向右移动了：j - next [j] 位。（next是一个数组，它的求解先放一下）
>   换言之，当匹配失败时，模式串向右移动的位数为：失配字符所在位置 - 失配字符对应的next值；即移动的实际位数为：j - next[j]，且此值大于等于1。

```c++
int KmpSearch(char* s, char* p) {
	int i = 0;
	int j = 0;
	int sLen = strlen(s);
	int pLen = strlen(p);
	while (i < sLen && j < pLen)
	{
		// 如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++    
		if (j == -1 || s[i] == p[j]) {
			i++;
			j++;
		} else {
			// 如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]    
			//next[j]即为j所对应的next值      
			j = next[j];
		}
	}
	if (j == pLen) {
        return i - j;
    } else {
        return -1;
    }		
}
```

下面，KMP算法的关键就在于对next数组如何求解。KMP的 next 数组相当于告诉我们：
当模式串中的某个字符跟文本串中的某个字符匹配失配时，模式串下一步应该跳到哪个位置。
如模式串中在 j 处的字符跟文本串在 i 处的字符匹配失配时，下一步用next [j] 处的字符继续跟文本串 i 处的字符匹配，相当于模式串向右移动 j - next[j] 位。

### 寻找最长前缀后缀


## 参考
* https://blog.csdn.net/v_july_v/article/details/7041827 (这是我目前看到的最好的关于KMP算法的全面剖析，且对KMP算法的扩展：BM、Sunday算法进行了介绍)