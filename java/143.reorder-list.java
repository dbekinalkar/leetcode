/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        ListNode mid = getMidnode(head);

        ListNode rev = reverseList(mid.next);
        mid.next = null;

        merge(head, rev);
    }

    public ListNode getMidnode(ListNode head) {
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }

        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode reversed, next;
        reversed = null;

        while(head != null) {
            next = head.next;
            head.next = reversed;

            reversed = head;
            head = next;
        }

        return reversed;
    }

    public void merge(ListNode n1, ListNode n2) {
        ListNode n1next, n2next;
        while(n1 != null && n2 != null) {
            n1next = n1.next;
            n2next = n2.next;

            n1.next = n2;
            n2.next = n1next;

            n1 = n1next;
            n2 = n2next;
        }
    }
}
// @lc code=end

