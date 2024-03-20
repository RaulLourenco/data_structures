//O(n*m) Time & Space - where n is the number of rows and m is the number of cols, so
//O(rows * cols) ~ O(cells)

class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int row = 0; row < rows; row++) {
            if(board[row][0] == 'O') dfs(board, row, 0);
            if(board[row][cols - 1] == 'O') dfs(board, row, cols - 1);
        }

        for(int col = 0; col < cols; col++) {
            if(board[0][col] == 'O') dfs(board, 0, col);
            if(board[rows - 1][col] == 'O') dfs(board, rows - 1, col);
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(board[row][col] == 'O') board[row][col] = 'X';
                if(board[row][col] == 'T') board[row][col] = 'O';
            }
        }
    }
    private void dfs(char[][] board, int row, int col) {
        if(row < 0 || col < 0 
        || row >= board.length || col >= board[0].length 
        || board[row][col] != 'O') {
            return;
        }
        
        board[row][col] = 'T';
        
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}