//O(E+V) Time & Space - where E is the number of edges and V the number of 
//vertices (nodes) - O(n)
class Solution {
    private Map<Integer, List<Integer>> adj;
    public boolean validTree(int n, int[][] edges) {
        if(n == 0) return true;

        if(n == 1 && edges.length == 0) return true;

        adj = new HashMap<>();

        for(int row = 0; row < edges.length; row++) {
            int n1 = edges[row][0];
            int n2 = edges[row][1];

            adj.putIfAbsent(n1, new ArrayList());
            adj.putIfAbsent(n2, new ArrayList());

            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }

        Set<Integer> visited = new HashSet<>();

        return dfs(0, -1, visited) && n == visited.size();
    }

    private boolean dfs(int curr, int prev, Set<Integer> visited) {
        if(visited.contains(curr)) return false;

        visited.add(curr);

        for(int node : adj.get(curr)) {
            if(node == prev) continue;

            if(!dfs(node, curr, visited)) return false;
        }

        return true;
    }
}
