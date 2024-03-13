/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

O(n) Time
O(n) Space

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while(curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}

O(n) Time
O(1) Space

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node curr = head;
        while(curr != null) {
            Node copy = new Node(curr.val, curr.next);
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next != null ? curr.next.next : null;
        }

        Node oldHead = head;
        Node newHead = head.next;
        Node currOld = oldHead;
        Node currNew = newHead;

        while(currOld != null) {
            currOld.next = currOld.next.next;
            currNew.next = currNew.next != null ? currNew.next.next : null;
            currOld = currOld.next;
            currNew = currNew.next;
        }

        return newHead;
    }
}