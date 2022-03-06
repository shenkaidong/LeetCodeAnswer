//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
//urn -1. 
// void put(int key, int value) Update the value of the key if the key exists. O
//therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 104 
// 0 <= value <= 105 
// At most 2 * 105 calls will be made to get and put. 
// 
// Related Topics Hash Table Linked List Design Doubly-Linked List 
// 👍 12297 👎 477


//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private Map<Integer, Node> map;
    private List list;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new List();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        int res = node.val;
        list.addNodeToHead(node, true);
        return res;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            list.addNodeToHead(node, true);
            return;
        }
        node = new Node(key, value);
        if (map.size() == capacity) {
            map.remove(list.removeLast().key);
        }
        map.put(key, node);
        list.addNodeToHead(node, false);
    }

    private class Node {
        private int key;
        private int val;
        private Node prev;
        private Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private class List {
        private Node head;
        private Node tail;
        List() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        private void addNodeToHead(Node node, boolean exist) {
            if (exist) {
                remove(node);
            }
            Node first = head.next;
            node.next = first;
            first.prev = node;
            head.next = node;
            node.prev = head;
        }

        private Node remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }

        private Node removeLast() {
            Node last = tail.prev;
            return remove(last);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
