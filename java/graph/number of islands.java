//O(n*m) Time - where n is the number of rows and m is the number of cols, so
//O(rows * cols) ~ O(cells)

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == '1') {
                    dfs(grid, row, col, rows, cols, 0);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col, int rows, int cols, int index) {
        if(row < 0 || col < 0 
        || row >= rows || col >= cols 
        || grid[row][col] == '0') return;

        //mark the site as visited
        grid[row][col] = '0';

        //checking all adjacent sites
        dfs(grid, row + 1, col, rows, cols, index + 1); 
        dfs(grid, row - 1, col, rows, cols, index + 1);
        dfs(grid, row, col + 1, rows, cols, index + 1);
        dfs(grid, row, col - 1, rows, cols, index + 1);      
    }
}