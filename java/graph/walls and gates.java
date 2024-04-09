//O(m*n) Time & O(m+n) Space - where m and n are the dimensions of the grid
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 0) queue.offer(new int[]{row, col});
            }
        }

        if(queue.isEmpty()) return;

        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for(int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if(x < 0 || x >= rows 
                    || y < 0 || y >= cols 
                    || grid[x][y] != Integer.MAX_VALUE) continue;
                
                queue.offer(new int[] {x, y});
                grid[x][y] = grid[row][col] + 1;
            }
        }
    }
}
