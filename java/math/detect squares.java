//O(n) Time & Space - where n is the total number of points after calling add.
class DetectSquares {
    int[][] countPoints;
    List<int[]> points;

    public DetectSquares() {
        countPoints = new int[1001][1001];
        points = new ArrayList<>();
    }
    
    //O(1) Time
    public void add(int[] point) {
        countPoints[point[0]][point[1]]++;
        points.add(point);
    }
    
    //O(n) Time 
    public int count(int[] point) {
        int px = point[0], py = point[1], res = 0;
        for(int[] p : points) {
            int x = p[0], y = p[1];
            if(Math.abs(px-x) != Math.abs(py-y) || x == px || y == py) continue;
            res += countPoints[px][y] * countPoints[x][py];
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */