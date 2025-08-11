/*
 * @lc app=leetcode id=98 lang=cpp
 *
 * [98] Validate Binary Search Tree
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
    bool isValidBST(TreeNode* root) {
        return isvalid(root, LONG_MIN, LONG_MAX);
    }

    bool isvalid(TreeNode* root, long long leftbound, long long rightbound) {
        if(!root) return true;

        return root->val > leftbound 
            && root->val < rightbound 
            && isvalid(root->left, leftbound, root->val) 
            && isvalid(root->right, root->val, rightbound);
    }
};
// @lc code=end

