//O(n) Time & Space - where n is the number of edges

class Solution {
    int[] parents;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[edges.length + 1];
        rank = new int[edges.length + 1];

        for(int i = 0; i < edges.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        for(int row = 0; row < edges.length; row++) {
            int n1 = edges[row][0];
            int n2 = edges[row][1];
            if(!union(n1, n2)) {
                return new int[]{n1, n2};
            }
        }
        return new int[]{};
    }
    private int find(int n) {
        int p = parents[n];
        while(p != parents[p]) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        }
        return p;
    }
    private boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 == p2) {
            return false;
        }

        if(rank[p1] > rank[p2]) {
            parents[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parents[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}