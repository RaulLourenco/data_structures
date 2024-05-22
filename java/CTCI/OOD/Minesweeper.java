public class Cell {
    private int row;
    private int col;
    private boolean isBomb;
    private int number;
    private boolean isExposed = false;
    private boolean isGuess = false;

    public Cell(int r, int col) {...}

    public boolean flip() {
        isExposed = true;
        return !isBomb;
    }

    public boolean toggleGuess() {
        if(!isExposed) {
            isGuess = !isGuess;
        }
        return isGuess;
    }
}

public class Board {
    private int nRows;
    private int nCols;
    private int nBombs = 0;
    private Cell[][] cells;
    private Cell[] bombs;
    private int numUnexposedRemaining;

    public Board(int r, int c, int b) {...}

    private void initializeBoard() {...}
    private boolean flipCell(Cell cell) {...}
    public void expandBlank(Cell cell) {...}
    public UserPlayResult playFlip(UserPlay play) {...}
    public getNumRemaining() { return numUnexposedRemaining; }
}

public class UserPlay {
    private int row;
    private int col;
    private boolean isGuess;
    ....
}

public class UserPlayResult {
    private boolean successful;
    private Game.GameState resultingState;
    ....
}

public class Game {
    public enum GameState { WON, LOST, RUNNING }

    private Board board;
    private int rows;
    private int cols;
    private int bombs;
    private GameState state;
    
    public Game(int r, int c, int b) {....}

    public boolean initialize() {...}
    public boolean start() {...}
    private boolean playGame() {...}
}

//placing the bombs randomly
void shuffleBoard() {
    int nCells = nRows * nColumns;
    Random random = new Random();
    for(int i = 0; i < nCells; i++) {
        int j = i + random.nextInt(nCells - i);
        if(i != j) {
            int iRow = i / nColumns;
            int iCol = (i - iRow * nColumns) % nColumns;
            Cell iCell = cells[iRow][iCol];

            int jRow = j / nColumns;
            int jCol = (j - jRow * nColumns) % nColumns;
            Cell jCell = cells[jRow][jCol];

            cells[iRow][iCol] = jCell;
            jCell.setRowAndColumn(iRow, iCol);
            cells[jRow][jCol] = iCell;
            iCell.setRowAndColumn(jRow, jCol);
        }
    }
}

//setting the numbered cells
void setNumberedCells() {
    int[][] deltas = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1}, {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };

    for(Cell bomb : bombs) {
        int row = bomb.getRow();
        int col = bomb.getColumn();
        for(int[] delta : deltas) {
            int r = row + delta[0];
            int c = col + delta[1];
            if(inBounds(r, c)) {
                cells[r][c].incrementNumber();
            }
        }
    }
}

//expanding a blank region
void expandBlank(Cell cell) {
    int[][] deltas = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1}, {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };

    Queue<Cell> toExplore = new LinkedList<>();
    toExplore.add(cell);

    while(!toExplore.isEmpty()) {
        Cell current = toExplore.remove();
        for(int[] delta : deltas) {
            int r = current.getRow() + delta[0];
            int c = current.getColumn() + delta[1];

            if(inBounds(r, c)) {
                Cell neighbor = cells[r][c];
                if(flipCell(neighBor) && neighbor.isBlank()) {
                    toExplore.add(neighbor);
                }
            }
        }
    }
}
