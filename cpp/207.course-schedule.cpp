/*
 * @lc app=leetcode id=207 lang=cpp
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> indeg(numCourses);
        vector<vector<int>> outedge(numCourses);

        for(vector<int>& prereq : prerequisites) {
            indeg[prereq[0]]++;
            outedge[prereq[1]].push_back(prereq[0]);
        }

        deque<int> q;

        for(int i = 0; i < indeg.size(); i++) {
            if(indeg[i] == 0) {
                q.push_back(i);
            }
        }

        int taken_courses = 0;

        while(!q.empty()) {
            int taking = q.front();
            q.pop_front();
            taken_courses++;

            for(int nextReq : outedge[taking]) {
                indeg[nextReq]--;
                if(indeg[nextReq] == 0) {
                    q.push_back(nextReq);
                }
            }
        }

        return taken_courses == numCourses;
    }
};
// @lc code=end

