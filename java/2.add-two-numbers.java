/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        int carry = 0;
        int sum;

        while(l1 != null || l2 != null || carry != 0) {
            if(tail.next != null) {
                tail = tail.next;
            }

            sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;

            carry = sum / 10;
            
            sum %= 10;

            tail.val = sum;
            tail.next = new ListNode();
        }

        tail.next = null;

        return head;
    }
}
// @lc code=end

