/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        Deque<Character> q = new ArrayDeque<>(s.length());
        char c;

        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    q.push(s.charAt(i));
                    break;

                case ')':
                    if(q.size() == 0 || q.pop() != '(') return false;
                    break;
                case ']':
                    if(q.size() == 0 || q.pop() != '[') return false;
                    break;
                case '}':
                    if(q.size() == 0 || q.pop() != '{') return false;
                    break;
            } 
        }

        return q.size() == 0;
    }
}
// @lc code=end

