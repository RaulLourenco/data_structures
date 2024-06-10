//O(n) Time & O(1) Space
boolean isPalindrome(ListNode node) {
    int len = length(node); //traverse the linked list to get the length
    int exp = len;
    int num = 0;

    while(node != null) {
        int value = node.data * exp;
        num += value;
        node = node.next;
        exp /= 10;
    }

    return checkPalindrome(num);
}

boolean checkPalindrome(int v) {
    if(v == 0) return true;

    if(v < 0 || v % 10 == 0) return false;

    int reversed = 0;

    while(v > reversed) {
        int rightDigit = v % 10;
        reversed = (reversed * 10) + rightDigit;
        v /= 10;
    }
    return (v == reversed || v == reversed/10);
}