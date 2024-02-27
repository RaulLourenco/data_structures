O(n^2) Time
O(1) Space

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums.length < 3) return new ArrayList<>(result);

        Arrays.sort(nums);

        for(int left = 0; left < nums.length - 2; left++) {
            if(nums[left] > 0) break; 
            if(left > 0 && nums[left] == nums[left-1]) continue; //Avoiding duplicates
            int mid = left + 1;
            int right = nums.length - 1;
            while(mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if(sum > 0) {
                    right--;
                } else if(sum < 0) {
                    mid++;
                } else {
                    result.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    while(mid < right && nums[mid] == nums[mid+1]) { //Avoiding duplicates
                        mid++;
                    }
                    while(mid < right && nums[right] == nums[right-1]) { //Avoiding duplicates
                        right--;
                    }
                    mid++;
                    right--;
                } 
            }
        }
        return result;
    }
}