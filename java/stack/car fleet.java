O(n logN) Time
O(n) Space

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int n = position.length;
        double[][] cars = new double[n][2];

        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        for(int i = n - 1; i >= 0; i--) {
            double currentTime = (target - cars[i][0]) / cars[i][1];
            if(!stack.isEmpty() && currentTime <= stack.peek()) {
                continue;
            } else {
                stack.push(currentTime);
            }
        }
        return stack.size();
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        int res = 0;

        for(int i = 0; i < n; i++) {
            cars[i] = new double[] {position[i], (double) (target - position[i])/speed[i]};
        }

        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        double currentTime = 0;
        for(int i = n - 1; i >= 0; i--) {
             if(cars[i][1] > currentTime) {
                 currentTime = cars[i][1];
                 res++;
             }
        }
        return res;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Map<Integer, Integer> map = new TreeMap<>();
        int res = 0;

        for(int i = 0; i < n; ++i) {
            map.put(target - position[i], speed[i]);
        }

        double currentTime = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int distance = entry.getKey();
            int velocity = entry.getValue();
            double time = 1.0 * distance / velocity;
            if(time > currentTime) {
                currentTime = time;
                res++;
            }
        }
        return res;
    }
}