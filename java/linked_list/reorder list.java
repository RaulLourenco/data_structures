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
    public void reorderList(ListNode head) {

        // find middle of list using a slow and fast pointer approach
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the list using a temp variable
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while(second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        //re-assign the pointers to match the pattern
        ListNode first = head;
        second = prev;
        while(second != null) {
            ListNode tempFirst = first.next;
            ListNode tempSecond = second.next;
            first.next = second;
            second.next = tempFirst;
            first = tempFirst;
            second = tempSecond;
        }
    }
}


class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
          return;

        ListNode prev = null, slow = head, fast = head, first = head;
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode second = reverse(slow);
        
        merge(first, second);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, current = head, next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private void merge(ListNode first, ListNode second) {
        while(first != null) {
            ListNode tempFirst = first.next, tempSecond = second.next;
            first.next = second;

            if(tempFirst == null) {
                break;
            }

            second.next = tempFirst;
            first = tempFirst;
            second = tempSecond;
        }
    }
}