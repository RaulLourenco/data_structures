CASE
x = 121 - reversed = 0
x = 12 - reversed = 1
x = 1 - reversed = 12
x == reversed -> false
x == reversed/10 -> true

O(N) Time
O(1) Space
class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0) {
            return true;
        }
        if(x < 0 || x % 10 == 0) {
            return false;
        }

        int reversed = 0;

        while(x > reversed) {
            int rightDigit = (x % 10);
            // reversed * 10 = leftDigit
            reversed = (reversed * 10) + rightDigit;
            x /= 10;
        }
        return (x == reversed  || x == reversed / 10);
    }
}

O(N) Time
O(N) Space 
class Solution {
    public boolean isPalindrome(int x) {
        String text = Integer.toString(x);
        String result = "";
        if(text.charAt(0) != text.charAt(text.length()-1)) {
                return false;
        }
        for(int i=text.length()-1;i>=0;i--) {
            result += text.charAt(i);
        }
        return result.equals(text);
    }
}

O(N) Time
O(1) Space 
class Solution {
    public boolean isPalindrome(int x) {
        String text = Integer.toString(x);
        for(int i=0;i<text.length()-1;i++) {
            if(text.charAt(i) != text.charAt(text.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}