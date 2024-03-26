//O(n logn) Time - O(n) Space Complexity - where n is the number of intervals
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merge = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        merge.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int lastEnd = merge.get(merge.size() - 1)[1];

            if(currStart <= lastEnd) {
                merge.get(merge.size() - 1)[1] = Math.max(lastEnd, intervals[i][1]);
            } else {
                merge.add(intervals[i]);
            }
        }

        int[][] res = new int[merge.size()][2];
        merge.toArray(res);

        return res;
    }
}