//O(log(n)) Time & O(n) Space
class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        large = new PriorityQueue<>((a, b) -> a - b);
        small = new PriorityQueue<>((a,b) -> b - a);
    }
    
    //O(log(n)) Time
    public void addNum(int num) {
        small.offer(num);
        if(small.size() > large.size() + 1 || !large.isEmpty() && small.peek() > large.peek()) {
            int val = small.poll();
            large.offer(val);
        }
        if(large.size() > small.size() + 1) {
            int val = large.poll();
            small.offer(val);
        }
    } 
    
    //O(1) Time
    public double findMedian() {
        if(small.size() > large.size()) {
            return (double) small.peek();
        } else if(large.size() > small.size()) {
            return (double) large.peek();
        }
        return (double) (small.peek() + large.peek()) / 2.0;
    }
}

//Brute Force with Binary Search
class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    //O(log(n)) Time
    public void addNum(int num) {
        int left = 0;
        int right = list.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid) > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        list.add(left, num);
    }
    
    public double findMedian() {
        int mid = list.size() / 2;
        if(list.size() % 2 == 0) {
            return (double) (list.get(mid-1) + list.get(mid)) / 2.0;
        } else {
            return (double) list.get(mid);
        }
    }
}

//Brute Force (18 / 21 testcases passed) - Resulting in TLE
class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }
    
    public double findMedian() {
        int mid = list.size() / 2;
        if(list.size() % 2 == 0) {
            return (double) (list.get(mid-1) + list.get(mid)) / 2.0;
        } else {
            return (double) list.get(mid);
        }
    }
}