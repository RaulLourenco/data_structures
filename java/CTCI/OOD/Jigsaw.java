//Design
public enum Orientation {
    LEFT, TOP, RIGHT, BOTTOM;

    public Orientation getOpposite() {
        switch(this) {
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case TOP: return BOTTOM;
            case BOTTOM: return TOP;
            default: return null;
        }
    }
}

public enum Shape {
    INNER, OUTER, FLAT;

    public Shape getOpposite() {
        switch(this) {
            case INNER: return OUTER;
            case OUTER: return INNER:
            default: return null;
        }
    }
}

public class Puzzle {
    private LinkedList<Piece> pieces;
    private Piece[][] solution;
    private int size;

    public Puzzle(int size, LinkedList<Piece> pieces) {...}

    private void setEdgeInSolution(LinkedList<Piece> pieces, Edge edge, int row, int column, Orientation orientation) {
        Piece piece = edge.getParentPiece();
        piece.setEdgeAsOrientation(edge, orientation);
        pieces.remove(piece);
        solution[row][column] = piece;
    }

    //at the bottom of the archive
    private boolean fixNextEdge(LinkedList<Piece> piecesToSearch, int row, int col) {...}

    //at the bottom of the archive
    public boolean solve() {...}
}

public class Piece {
    private Map<Orientation, Edge> edges = new HashMap<>();
    
    public Piece(Edge[] edgeList) {...}

    public void rotateEdgesBy(int numberRotations) {...}

    public boolean isCorner() {...}
    public boolean isBorder() {...}
}

public class Edge {
    private Shape shape;
    private Piece parentPiece;
    
    public Edge(Shape shape) {...}

    public boolean fitsWith(Edge edge) {....}
}

//Algorithm to solve the puzzle
boolean fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int column)  {
    if(row == 0 && column == 0) {
        Piece p = piecesToSearch.remove();
        orientTopLeftCorner(p);
        solution[0][0] = p;
    } else {
        Piece pieceToMatch = column == 0 ? solution[row - 1][0] : solution[row][column - 1];
        Orientation orientationToMatch = column == 0 ? Orientation.BOTTOM : Orientation.RIGHT;
        Edge edgeToMatch = pieceToMatch.getEdgeWithOrientation(orientationToMatch);
        Edge edge = getMatchingEdge(edgeToMatch, piecesToSearch);

        if(edge == null) { return false; }

        Orientation orientation = orientationToMatch.getOpposite();
        setEdgeInSolution(piecesToSearch, edge, row, column, orientation);
    }
    return true;
}

boolean solve() {
    LinkedList<Piece> cornerPieces = new LinkedList<>();
    LinkedList<Piece> borderPieces = new LinkedList<>();
    LinkedList<Piece> insidePieces = new LinkedList<>();
    groupPieces(cornerPieces, borderPieces, insidePieces);

    solution = new Piece[size][size];
    for(int row = 0; row < size; row++) {
        for(int col = 0; col < size; col++) {
            LinkedList<Piece> piecesToSearch = getPieceListToSearch(cornerPieces, borderPieces, insidePieces, row, col);
            if(!fitNextEdge(piecesToSearch, row, col)) {
                return false;
            }
        }
    }
    return true;
}