//O(n*log(k)) Time & O(1) Space - where n is the total number of nodes and
//k is the number of lists.
//Iterative Merge Sort
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(lists == null || n == 0) {
            return null;
        }
        int interval = 1;
        while(lists.length > interval) {
            ListNode[] temp = new ListNode[n];
            int index = 0;

            for(int i = 0; i < n; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 < n) ? lists[i + 1] : null;
                temp[index++] = mergeLists(l1, l2);
            }
            lists = temp;
            interval *= 2;
        }
        return lists[0];
    }
    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 != null) {
            tail.next = l1;
        }
        if(l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        int interval = 1;

        while(n > interval) {
            for(int i = 0; i < n - interval; i += 2 * interval) {
                lists[i] = mergeLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return n > 0 ? lists[0] : null;
    }
    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 != null) {
            tail.next = l1;
        }
        if(l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
    }
}

//O(n*log(k)) Time & O(k) Space - where n is the total number of nodes and
//k is the number of lists.
//MinHeap
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode node : lists) {
            if(node != null) {
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();
            tail.next = curr;
            tail = tail.next;
            
            if(curr.next != null) {
                minHeap.offer(curr.next);
            }
        }
        return dummy.next;
    }
}