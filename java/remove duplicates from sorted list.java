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

O(N) Time
O(1) Space

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while(curr != null) {
            if(curr.next != null) {
                if(curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                    continue;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}