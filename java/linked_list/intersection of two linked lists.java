//O(n + m) Time & O(n) Space - where n is headA length and m is headB length. Basically, the Set is
//populated with headA values and only with one node that also exist in headB - if the intersection exists.
//Brute Force solution using HashSet to store all values in HeadA
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        while(headA != null) {
            visited.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(visited.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}

//O(n + m) Time & O(1) Space
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aPointer = headA;
        ListNode bPointer = headB;
        while(aPointer != bPointer) {
            if(aPointer == null) {
                aPointer = headB;
            } else {
                aPointer = aPointer.next;
            }

            if(bPointer == null) {
                bPointer = headA;
            } else {
                bPointer = bPointer.next;
            }
        }
        return aPointer;
    }
}

//O(n + m) Time & O(1) Space - short version using ternary
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aPointer = headA;
        ListNode bPointer = headB;
        while(aPointer != bPointer) {
            aPointer = (aPointer == null) ? headB : aPointer.next;
            bPointer = (bPointer == null) ? headA : bPointer.next;
        }
        return aPointer;
    }
}