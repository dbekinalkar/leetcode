/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> mins;

    public MinStack() {
        stack = new ArrayList();
        mins = new ArrayList();
    }
    
    public void push(int val) {
        stack.add(val);
        int min = val;
        if(mins.size() - 1 >= 0) { 
            min = Math.min(val, mins.get(mins.size() - 1));
        }
        mins.add(min);
    }
    
    public void pop() {
        stack.remove(stack.size() - 1);
        mins.remove(mins.size() - 1);
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return mins.get(mins.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

