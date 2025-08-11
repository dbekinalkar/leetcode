/*
 * @lc app=leetcode id=1448 lang=cpp
 *
 * [1448] Count Good Nodes in Binary Tree
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
    int goodNodes(TreeNode* root) {
        return goodNodes(root, INT_MIN);
    }

    int goodNodes(TreeNode* root, int max) {
        if(!root) return 0;
        int ret = root->val >= max;

        max = std::max(max, root->val);
        ret += goodNodes(root->left, max);
        ret += goodNodes(root->right, max);
        
        return ret;
    }
};
// @lc code=end

