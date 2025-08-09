/*
 * @lc app=leetcode id=110 lang=cpp
 *
 * [110] Balanced Binary Tree
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
    bool isBalanced(TreeNode* root) {
        return balanced(root) >= 0;
    }

    int balanced(TreeNode* root) {
        if(!root) return 0;

        int l = balanced(root->left);
        int r = balanced(root->right);

        if(l < 0 | r < 0 | r - l < -1 | r - l > 1) {
            return -1;
        }

        return std::max(l, r) + 1;
    }
};
// @lc code=end

