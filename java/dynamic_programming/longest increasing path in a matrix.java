//O(n*m) Time & Space - where n*m are the dimensions of the matrix
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] max = new int[rows][cols];
        int lip = -1;

        for(int[] col : max) {
            Arrays.fill(col, -1);
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                lip = Math.max(lip, dfs(matrix, row, col, max, -1));
            }
        }
        return lip;
    }
    private int dfs(int[][] matrix, int row, int col, int[][] max, int prev) {
        if(row < 0 || row >= matrix.length 
        || col < 0 || col >= matrix[0].length
        || prev >= matrix[row][col]) return 0;

        if(max[row][col] != -1) {
            return max[row][col];
        }

        int longest = 1;
        longest = Math.max(longest, 1 + dfs(matrix, row + 1, col, max, matrix[row][col]));
        longest = Math.max(longest, 1 + dfs(matrix, row - 1, col, max, matrix[row][col]));
        longest = Math.max(longest, 1 + dfs(matrix, row, col + 1, max, matrix[row][col]));
        longest = Math.max(longest, 1 + dfs(matrix, row, col - 1, max, matrix[row][col]));

        max[row][col] = longest;
        return longest;
    }
}