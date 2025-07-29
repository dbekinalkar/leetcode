/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] freq = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s1.length(); i++) {
            freq[s2.charAt(i) - 'a']--;
        }

        boolean zero = true;
        for(int f : freq) {
            if(f != 0) {
                zero = false;
                break;
            }
        }

        if(zero) return true;

        for(int r = s1.length(); r < s2.length(); r++) {
            int l = r - s1.length();
            freq[s2.charAt(l) - 'a']++;
            freq[s2.charAt(r) - 'a']--;

            zero = true;
            for(int f : freq) {
                if(f != 0) {
                    zero = false;
                    break;
                }
            }

            if(zero) return true;
        }

        return false;
    }
}
// @lc code=end

