O(2^n) Time - where n is the number of elements in nums
O(n) - due to recursive calls

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> aux = new ArrayList<>();
        dfs(res, aux, nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> aux, int[] nums, int index) {
        res.add(new ArrayList<>(aux));
        for(int i = index; i < nums.length; i++) {
            aux.add(nums[i]);
            dfs(res, aux, nums, i + 1);
            aux.remove(aux.size() - 1);
        }
    }
}

O(2^n) Time - where n is the number of elements in nums
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num : nums) {
            int n = res.size();
            for(int i = 0; i < n; i++) {
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(num);
                res.add(subset);
            }
        }
        return res;
    }
}