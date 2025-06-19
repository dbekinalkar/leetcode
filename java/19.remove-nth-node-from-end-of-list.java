/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headPtr = new ListNode(0, head);
        ListNode prev = headPtr;
        ListNode next = headPtr;

        for(int i = 0; i < n; i++) {
            next = next.next;
        }

        while(next.next != null) {
            prev = prev.next;
            next = next.next;
        }

        prev.next = prev.next.next;
        return headPtr.next;
    }
}
// @lc code=end

