/*
 * @lc app=leetcode id=143 lang=cpp
 *
 * [143] Reorder List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        if(!head) return;
        ListNode * mid = middle(head);

        ListNode * rev = reverse(mid->next);
        mid->next = nullptr;

        merge(head, rev);
    }

    ListNode* middle(ListNode * head) {
        ListNode* fast = head->next;

        while(fast && fast->next) {
            head = head->next;
            fast = fast->next->next;
        }

        return head;
    }

    ListNode* reverse(ListNode * head) {
        ListNode dummy;

        ListNode* curr, * next;

        curr = head;

        while(curr) {
            next = curr->next;

            curr->next = dummy.next;
            dummy.next = curr;

            curr = next;
        }

        return dummy.next;
    }

    void merge(ListNode* n1, ListNode* n2) {
        ListNode* n1next, * n2next;
        while(n1 != nullptr & n2 != nullptr) {
            n1next = n1->next;
            n2next = n2->next;

            n1->next = n2;
            n2->next = n1next;

            n1 = n1next;
            n2 = n2next;
        }
    }
};
// @lc code=end

