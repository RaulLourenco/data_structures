//O(n + m) Time & O(1) Space
ListNode sum(ListNode l1, ListNode l2) {
    int exp = 1, total = 0;

    while(l1 != null || l2 != null) {
        int n1 = l1.data != null ? l1.data : 0;
        int n2 = l2.data != null ? l2.data : 0;

        int sum = (n1 + n2) * exp;
        total += sum;
        exp *= 10;

        l1 = l1.next;
        l2 = l2.next;
    }

    ListNode res = new ListNode(0);

    while(total > 0) {
        int rightDigit = total % 10;
        ListNode node = new ListNode(rightDigit);
        res.next = node;
        res = res.next;
        total /= 10;
    }

    return res.next;
}