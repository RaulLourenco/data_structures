//(nlog(n)) Time & O(n) Space - where n is the number of intervals
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) {
            return 0;
        }

        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        int index = 0;
        for(Interval interval : intervals) {
            start[index] = interval.start;
            end[index] = interval.end;
            index++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0;
        int e = 0;
        int days = 0;
        int count = 0;

        while(s < n) {
            if(start[s] < end[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            days = Math.max(days, count);
        }
        return days;
    }
}
