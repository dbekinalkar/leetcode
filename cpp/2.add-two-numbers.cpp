/*
 * @lc app=leetcode id=2 lang=cpp
 *
 * [2] Add Two Numbers
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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry = 0;
        int sum;

        ListNode dummy;

        ListNode* curr, * prev;
        prev = &dummy;

        while(l1 && l2) {
            sum = carry + l1->val + l2->val;

            carry = sum / 10;
            curr = new ListNode(sum % 10);

            prev->next = curr;
            prev = prev->next;

            l1 = l1->next;
            l2 = l2->next;
        }

        while(l1) {
            sum = carry + l1->val;

            carry = sum / 10;
            curr = new ListNode(sum % 10);

            prev->next = curr;
            prev = prev->next;

            l1 = l1->next;
        }

        while(l2) {
            sum = carry + l2->val;

            carry = sum / 10;
            curr = new ListNode(sum % 10);

            prev->next = curr;
            prev = prev->next;

            l2 = l2->next;
        }

        if(carry) {
            prev->next = new ListNode(carry);
        }

        return dummy.next;
    }
};
// @lc code=end

