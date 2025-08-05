/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        ArrayDeque<Node> q = new ArrayDeque();


        Node n, next;

        HashMap<Node, Node> map = new HashMap();
        map.put(node, new Node(node.val));

        q.add(node);
        while(!q.isEmpty()) {
            n = q.poll();
            next = map.get(n);

            for(Node neighbor : n.neighbors) {
               if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }
                next.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}
// @lc code=end

