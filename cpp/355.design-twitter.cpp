/*
 * @lc app=leetcode id=355 lang=cpp
 *
 * [355] Design Twitter
 */

// @lc code=start
struct Tweet {
    int timestamp;
    int tweetId;
    int userId;
};

class Twitter {
public:
    Twitter() {
        
    }
    
    void postTweet(int userId, int tweetId) {
        posts_map_[userId].push_back({timestamp_, tweetId, userId});
        timestamp_++;
    }
    
    vector<int> getNewsFeed(int userId) {
        using T = vector<Tweet>::reverse_iterator;
        auto compare = [](T a, T b) {return a->timestamp < b->timestamp;};
        priority_queue<T, vector<T>, decltype(compare)> pq(compare);

        if(posts_map_[userId].rbegin() != posts_map_[userId].rend()) {
            pq.push(posts_map_[userId].rbegin());
        }

        for(int followeeId : following_map_[userId]) {
            if(posts_map_[followeeId].rbegin() != posts_map_[followeeId].rend()) {
                pq.push(posts_map_[followeeId].rbegin());
            }
        }

        vector<int> res;

        int k = 10;
        while(k-- && !pq.empty()) {
            auto it = pq.top();
            res.push_back(it->tweetId);
            pq.pop();
            if(it + 1 != posts_map_[it->userId].rend()) {
                pq.push(it + 1);
            }
        }

        return res;
    }
    
    void follow(int followerId, int followeeId) {
        following_map_[followerId].insert(followeeId);
    }
    
    void unfollow(int followerId, int followeeId) {
        following_map_[followerId].erase(followeeId);
    }
private:
    int timestamp_ = 0;
    unordered_map<int, unordered_set<int>> following_map_;
    unordered_map<int, vector<Tweet>> posts_map_;
};

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter* obj = new Twitter();
 * obj->postTweet(userId,tweetId);
 * vector<int> param_2 = obj->getNewsFeed(userId);
 * obj->follow(followerId,followeeId);
 * obj->unfollow(followerId,followeeId);
 */
// @lc code=end

