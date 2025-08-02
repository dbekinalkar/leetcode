/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    class Node {
        Node prev;
        Node next;
        int val;

        public Node() {
            this.prev = null;
            this.next = null;
            this.val = 0;
        }
    }

    int capacity;
    int size;
    Node sentinel;

    Map<Integer, Node> nodeMap;
    Map<Integer, Integer> kvMap;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        this.sentinel = new Node();
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;

        this.nodeMap = new HashMap();
        this.kvMap = new HashMap();
    }
    
    public int get(int key) {
        int ret = kvMap.getOrDefault(key, -1);

        if(ret != -1) {
            Node n = nodeMap.get(key);
            remove(n);
            add(n);
        }

        return ret;
    }
    
    public void put(int key, int value) {
        Node n = nodeMap.get(key);
        if(n == null) {
            if(size == capacity) {
                nodeMap.remove(this.sentinel.prev.val);
                kvMap.remove(this.sentinel.prev.val);
                remove(this.sentinel.prev);
            }
            else {
                size++;
            } 

            n = new Node();
            n.val = key;
        }
        else {
            remove(n);
        }

        kvMap.put(key, value);
        nodeMap.put(key, n);
        add(n);
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void add(Node n) {
        n.next = this.sentinel.next;
        this.sentinel.next.prev = n;

        n.prev = this.sentinel;
        this.sentinel.next = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

