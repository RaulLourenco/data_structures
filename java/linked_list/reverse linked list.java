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
O(n) Space - due to recursive calls

class Solution {
    public ListNode reverseList(ListNode head) {
        return recursive(head, null);
    }
    private ListNode recursive(ListNode head, ListNode newHead) {
        if(head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return recursive(next, head);
    }
}

O(n) Time - Iterative
O(1) Space

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }
}