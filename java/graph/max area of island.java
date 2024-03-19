//O(n*m) Time & Space - where n is the number of rows and m is the number of cols, so
//O(rows * cols) ~ O(cells)

class Solution {
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                maxArea = Math.max(maxArea, dfs(grid, row, col, rows, cols));
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int row, int col, int rows, int cols) {
        if(row < 0 || col < 0 
        || row >= rows || col >= cols 
        || grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        return 1 + (dfs(grid, row + 1, col, rows, cols) +
                    dfs(grid, row - 1, col, rows, cols) +
                    dfs(grid, row, col + 1, rows, cols) +
                    dfs(grid, row, col - 1, rows, cols));
    }
}