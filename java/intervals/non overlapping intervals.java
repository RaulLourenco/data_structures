//O(n logn) Time - O(n) Space Complexity - where n is the number of intervals
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] newInterval = intervals[0];
        int count = 0;

        for(int i = 1; i < intervals.length; i++) {
            if(newInterval[1] > intervals[i][0]) {
                count++;
                if(newInterval[1] > intervals[i][1]) {
                    newInterval = intervals[i];
                }
            } else {
                newInterval = intervals[i];
            }
        }

        return count;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int prev = 0;
        int count = 1;

        for(int i = 1; i < n; i++) {
            if(intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }

        return n - count;
    }
}