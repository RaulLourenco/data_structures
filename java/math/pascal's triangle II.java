O(rowIndex) Time and Space complexity - using the relationship between consecutive binomial coefficients

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        long prev = 1;

        for(int k = 1; k <= rowIndex; k++) {
            long nextVal = prev * (rowIndex - k + 1) / k;
            result.add((int) nextVal);
            prev = nextVal;
        }
        return result;
    }
}