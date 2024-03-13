class LRUCache {

    Map<Integer, Node> cache;
    int cap;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        //left = LRU, right = most recent
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if(cache.size() > cap) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    //insert node at right
    private void insert(Node node) {
        Node prev = right.prev;
        Node next = right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }

    //remove node from list
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private class Node {
        int key;
        int value;

        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */