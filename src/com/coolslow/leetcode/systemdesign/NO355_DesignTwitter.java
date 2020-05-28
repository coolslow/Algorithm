package com.coolslow.leetcode.systemdesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private static class Tweet {

    }

    public static class Twitter {

        private Map<Integer, Tweet> twitter;

        /** Initialize your data structure here. */
        public Twitter() {

        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {

        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed.
         * Each item in the news feed must be posted by users who the user followed or by the user himself.
         * Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> feeds = new ArrayList<>();

            return feeds;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {

        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {

        }
    }
}
