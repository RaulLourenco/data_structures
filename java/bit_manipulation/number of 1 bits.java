//O(32) Time & O(1) Space ~ O(1) Time & Space
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            //logic and => i = 1; j = 1 (i & j = 1), but if i or j are diff,
            //then response will be 0 (0 & 1 = 0).
            //logic and curr n with n - 1 until everything turn into 0
            n = n & (n-1); 
            count++;
        }
        return count;
    }
}

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) != 0) { //logic and at each step
                count++;
            }
            n = n >> 1; //shifting bit to the right
        }
        return count;
    }
}

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count += n % 2;
            n = n >> 1;
        }
        return count;
    }
}