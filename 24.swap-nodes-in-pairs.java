/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = head.next;

        ListNode prev, curr, next;

        prev = null;
        curr = head;

        while(curr != null && curr.next != null) {
            next = curr.next;

            curr.next = next.next;
            next.next = curr;
            if(prev != null) prev.next = next;

            prev = curr;
            curr = curr.next;
        }


        return newHead;
    }
}
// @lc code=end

