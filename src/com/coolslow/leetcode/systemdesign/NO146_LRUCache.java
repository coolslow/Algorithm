package com.coolslow.leetcode.systemdesign;

/**
 * 146. LRU缓存机制
 * 参考：https://baike.baidu.com/item/LRU
 * LRU即：最近最少使用（Least Recently Used）
 * 是一种常用的页面置换算法，选择最近最久未使用的页面予以淘汰。
 *
 * 题目：
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
 *
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 更进一步：能否在O(1)时间复杂度内完成该操作?
 *
 * 示例：
 * <code>
 *     LRUCache cache = new LRUCache(2); // 缓存容量为2
 *     cache.put(1, 1);
 *     cache.put(2, 1);
 *     cache.get(1);      // 返回 1
 *     cache.put(3, 3);   // 该操作会使得关键字2作废
 *     cache.get(2);      // 返回 -1（未找到）
 *     cache.put(4, 4);   // 该操作会使得关键字 1 作废
 *     cache.get(1);      // 返回 -1 (未找到)
 *     cache.get(3);      // 返回 3
 *     cache.get(4);      // 返回 4
 * </code>
 *
 */
public class NO146_LRUCache {
}
