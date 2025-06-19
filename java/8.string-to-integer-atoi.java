/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int i = 0;

        while(i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if(i >= s.length()) {
            return 0;
        }

        boolean isPositive = true;
        if(s.charAt(i) == '+') {
            i++;
        }
        else if (s.charAt(i) == '-') {
            isPositive = false;
            i++;
        }

        long result = 0;

        while(i < s.length()) {
            if(s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            result *= 10;
            result += s.charAt(i) - '0';

            if(result > Integer.MAX_VALUE) {
                return isPositive? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }

            i++;
        }

        if(!isPositive) {
            result *= -1;
        }

        return (int) result;

    }
}
// @lc code=end

