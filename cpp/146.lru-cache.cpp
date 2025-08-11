/*
 * @lc app=leetcode id=146 lang=cpp
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
public:
    LRUCache(int capacity) : capacity_(capacity) {}

    int get(int key) {
        auto it = map_.find(key);
        if (it == map_.end()) {
            return -1; 
        }
        list_.splice(list_.begin(), list_, it->second);
        
        return it->second->second;
    }

    void put(int key, int value) {
        auto it = map_.find(key);
        
        if (it != map_.end()) {
            it->second->second = value;
            list_.splice(list_.begin(), list_, it->second);

            return;
        }

        if (list_.size() == capacity_) {
            map_.erase(list_.back().first);
            list_.pop_back();
        }

        list_.emplace_front(key, value);
        map_[key] = list_.begin();
    }

private:
    int capacity_;
    std::list<std::pair<int, int>> list_;
    std::unordered_map<int, std::list<std::pair<int, int>>::iterator> map_;
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
// @lc code=end

