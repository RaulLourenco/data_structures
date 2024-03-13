/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

O(n) Time
O(1) Space

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        while(n > 0) {
            fast = fast.next;
            n--;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
                
        return dummy.next;
    }
}