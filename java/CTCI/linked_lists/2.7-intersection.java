//O(n + m) Time & O(n) Space
ListNode intersect(ListNode a, ListNode b) {
    Set<ListNode> visited = new HashSet<>();

    while(a != null) {
        visited.add(a);
        a = a.next;
    }

    while(b != null) {
        if(visited.contains(b)) {
            return b;
        }
        b = b.next;
    }
    return null;
}