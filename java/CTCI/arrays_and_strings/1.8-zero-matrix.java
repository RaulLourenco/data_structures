//O(m*n) Time & O(1) Space - where m is the rows length and n is the cols length
void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int colZero = false;

    for(int r = 0; r < rows; r++) {
        if(matrix[r][0] == 0) colZero = true;
        for(int c = 1; c < cols; c++) {
            if(matrix[r][c] == 0) {
                matrix[0][c] = matrix[r][0] = 0;
            }
        }
    }

    for(int r = rows - 1; r >= 0; r--) {
        for(int c = cols - 1; c >= 0; c--) {
            if(matrix[0][c] == 0 || matrix[r][0] == 0) {
                matrix[r][c] = 0;
            }
        }
        if(colZero) matrix[r][0] = 0;
    }
}