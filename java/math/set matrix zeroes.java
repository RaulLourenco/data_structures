//O(m*n) Time & O(1) Space - where m is the rows length and n is 
//the cols length. Meaning, O(length of matrix) - O(cells).
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean rowZero = false;

        //determine which rows/cols need to be zero
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    if(r > 0) {
                        matrix[r][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }

        for(int r = 1; r < rows; r++) {
            for(int c = 1; c < cols; c++) {
                if(matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }

        if(rowZero) {
            for(int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }
    }
}

//Short version
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean colZero = false;

        for(int r = 0; r < rows; r++) {
            if(matrix[r][0] == 0) colZero = true;
            for(int c = 1; c < cols; c++) {
                if(matrix[r][c] == 0) {
                    matrix[0][c] = matrix[r][0] = 0;
                }
            }
        }

        for(int r = rows - 1; r >= 0; r--) {
            for(int c = cols - 1; c >= 1; c--) {
                if(matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
            if(colZero) matrix[r][0] = 0;
        }
    }
}