/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for(ListNode list: lists) {
            if(list == null) continue;
            q.add(list);
        }

        ListNode head = new ListNode(0, null);
        ListNode curr = head;
        ListNode next;

        while(!q.isEmpty()) {
            next = q.poll();
            
            curr.next = next;

            curr = curr.next;

            if(next.next != null) q.add(next.next);
        }

        return head.next;
    }
}
// @lc code=end

