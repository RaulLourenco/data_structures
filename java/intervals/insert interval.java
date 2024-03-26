//O(n) Time & Space Complexity - where n is the number of intervals
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(newInterval == null || newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else if(newInterval[1] < intervals[i][0]){
                res.add(newInterval);
                res.add(intervals[i]);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        
        if(newInterval != null) res.add(newInterval);

        return res.toArray(new int[res.size()][]);
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else if(newInterval[1] < intervals[i][0]){
                res.add(newInterval);
                newInterval = intervals[i];
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        
        res.add(newInterval);

        return res.toArray(new int[res.size()][]);
    }
}