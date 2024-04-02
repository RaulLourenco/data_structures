//O(n^2 logn) Time & O(n^2) Space - where n is the points length
//Prim's Algo
class Solution {
    public int minCostConnectPoints(int[][] points) {
        //[0,0] - edge weight, next node
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int n = points.length;
        Set<Integer> visited = new HashSet<>();
        int cost = 0;

        minHeap.offer(new int[]{0, 0});

        //when visited.size() == n meaning that all the nodes has been connected
        while(visited.size() < n) {
            int[] curr = minHeap.poll();

            int weight = curr[0];
            int currNode = curr[1];

            if(visited.contains(currNode)) continue;

            visited.add(currNode);
            cost += weight;

            for(int neighbor = 0; neighbor < n; neighbor++) {
                if(!visited.contains(neighbor)) {
                    int neighborWeight = 
                        Math.abs(points[neighbor][0] - points[currNode][0]) + 
                        Math.abs(points[neighbor][1] - points[currNode][1]);
                    minHeap.offer(new int[]{neighborWeight, neighbor});
                }
            }
        }
        return cost;
    }
}