//O(n!) Time & O(n^2) Space - where n is the grid size
int GRID_SIZE = 8;

void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
    if(row == GRID_SIZE) { //found valid placement
        results.add(columns.clone());
    } else {
        for(int col = 0; col < GRID_SIZE; col++) {
            if(checkValid(columns, row, col)) {
                columns[row] = col; //place queen
                placeQueens(row + 1, columns, results);
            }
        }
    }
}

boolean checkValid(Integer[] columns, int row1, int column1) {
    for(int row2 = 0; row2 < row1; row2++) {
        int column2 = columns[row2];

        if(column1 == column2) return false;

        int columnDistance = Math.abs(column2 - column1);
        int rowDistance = row1 - row2;
        
        if(columnDistance == rowDistance) return false;
    }
    return true;
}