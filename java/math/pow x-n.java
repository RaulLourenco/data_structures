//O(logN) Time & O(1) Space
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }

        //make the negative values positive
        if(n < 0) {
            if(n % 2 == 0) {
                n /= 2;
                n = -n;
                x = (1/x) * (1/x);
            } else {
                n = -n;
                x = 1/x;
            }
        }
        if(n % 2 == 0) { //even
            return myPow(x * x, n / 2);
        } else { //odd
            return x * myPow(x * x, n /2);
        }
    }
}

//O(logN) Time & O(1) Space
class Solution {
    public double myPow(double x, int n) {
        double res = 0.0;
        res = helper(x, Math.abs(n), res);
        return n < 0 ? 1/res : res;
    }
    private double helper(double x, int n, double res) {
        if(x == 0) return 0;
        if(n == 0) return 1;

        res = helper(x*x, n / 2, res);
        return n % 2 == 0 ? res : x * res;
    }
}