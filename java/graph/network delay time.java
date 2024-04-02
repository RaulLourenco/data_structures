//O(Edges * log(Vertices)) - O(E*logV) Time & Space
//Dijkstra's Algo
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int delay = 0;
        Set<Integer> visited = new HashSet<>();

        for(int[] time : times) {
            edges.putIfAbsent(time[0], new ArrayList<>());
            edges.get(time[0]).add(new int[]{time[1], time[2]});
        }

        minHeap.offer(new int[] {0, k});

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            int dist = curr[0];
            int currNode = curr[1];

            if(visited.contains(currNode)) continue;

            visited.add(currNode);
            delay = dist;

            if(!edges.containsKey(currNode)) continue;

            for(int[] next : edges.get(currNode)) {
                if(!visited.contains(next[0])) {
                    int nextDist = next[1];
                    minHeap.offer(new int[] {dist + nextDist, next[0]});
                }
            }   
        }
        return visited.size() == n ? delay : -1;
    }
}