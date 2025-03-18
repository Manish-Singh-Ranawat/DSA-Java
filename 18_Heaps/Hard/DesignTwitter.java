// Design Twitter - https://leetcode.com/problems/design-twitter/

// Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

// Implement the Twitter class:

// - Twitter() Initializes your twitter object.
// - void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
// - List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
// - void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
// - void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.

// Input :
// ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
// [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]

// Output : [null, null, [5], null, null, [6, 5], null, [5]]

// Explanation :
// Twitter twitter = new Twitter();
// twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
// twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
// twitter.follow(1, 2);    // User 1 follows user 2.
// twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
// twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
// twitter.unfollow(1, 2);  // User 1 unfollows user 2.
// twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {
    private int timeStamp;
    private Map<Integer, List<Tweet>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        this.timeStamp = 0;
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(timeStamp++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);
        for (int followee : followMap.get(userId)) {
            if (tweetMap.containsKey(followee)) {
                List<Tweet> listOfTweets = tweetMap.get(followee);
                int len = listOfTweets.size();
                Tweet latest = listOfTweets.get(len - 1);
                pq.offer(new Element(latest.time, latest.tweetId, followee, len - 1));
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty() && ans.size() < 10) {
            Element e = pq.poll();
            ans.add(e.tweetId);
            int idx = e.index;
            if (idx > 0) {
                List<Tweet> listOfTweets = tweetMap.get(e.followeeId);
                Tweet t = listOfTweets.get(idx - 1);
                pq.offer(new Element(t.time, t.tweetId, e.followeeId, idx - 1));
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId))
            followMap.get(followerId).remove(followeeId);
    }
}

class Tweet {
    int time;
    int tweetId;

    public Tweet(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }
}

class Element {
    int time;
    int tweetId;
    int followeeId;
    int index;

    public Element(int time, int tweetId, int followeeId, int index) {
        this.time = time;
        this.tweetId = tweetId;
        this.followeeId = followeeId;
        this.index = index;
    }
}

public class DesignTwitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1)); // [5]
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1)); // [6, 5]
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); // [5]
    }
}
