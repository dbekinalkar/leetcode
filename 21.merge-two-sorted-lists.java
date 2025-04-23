/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0, null);
        ListNode curr = head;
        ListNode next = null;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                next = list1;
                list1 = list1.next;
            }
            else {
                next = list2;
                list2 = list2.next;
            }


            curr.next = next;
            curr = curr.next;
        }

        if(list1 != null) {
            curr.next = list1;
        }

        if(list2 != null) {
            curr.next = list2;
        }

        return head.next;
    }
}
// @lc code=end

