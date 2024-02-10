Brute Force 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;

        while(current != null) {
            if(visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }
        return false;
    }
}

O(n) Time 
O(1) Space

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode current = head;
        ListNode slowPointer = head;

        while(current != null && current.next != null) {
            current = current.next.next;
            slowPointer = slowPointer.next;
            if(current == slowPointer) {
                return true;
            }
        }
        return false;
    }
}