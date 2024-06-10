//O(n) Time & Space
ListNode partition(ListNode node, int p) {
    ListNode head = node;
    ListNode tail = node;

    while(node != null) {
        ListNode next = node.next;
        if(node.data < p) {
            node.next = head;
            head = node;
        } else {
            tail.next = node;
            tail = node;
        }
        node = next;
    }
    tail.next = null;

    return head;
}