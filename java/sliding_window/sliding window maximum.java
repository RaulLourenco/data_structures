//O(n) Time & Space - where n is the length of nums array
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        int j = 0;
        for(int i = 0; i < n; i++) {
            //pop smaller values from queue
            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            //remove left value from window
            if(j > queue.peekFirst()) {
                queue.pollFirst();
            }
            if((i + 1) >= k) {
                res[j++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}

//O(n*k) Time & O(1) Space (without considering the res)
//Brute Force - Solution resulting in TLE
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for(int i = 0; i < n - k + 1; i++) {
            int end = i + k - 1;
            int max = nums[i];
            for(int j = i + 1; j <= end; j++) {
                if(nums[j] > max) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }
        return res;
    }
}

//O(n*k) Time & O(1) Space (without considering the res)
//Brute Force that I started to develop (10 min), but I don't want to spend
//a lot of time on this (19 / 51 testcases passed)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int left = 1, right = k - 1;
        int[] res = new int[n - k + 1];
        for(int i = 0; i < n - k + 1; i++) {
            int max = nums[i];
            for(int j = left; j <= right; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
            left++;
            right++;
        }
        return res;
    }
}