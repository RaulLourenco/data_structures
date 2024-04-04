//O(n) Time & O(1) Space - where n is the number of nodes in the linked list
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        ListNode kth = new ListNode(0);

        while(kth != null) {
            kth = getKth(groupPrev, k);
            if(kth == null) break;
            ListNode groupNext = kth.next;

            ListNode curr = groupPrev.next, prev = kth.next;

            while(curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }
    private ListNode getKth(ListNode head, int interval) {
        while(interval > 0 && head != null) {
            head = head.next;
            interval--;
        }
        return head;
    }
}