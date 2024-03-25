//O(log(max(a,b))) Time - O(1) Space. Since the constraint is -1000 to 1000,
//the time complexity could be considered as constant. O(1) Time & Space.
class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}