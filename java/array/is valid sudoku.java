O(n^2) Time - if the board wasnt fixed (9x9), but in the exercise its fixed so time will be O(1)
O(n) Space - can also be O(1) because its going until 9 for every Set list

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> columns = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            int rowIndex = 3*(i/3);
            int colIndex = 3*(i%3);
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if(board[j][i] != '.' && !columns.add(board[j][i])) return false;
                if(board[rowIndex + j/3][colIndex + j%3] != '.' && 
                !cube.add(board[rowIndex + j/3][colIndex + j%3])) return false;
            }
        }
        return true;
    }
}