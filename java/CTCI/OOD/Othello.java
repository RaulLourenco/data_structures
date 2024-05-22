public enum Direction {
    left, right, up, down;
}

public enum Color {
    White, Black;
}

public class Game {
    private Player[] players;
    private static Game instance;
    private Board board;
    private final int ROWS = 10;
    private final int COLUMNS = 10;

    private Game() {
        board = new Board(ROWS, COLUMNS);
        players = new Player[2];
        players[0] = new Player(Color.Black);
        players[1] = new Player(Color.White);
    }

    public static Game getInstance() {
        if(instance == null) instance = new Game();
        return instance;
    }

    public Board getBoard() {...}
}

public class Board {
    private int blackCount = 0;
    private int whiteCount = 0;
    private Piece[][] board;

    public Board(int rows, int cols) {
        board = new Piece[rows][cols];
    }

    public void initialize() {...}
    public boolean placeColor(int row, int col, Color color) {...}
    public int flipSection(int row, int col, Color color, Direction d) {...}
    public int getScoreForColor(Color c) {
        if(c == Color.Black) return blackCount;
        else return whiteCount;
    }
    public void updateScore(Color newColor, int newPieces) {...}
}

public class Piece {
    private Color color;
    public Piece(Color c) { color = c; }
    
    public void flip() {
        if(color == Color.Black) color = Color.White;
        else color = Color.Black;
    }

    public Color getColor {...}
}

public class Player {
    private Color color;
    public Player(Color c) { color = c; }

    public int getScore {...}
    public boolean playPiece(int row, int col) {
        return Game.getInstance().getBoard().placeColor(row, col, color);
    }
    public Color getColor() {...}
}
