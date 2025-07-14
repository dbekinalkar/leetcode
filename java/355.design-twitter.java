/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Tweet {
    public int index;
    public int userId;
    public int timestamp;
    public int tweetId;

    public Tweet(int index, int userId, int timestamp, int tweetId) { 
        this.index = index;
        this.userId = userId;
        this.timestamp = timestamp;
        this.tweetId = tweetId;
    }
}

class Twitter {

    private Map<Integer, List<Tweet>> tweets;
    private int clock;
    private Map<Integer, Set<Integer>> follows;

    public Twitter() {
        tweets = new HashMap();
        clock = 0;
        follows = new HashMap();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Tweet> userTweets = this.tweets.get(userId);
        if(userTweets == null) {
            userTweets = new ArrayList();
            this.tweets.put(userId, userTweets);
        }

        userTweets.add(new Tweet(userTweets.size(), userId, this.clock, tweetId));
        this.clock++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> userFollows = this.follows.get(userId);

        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(Comparator.comparingInt(t -> -1 * t.timestamp));

        List<Tweet> userTweets = this.tweets.get(userId);
        if(userTweets != null) {
            pq.add(userTweets.get(userTweets.size() - 1));
        }

        if(userFollows != null) {
            for(Integer followee: userFollows) {
                userTweets = this.tweets.get(followee);
                if(userTweets == null) continue;

                pq.add(userTweets.get(userTweets.size() - 1));
            }
        }

        List<Integer> res = new ArrayList();
        while(res.size() < 10 && !pq.isEmpty()) {
            Tweet t = pq.poll();

            res.add(t.tweetId);
            
            if(t.index == 0) continue;

            pq.add(this.tweets.get(t.userId).get(t.index - 1));
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> userFollows = this.follows.get(followerId);
        if(userFollows == null) {
            userFollows = new HashSet();
            this.follows.put(followerId, userFollows);
        }

        userFollows.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> userFollows = this.follows.get(followerId);
        if(userFollows == null) {
            return;
        }

        userFollows.remove(followeeId);
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

