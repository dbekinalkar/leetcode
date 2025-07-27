/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();

        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            List<String> list = map.get(key);
            if(list == null) {
                list = new ArrayList();
                map.put(key, list);
            }
            list.add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end

