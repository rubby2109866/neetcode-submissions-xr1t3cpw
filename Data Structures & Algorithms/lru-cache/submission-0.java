class Node {
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node after = node.next;
        prev.next = after;
        after.prev = prev;
    }

    public void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        this.right.prev = node;
        node.prev = prev;
        node.next = this.right;
    }
    
    public int get(int key) {
        if (this.cache.containsKey(key)) {
            this.remove(this.cache.get(key));
            this.insert(this.cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            this.remove(this.cache.get(key));
        }
        this.cache.put(key, new Node(key,value));
        this.insert(this.cache.get(key));
        if (cache.size() > this.cap) {
            Node lru = left.next;
            this.remove(lru);
            cache.remove(lru.key);
        }
    }
}
