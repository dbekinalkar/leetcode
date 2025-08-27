/*
 * @lc app=leetcode id=133 lang=cpp
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* cloneGraph(Node* node) {
        if(!node) return nullptr;

        unordered_map<Node*, Node*> to_new;

        Node * next = new Node(node->val);

        to_new[node] = next;

        dfs(to_new, node, next);

        return next;
    }

    void dfs(unordered_map<Node*, Node*>& to_new, Node* curr, Node* next) {
        for(Node* n : curr->neighbors) {
            if(to_new.contains(n)) {
                next->neighbors.push_back(to_new[n]);
                continue;
            }

            Node* n_next = new Node(n->val);
            to_new[n] = n_next;
            next->neighbors.push_back(n_next);

            dfs(to_new, n, n_next);
        }
    }
};
// @lc code=end

