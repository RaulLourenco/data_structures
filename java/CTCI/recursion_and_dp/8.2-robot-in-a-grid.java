//O(m*n) Time & Space - where m is the number of rows and n is the number of cols
//O(rows*cols) ~ O(cells)
List<Point> getPath(boolean[][] maze) {
    if(maze == null || maze.length == 0) return null;

    List<Point> path = new ArrayList<>();
    Set<Point> failedPoints = new HashSet<>();
    int m = maze.length - 1;
    int n = maze[0].length - 1;

    if(getPath(maze, m, n, path, failedPoints)) return path;

    return null;
}

List<Point> getPath(boolean[][] maze, int row, int col, List<Point> path, 
                    Set<Point> failedPoints) {
    if(row < 0 || col < 0 || !maze[row][col]) {
        return false;
    }

    Point p = new Point(row, col);
    
    if(failedPoints.contains(p)) {
        return false;
    }

    boolean isAtOrigin = (row == 0) && (col == 0);

    if(isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) 
    || getPath(maze, row - 1, col, path, failedPoints)) {
        path.add(p);
        return true;
    }
    failedPoints.add(p);
    return false;
}

//O(2^row+col) Time & Space - at each step we can make two choices
//Backtracking to find paths that satisfies the problem constraint
List<Point> getPath(boolean[][] maze) {
    if(maze == null || maze.length == 0) return null;

    List<Point> path = new ArrayList<>();
    int m = maze.length - 1;
    int n = maze[0].length - 1;

    if(getPath(maze, m, n, path)) return path;

    return null;
}

List<Point> getPath(boolean[][] maze, int row, int col, List<Point> path) {
    if(row < 0 || col < 0 || !maze[row][col]) {
        return false;
    }

    boolean isAtOrigin = (row == 0) && (col == 0);

    if(isAtOrigin || getPath(maze, row, col - 1, path) 
    || getPath(maze, row - 1, col, path)) {
        Point p = new Point(row, col);
        path.add(p);
        return true;
    }
    return false;
}