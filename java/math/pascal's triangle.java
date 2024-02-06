O(N^2) Time and Space complexity - using combinatorial formula C(n-1, k-1) + C(n-1, k)

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(0, List.of(1));
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> current_row = new ArrayList<>();
            current_row.add(1);
            for(int j = 1; j < i; j++) {
                int sum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                current_row.add(j, sum);
            }
            current_row.add(1);
            result.add(i, current_row);
        }
        return result;
    }
}