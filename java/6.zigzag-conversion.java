/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        char[] res = new char[s.length()];

        int jumpLength = 2 * numRows - 2;

        int ri = 0;

        for(int i = 0; i < s.length(); i += jumpLength) {
            res[ri] = s.charAt(i);
            ri++;
        }

        int offset;

        for(int j = 1; j < numRows - 1; j++) {
            offset = 2 * (numRows - j - 1);
            for(int i = j; i < s.length(); i += jumpLength) {
                res[ri] = s.charAt(i);
                ri++;

                if(i + offset < s.length()) {
                    res[ri] = s.charAt(i + offset);
                    ri++;
                }
            }
        }


        for(int i = numRows - 1; i < s.length(); i += jumpLength) {
            res[ri] = s.charAt(i);
            ri++;
        }

        return new String(res);
    }
}
// @lc code=end

