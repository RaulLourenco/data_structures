O(n*2^n) Time - where 2^n is the backtracking process and n is the copy of array
O(n) Space

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> combination, int[] candidates, int remain, int index) {
        if(remain < 0) {
            return;
        } else if(remain == 0) {
            res.add(new ArrayList<>(combination));
        } else {
            for(int i = index; i < candidates.length; i++) {
                if(i > index && candidates[i] == candidates[i - 1]) continue;
                combination.add(candidates[i]);
                backtrack(res, combination, candidates, remain - candidates[i], i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }
}