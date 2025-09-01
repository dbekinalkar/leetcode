/*
 * @lc app=leetcode id=684 lang=cpp
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        unordered_map<int, int> parent;
        unordered_map<int, int> size;

        function<int(int)> find = [&](int x) {
            if(parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        };

        auto unionf = [&](int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) return false;

            if(size[rootX] < size[rootY]) {
                int tmp = rootY;
                rootY = rootX;
                rootX = tmp;
            }

            parent[rootY] = rootX;

            size[rootX] += size[rootY];
            return true;
        };

        for(vector<int>& e : edges) {
            if(!parent.contains(e[0])) {
                parent[e[0]] = e[0];
                size[e[0]] = 1;
            }

            if(!parent.contains(e[1])) {
                parent[e[1]] = e[1];
                size[e[1]] = 1;
            }

            if(!unionf(e[0], e[1])) {
                return e;
            }
        }

        return {};
    }
};
// @lc code=end

