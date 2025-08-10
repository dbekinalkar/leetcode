/*
 * @lc app=leetcode id=981 lang=cpp
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
class TimeMap {
public:
    TimeMap() {
    }
    
    void set(string key, string value, int timestamp) {
        std::map<int, std::string>& tvmap = ktmap_[key];
        tvmap[-timestamp] = value;
    }
    
    string get(string key, int timestamp) {
        std::map<int, std::string>& tvmap = ktmap_[key];

        auto it = tvmap.lower_bound(-timestamp);

        if(it == tvmap.end()) {
            return "";
        }

        return it->second;
    }
private:
    std::map<std::string, std::map<int, std::string>> ktmap_;
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */
// @lc code=end

