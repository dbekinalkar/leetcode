/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
class TimeMap {

    private Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        this.map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> tlist = this.map.get(key);
        if(tlist == null) {
            tlist = new ArrayList();
            this.map.put(key, tlist);
        }

        tlist.add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> tlist = this.map.get(key);

        if(tlist == null) {
            return "";
        }

        int l = 0;
        int r = tlist.size();
        int m;
        Pair<Integer, String> mPair;

        String res = "";

        while(l < r) {
            m = l + (r - l) / 2;
            mPair = tlist.get(m);
            if(mPair.getKey() <= timestamp) {
                l = m + 1;
                res = mPair.getValue();
            }
            else {
                r = m;
            }
        }

        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

