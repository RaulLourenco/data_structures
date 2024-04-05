//O(n!) Time & O(n^2) Space - where n is the number of queens
class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];

        for(String[] row : board) {
            Arrays.fill(row, ".");
        }

        backtrack(board, 0, n);

        return res;
    }

    private void backtrack(String[][] board, int row, int n) {
        if(row == n) {
            List<String> ans = new ArrayList<>();
            for(String[] r : board) {
                ans.add(String.join("", r));
            }
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int c = 0; c < n; c++) {
            if(col.contains(c) || posDiag.contains(row+c) || negDiag.contains(row-c)) continue;

            col.add(c);
            posDiag.add(row+c);
            negDiag.add(row-c);
            board[row][c] = "Q";

            backtrack(board, row + 1, n);

            col.remove(c);
            posDiag.remove(row+c);
            negDiag.remove(row-c);
            board[row][c] = ".";
        }
    }
}