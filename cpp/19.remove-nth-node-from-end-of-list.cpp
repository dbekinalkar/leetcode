/*
 * @lc app=leetcode id=19 lang=cpp
 *
 * [19] Remove Nth Node From End of List
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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode dummy;
        dummy.next = head;

        ListNode * end = &dummy;
        for(int i = 0; i < n; i++) {
            end = end->next;
        }

        ListNode* prev = &dummy;

        while(end->next) {
            end = end->next;
            prev = prev->next;
        }

        prev->next = prev->next->next;
        return dummy.next;
    }
};
// @lc code=end

