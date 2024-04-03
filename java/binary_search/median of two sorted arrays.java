//O(log(min(m,n))) Time & O(1) Space - where m is nums1 length and n is
//num2 length
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        //run Binary Search on the smaller array
        if(n < m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = m + n;
        int half = (total + 1)/2;

        int left = 0, right = m, i = 0, j = 0;
        double res = 0.0;

        while(left <= right) {
            //i == middle
            i = left + (right - left)/2;
            j = half - i;

            //boundary check
            int ALeft = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int ARight = i < m ? nums1[i] : Integer.MAX_VALUE;
            int BLeft = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int BRight = j < n ? nums2[j] : Integer.MAX_VALUE;

            //partition is corret
            //AleftValue is lessOrEqualTo BrightValue
            //BleftValue is lessOrEqualTo ArightValue
            if(ALeft <= BRight && BLeft <= ARight) {
                //even
                if(total % 2 == 0) {
                    res = (Math.max(ALeft, BLeft) + Math.min(ARight, BRight))/2.0;
                } else {
                    //odd
                    res = Math.max(ALeft, BLeft);
                }
                break;
            } 
            //partition is wrong (update pointers to continue Binary Search)
            else if(ALeft > BRight) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        return res;
    }
}


//Brute Force
//O(n + m) Time & O(1) Space - doesn't pass every test case, because it's not
//the correct approach for this problem. (2057 / 2094 testcases passed)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = 0;

        for(int i = 0; i < nums1.length; i++) {
            sum += nums1[i];
        }

        for(int i = 0; i < nums2.length; i++) {
            sum += nums2[i];
        }

        double res = (sum)/(nums1.length + nums2.length);

        return res;
    }
}