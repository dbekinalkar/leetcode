/*
 * @lc app=leetcode id=102 lang=cpp
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        std::vector<std::vector<int>> res;
        if(!root) return res;
        std::queue<TreeNode*> q;

        q.push(root);

        int levelCount = 0;
        int nextLevelCount = 1;
        while(!q.empty()) {
            if(levelCount == 0) {
                levelCount = nextLevelCount;
                nextLevelCount = 0;
                res.emplace_back();
            }

            root = q.front();
            q.pop();
            levelCount--;
            res[res.size() - 1].push_back(root->val);

            if(root->left) {
                q.push(root->left);
                nextLevelCount++;
            }
            if(root->right) {
                q.push(root->right);
                nextLevelCount++;
            }
        }

        return res;
    }
};
// @lc code=end

