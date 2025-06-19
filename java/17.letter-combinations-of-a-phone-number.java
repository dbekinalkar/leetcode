/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    char[][] digitToChar = {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits.length() == 0) {
            return res;
        }

        char[] out = new char[digits.length()];

        helper(digits, 0, out, res);

        return res;
    }

    public void helper(String digits, int i, char[] out, List<String> res) {
        if(i >= digits.length()) {
            res.add(new String(out));
            return;
        }
        int digitIndex = digits.charAt(i) - '0' - 2;

        for(int j = 0; j < digitToChar[digitIndex].length; j++) {
            out[i] = digitToChar[digitIndex][j];
            helper(digits, i+1, out, res);
        }
    }

}
// @lc code=end

