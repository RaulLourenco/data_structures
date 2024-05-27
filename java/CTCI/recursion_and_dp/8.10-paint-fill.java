//O(n*m) Time & Space - where n is the number of rows and m is the number of cols
enum Color { Black, White, Red, Yellow, Green }

boolean paintFill(Color[][] screen, int row, int col, Color newColor) {
    if(screen[row][col] == newColor) return false;
    return paintFill(screen, row, col, screen[row][col], newColor);
}

boolean paintFill(Color[][] screen, int row, int col, Color oldColor, Color newColor) {
    if(row < 0 || row >= screen.length || col < 0 || col >= screen[0].length) return false;

    if(screen[row][col] == oldColor) {
        screen[row][col] = newColor;
        paintFill(screen, row - 1, col, oldColor, newColor); //up
        paintFill(screen, row + 1, col, oldColor, newColor); //down
        paintFill(screen, row, col - 1, oldColor, newColor); //left
        paintFill(screen, row, col + 1, oldColor, newColor); //right
    }
    return true;
}