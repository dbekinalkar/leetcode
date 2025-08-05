/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummyHead = new Node(0);
        Node curr, next;
        curr = dummyHead;

        HashMap<Node, Node> map = new HashMap();

        while(head != null) {
            next = new Node(head.val);
            curr.next = next;
            next.random = head.random;

            map.put(head, next);

            head = head.next;
            curr = next;
        }

        curr = dummyHead.next;
        while(curr != null) {
            curr.random = map.getOrDefault(curr.random, null);

            curr = curr.next;
        }

        return dummyHead.next;
    }
}
// @lc code=end

