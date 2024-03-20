//DFS Solution
//O(n*m) Time & Space - where n is the number of rows and m is the number of cols, so
//O(rows * cols) ~ O(cells)

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int minutes = 2; //starting with 2 (which means rotten orange)

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 2){
                    dfs(grid, row, col, minutes);
                }
            }
        }

        minutes = 2;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                //if still has fresh orange inside the grid it means that 
                //it's impossible to rotten every orange
                if(grid[row][col] == 1) { 
                    return -1;
                }
                minutes = Math.max(minutes, grid[row][col]);
            }
        }

        return minutes - 2; //removing the offset 2 (rotten)
    }

    private void dfs(int[][] grid, int row, int col, int minutes) {
        if(row < 0 || col < 0 //out of bonds
        || row >= grid.length || col >= grid[0].length //out of bonds
        || grid[row][col] == 0 //empty cell
        || grid[row][col] > 1 && grid[row][col] < minutes) return; //already rotten

        grid[row][col] = minutes;

        dfs(grid, row + 1, col, minutes + 1);
        dfs(grid, row - 1, col, minutes + 1);
        dfs(grid, row, col + 1, minutes + 1);
        dfs(grid, row, col - 1, minutes + 1);
    }
}

//BFS Solution
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 2){
                    queue.offer(new int[]{row, col});
                } else if(grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        while(!queue.isEmpty() && fresh > 0) {
            minutes++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int row = rotten[0];
                int col = rotten[1];
                for(int[] dir : directions) {
                    int adjacentRow = row + dir[0];
                    int adjacentCol = col + dir[1];
                    //if in bounds and non rotten, make rotten and add to queue
                    if(adjacentRow >= 0 && adjacentCol >= 0 
                    && adjacentRow < rows && adjacentCol < cols 
                    && grid[adjacentRow][adjacentCol] == 1) {
                        grid[adjacentRow][adjacentCol] = 2;
                        queue.offer(new int[]{adjacentRow, adjacentCol});
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}