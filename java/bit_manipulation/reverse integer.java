//O(log(n)) Time - O(1) Space - where n is the number of digits in x
class Solution {
    public int reverse(int x) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        int reversed = 0;
        while(x != 0) {
            int rightDigit = x % 10;
            x /= 10;

            if(reversed > MAX/10 || reversed == MAX/10 && rightDigit >= MAX % 10) {
                return 0;
            }
            if(reversed < MIN/10 || reversed == MIN/10 && rightDigit <= MIN % 10) {
                return 0;
            }
            reversed = (reversed * 10) + rightDigit;
        }
        return reversed;
    }
}

class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;

        x = Math.abs(x);

        int reversed = 0;

        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < reversed) return 0;

            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }

        return isNegative ? -reversed : reversed;
    }
}