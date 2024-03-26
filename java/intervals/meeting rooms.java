//O(n logn) Time - O(1) Space Complexity - where n is the number of intervals
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.end, b.end));

        int prev = 0;

        for(int i = 1; i < n; i++) {
            if(intervals.get(i).start < intervals.get(prev).end) {
                return false;
            }
            prev = i;
        }
        return true;
    }
}

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for(int i = 0; i < n - 1; i++) {
            if(intervals.get(prev).end > intervals.get(i + 1).start) {
                return false;
            }
        }
        return true;
    }
}
