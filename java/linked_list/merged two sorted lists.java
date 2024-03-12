O(N + M) - Time
O(1) - Space -> constant space for storing the merged linked list

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 != null) {
            current.next = list1;
        } else if(list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    } 
}

O(N + M) - Time
O(N + M) - Space -> due to recursive calls

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    } 
}

[1, 2, 4]
[1, 3, 4]

1 < 1 -> else -> mergedTwoList([1, 2, 4], [3, 4]) 1
1 < 3 -> if -> mergedTwoList([2, 4], [3, 4]) 1
2 < 3 -> if -> mergedTwoList([4], [3, 4]) 2
4 < 3 -> else -> mergedTwoList([4], [4]) 3
4 < 4 -> else -> mergedTwoList([4], []) 4
return list1 = [4]

 mergeTwoLists(list1, list2.next) = 4
