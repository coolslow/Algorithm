package com.coolslow.leetcode.systemdesign;

import java.util.*;

/**
 * TAG: 系统设计
 * 355. 设计Twitter
 *
 * 题目: 设计一个简化版的推特Twitter，可以让用户实现发送推文，关注、取消其他用户，能够看见关注人（包括自己）的最近失调推文。你的设计需要支持以下的几个功能：
 *
 * 1. postTweet(userId, tweetId) - 创建一条新的推文
 * 2. getNewsFeed(userId) - 检索最近的十条推文，每个推文都必须是由用此户关注的人或者用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * 3. follow(followerId, followeeId) - 关注一个用户
 * 4. unfollow(followerId, followeeId) - 取消关注一个用户
 *
 * 示例：
 * Twitter twitter = new Twitter();
 *
 * >> 用户发送了一条新推文（用户Id = 1，推文Id = 5）
 * twitter.postTwitt(1, 5)
 *
 * >> 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文
 * twitter.getNewsFeed(1); // 1 表示用户Id = 1
 *
 * >> 用户Id = 1关注了用户Id = 2的用户
 * twitter.follow(1, 2)
 *
 * >> 用户Id = 2发送了一个新的推文(推文Id = 6)
 * twitter.postTweet(2, 6)
 *
 * >> 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * >> 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * >> 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * >> 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * >> 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 *
 */
public class NO355_DesignTwitter {
    // 推文类，是一个单链表
    private static class Tweet {
        // 推文ID
        private int id;
        // 发推时间戳
        private int timestamp;
        private Tweet next;

        // Tweet的构造函数
        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    public static class Twitter {

        // 用户 id 和推文（单链表）的对应关系
        private Map<Integer, Tweet> twitter;
        // 用户 id 和他关注的用户列表的对应关系
        private Map<Integer, Set<Integer>> followings;
        // 全局使用的时间戳，用户每发布一条推文 + 1
        private static int timestamp = 0;

        private static PriorityQueue<Tweet> maxHeap;
        /** Initialize your data structure here. */
        public Twitter() {
            followings = new HashMap<>();
            twitter = new HashMap<>();
            maxHeap = new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp);
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            timestamp++;
            if(twitter.containsKey(userId)) {
                Tweet oldHead = twitter.get(userId);
                Tweet newHead = new Tweet(tweetId, timestamp);
                newHead.next = oldHead;

                twitter.put(userId, newHead);
            } else {
                twitter.put(userId, new Tweet(tweetId, timestamp));
            }
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed.
         * Each item in the news feed must be posted by users who the user followed or by the user himself.
         * Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {

            // 由于是全局使用的，使用之前需要清空
            maxHeap.clear();

            // 如果自己发了推文也要算上
            if (twitter.containsKey(userId)) {
                maxHeap.offer(twitter.get(userId));
            }

            Set<Integer> followingList = followings.get(userId);
            if(followingList != null && followingList.size()> 0) {
                for (int followingId : followingList) {
                    Tweet tweet = twitter.get(followingId);
                    if (tweet != null) {
                        maxHeap.offer(tweet);
                    }
                }
            }

            List<Integer> feeds = new ArrayList<>(10);
            int count = 0;
            while (!maxHeap.isEmpty() && count < 10){
                Tweet head = maxHeap.poll();
                feeds.add(head.id);
                if (head.next != null) {
                    maxHeap.offer(head.next);
                }
                count++;
            }

            return feeds;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }

            Set<Integer> followingList = followings.get(followerId);
            if (followingList == null) {
                Set<Integer> followeeSet = new HashSet<>();
                followeeSet.add(followeeId);
                followings.put(followerId, followeeSet);
            } else {
                if (followingList.contains(followeeId)) {
                    return;
                }
                followingList.add(followeeId);
            }
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (followeeId == followerId) {
                return;
            }

            // 获取我自己的关注列表
            Set<Integer> followingList = followings.get(followerId);

            if (followingList == null) {
                return;
            }

            // 这里删除之前无需做判断，因为查找是否存在以后，就可以删除，反正删除之前都要查找
            followingList.remove(followeeId);
        }
    }
}
