//O(n) Time & Space
Node removeDups(Node head) {
    Node prev = null;
    Set<Integer> set = new HashSet<>();
    Node current = head;

    while(current != null) {
        if(set.contains(current.data)) {
            prev.next = current.next;
        } else {
            set.add(current.data);
            prev = current;
            current = current.next;
        }
    }
    return head;
}

//O(n^2) Time & O(1) Space
Node removeDups(Node head) {
    Node current = head;

    while(current != null) {
        Node runner = current;
        while(runner.next != null) {
            if(runner.next.data == current.data) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }
        }
        current = current.next;
    }
    return head;
}