//O(m*n) Time & O(1) Space - where m is the row length and n is the col length
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin = 0;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int rowEnd = matrix.length - 1;
        List<Integer> res = new ArrayList<>();

        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            for(int j = rowBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            for(int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowEnd >= rowBegin) {
                for(int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if(colEnd >= colBegin) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }
}