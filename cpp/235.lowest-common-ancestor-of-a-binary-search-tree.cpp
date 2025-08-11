/*
 * @lc app=leetcode id=235 lang=cpp
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* lca = nullptr;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        findlca(root, p, q);
        return lca;
    }

    int findlca(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root) return 0;

        int ret = 0;

        if(root == p) ret |= 1;
        else if(root == q) ret |= 2;

        ret |= findlca(root->left, p, q);
        ret |= findlca(root->right, p, q);

        if(ret == 3 & !lca) {
            lca = root;
        }

        return ret;
    }


};
// @lc code=end

