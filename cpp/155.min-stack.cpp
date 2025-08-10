/*
 * @lc app=leetcode id=155 lang=cpp
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
public:
    MinStack() {
        stk_.emplace(INT_MAX, INT_MAX);
    }
    
    void push(int val) {
        int min = std::min(val, stk_.top().second);
        stk_.emplace(val, min); 
    }
    
    void pop() {
        stk_.pop();
    }
    
    int top() {
        return stk_.top().first;
    }
    
    int getMin() {
        return stk_.top().second;
    }

private:
    std::stack<std::pair<int, int>> stk_;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
// @lc code=end

