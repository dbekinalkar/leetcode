/*
 * @lc app=leetcode id=543 lang=cpp
 *
 * [543] Diameter of Binary Tree
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
    int max = 0;

    int diameterOfBinaryTree(TreeNode* root) {
        diameter(root);

        return max;
    }

    int diameter(TreeNode* root) {
        if(!root) return 0;

        int l = diameter(root->left);
        int r = diameter(root->right);

        max = std::max(max, l + r);
        return std::max(l, r) + 1;
    }
};
// @lc code=end

