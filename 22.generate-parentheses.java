/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        char[] buf = new char[n*2];

        helper(n, n, 0, buf, list);

        return list;
    }

    public void helper(int front, int back, int index, char[] buf, List<String> list){
        if(index == buf.length){
            list.add(new String(buf));
            return;
        }

        if(front != 0){
            buf[index] = '(';
            helper(front-1, back, index+1, buf, list);
        }

        if(back > front){
            buf[index] = ')';
            helper(front, back-1, index+1, buf, list);
        }
    }
}
// @lc code=end

