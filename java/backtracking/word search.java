O(n * m * 4^n) Time - where (n*m) stands for the dimension of the board and (4^n) because of backtracking
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(backtrack(board, word, row, col, rows, cols, 0)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int row, int col, int rows, int cols, int index) {
        if(index >= word.length()) return true;
        if(row < 0 || col < 0 
            || row >= rows || col >= cols 
            || board[row][col] != word.charAt(index)) {
            return false;
        }
        boolean exist = false;
        if(board[row][col] == word.charAt(index)) {
            board[row][col] += 100; //add
            exist = backtrack(board, word, row + 1, col, rows, cols, index + 1) ||
                    backtrack(board, word, row - 1, col, rows, cols, index + 1) ||
                    backtrack(board, word, row, col + 1, rows, cols, index + 1) ||
                    backtrack(board, word, row, col - 1, rows, cols, index + 1);
            board[row][col] -= 100; //remove
        }
        return exist;
    }
}