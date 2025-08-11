/*
 * @lc app=leetcode id=138 lang=cpp
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        std::unordered_map<Node*, Node*> map;
        
        Node dummy(0);

        Node * curr, * prev;

        prev = &dummy;

        while(head) {
            curr = new Node(head->val);

            map[head] = curr;
            curr->random = head->random;

            prev->next = curr;
            prev = curr;

            head = head->next;
        }

        curr = dummy.next;

        while(curr) {
            curr->random = map[curr->random];

            curr = curr->next;
        }

        return dummy.next;
    }
};
// @lc code=end

