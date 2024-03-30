//O(n) Time & O(1) Space
//Kadane's Algo - also Greedy
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reach = 0;
        for(int i = 0; i < n; i++) {
            if(reach < i) return false;
            //calculate the farthest reachable index at each step
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }
}

//O(n) Time & O(1) Space
//Greedy
class Solution {
    public boolean canJump(int[] nums) {
      int goal = nums.length - 1;
      for(int i = nums.length - 2; i >= 0; i--) {
        if(i + nums[i] >= goal) {
            goal = i; //shifting the goal to the left
        }
      }
      return goal == 0;
    }
}

//O(n^2) Time & O(1) Space
//Brute force (160/172 test cases passed)
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return true;
        }

        int index = 0;
        while(index < n) {
            if(index == n - 1) {
                return true;
            }
            if(nums[index] == 0) {
                while(index > 0) {
                    index = index - 1;
                    int jump = nums[index];
                    if(jump >= n) {
                        return true;
                    }
                }
                return false;
            }
            index += nums[index];
        }
        return true;
    }
}