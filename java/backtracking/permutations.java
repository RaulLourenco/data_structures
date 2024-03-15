O(n*n!) Time - where n! is for process the permutations and n is the number of nums -> for each num in nums calculate the permutations
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> permutation, int[] nums) {
        if(permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(permutation.contains(nums[i])) continue;
                permutation.add(nums[i]);
                backtrack(res, permutation, nums);
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}