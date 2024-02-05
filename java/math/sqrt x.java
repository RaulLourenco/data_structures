O(logN) Time
O(1) Space

class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return x;
        }
        int left = 1;
        int right = x;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(mid == x / mid) {
                return mid;
            } else if(mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x;
        int mid = -1;

        while(left <= right) {
            mid = left + (right - left)/2;
            if((long) mid * mid > (long) x) {
                right = mid - 1;
            } else if(mid * mid == x) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return Math.round(right);
    }
}