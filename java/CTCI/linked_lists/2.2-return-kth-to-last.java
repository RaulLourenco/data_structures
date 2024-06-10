ListNode kthToLast(ListNode head, int k) {
    ListNode slow = head;
    ListNode fast = head;

    while(k > 0) { //advance fast by k steps
        fast = fast.next;
        k--;
    }

    while(fast != null) { //when fast arrive at the end, slow will be at end - k steps
        fast = fast.next;
        slow = slow.next;
    }

    return slow;
}