/*
 * @lc app=leetcode id=703 lang=cpp
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start
class KthLargest {
public:
    KthLargest(int k, vector<int>& nums) : k_(k) {
        for(int num : nums) {
            pq_.push(num);
            if(pq_.size() > k_) {
                pq_.pop();
            }
        }
    }
    
    int add(int val) {
        pq_.push(val);

        if(pq_.size() > k_) {
            pq_.pop();
        }

        return pq_.top();
    }
private:
    int k_;
    std::priority_queue<int, std::vector<int>, std::greater<int>> pq_;
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */
// @lc code=end

