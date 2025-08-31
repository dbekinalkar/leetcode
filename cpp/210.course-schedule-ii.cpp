/*
 * @lc app=leetcode id=210 lang=cpp
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> indeg(numCourses);
        vector<vector<int>> outedge(numCourses);

        for(vector<int>& prereq : prerequisites) {
            indeg[prereq[0]]++;
            outedge[prereq[1]].push_back(prereq[0]);
        }

        vector<int> q;
        int front = 0;

        for(int i = 0; i < indeg.size(); i++) {
            if(indeg[i] == 0) {
                q.push_back(i);
            }
        }

        while(front != q.size()) {
            int taking = q[front];
            front++;

            for(int nextReq : outedge[taking]) {
                indeg[nextReq]--;
                if(indeg[nextReq] == 0) {
                    q.push_back(nextReq);
                }
            }
        }

        return q.size() == numCourses ? q : vector<int> {};
    }
};
// @lc code=end

