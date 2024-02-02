O(N) Time
O(N) Space

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int sum = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            if(sum < 10) {
                digits[i] = sum;
                carry = 0;
                return digits;
            }
            if(i == 0) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            }
            digits[i] = 0;
        }
        return digits;
    }
}

input - [1,2,3]
output - [1,2,4]

input - [9,9,9]
output - [1,0,0,0]