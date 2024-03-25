////O(32) Time & O(1) Space ~ O(1) Time & Space
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res = res | (bit << (31 - i));
        }
        return res;
    }
}

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
           res <<= 1;
           res = res | (n & 1);
           n >>= 1;
        }
        return res;
    }
}