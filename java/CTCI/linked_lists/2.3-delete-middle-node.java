//O(1) Time & Space
boolean removeFromMid(ListNode node) {
    if(node == null || node.next == null) return false;

    ListNode next = node.next;
    node.data = next.data;
    node.next = next.next;
    return true;
}