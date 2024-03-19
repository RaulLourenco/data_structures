//O(n*m) Time & Space - where n is the number of rows and m is the number of cols, so
//O(rows * cols) ~ O(cells)

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int row = 0; row < rows; row++) {
            dfs(heights, row, 0, 0, pacific);
            dfs(heights, row, cols - 1, 0, atlantic);
        }

        for(int col = 0; col < cols; col++) {
            dfs(heights, 0, col, 0, pacific);
            dfs(heights, rows - 1, col, 0, atlantic);
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(pacific[row][col] && atlantic[row][col]) {
                    res.add(Arrays.asList(row, col));
                }
            } 
        }
        return res;
    }

    private void dfs(int[][] heights, int row, int col, int prev, boolean[][] ocean) {
        if(row < 0 || row >= heights.length 
        || col < 0 || col >= heights[0].length 
        || heights[row][col] < prev || ocean[row][col]) return;

        ocean[row][col] = true;

        dfs(heights, row + 1, col, heights[row][col], ocean);
        dfs(heights, row - 1, col, heights[row][col], ocean);
        dfs(heights, row, col + 1, heights[row][col], ocean);
        dfs(heights, row, col - 1, heights[row][col], ocean);
    }
}