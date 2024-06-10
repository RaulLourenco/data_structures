//O(n) Time & O(1) Space
ListNode findBeginning(ListNode head) {
    ListNode slow = head, fast = head;

    while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        //collision
        if(slow == fast) break;
    }

    //no loop
    if(fast == null || fast.next == null) return null;

    slow = head; //move slow back to head

    while(slow != fast) { 
        //keep fast at the meeting point.
        //Each are "k" steps from the loop start. 
        //Move at the same pace, that way they most meet at loop start.
        slow = slow.next;
        fast = fast.next;
    }
    return fast;
}