/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != null && fast != null && slow != fast && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow == fast;
    }
}
// @lc code=end

