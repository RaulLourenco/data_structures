//O((n^2)*log(n)) Time & O(n^2) Space - where n is the number 
//of cells in the grid (n rows - n cols -> n*n (grid dimensions))
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

        minHeap.offer(new int[]{ grid[0][0], 0, 0});
        visited[0][0] = true;
        
        int time = 0;

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(row == n - 1 && col == n - 1) return time;

            for(int[] dir : directions) {
                int x = row + dir[0];
                int y = col + dir[1];

                if(x < 0 || x >= n || y < 0 || y >= n || visited[x][y]) continue;

                minHeap.offer(new int[] { Math.max(time, grid[x][y]), x, y });
                visited[x][y] = true;
            }
        }

        return time;
    }
}