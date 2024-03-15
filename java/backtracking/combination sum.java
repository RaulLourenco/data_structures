O(2^n) Time - where n is the number of candidates
O(n) Space - due to recursive calls

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
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
                combination.add(candidates[i]);
                backtrack(res, combination, candidates, remain - candidates[i], i);
                combination.remove(combination.size() - 1);
            }
        }
    }
}