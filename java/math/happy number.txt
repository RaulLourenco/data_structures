//O(log n) Time - O(1) Space - Floyd's Cycle-Finding Algo - where n is the
//input number
class Solution {
    public boolean isHappy(int n) {
        int slow = n; int fast = sumOfSquare(n);

        while(slow != fast) {
            fast = sumOfSquare(sumOfSquare(fast));
            slow = sumOfSquare(slow);
        }

        return fast == 1;
    }
    private int sumOfSquare(int n) {
        int sum = 0;
        while(n != 0) {
            int rightDigit = n%10;
            sum += rightDigit * rightDigit;
            n = n/10;
        }
        return sum;
    }
}

//O(log n) Time - O(log n) Space - where n is the input number
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while(!visited.contains(n)) {
            visited.add(n);

            n = sumOfSquare(n);

            if(n == 1) return true;
        }

        return false;
    }
    private int sumOfSquare(int n) {
        int sum = 0;
        while(n != 0) {
            int rightDigit = n%10;
            sum += rightDigit * rightDigit;
            n = n/10;
        }
        return sum;
    }
}