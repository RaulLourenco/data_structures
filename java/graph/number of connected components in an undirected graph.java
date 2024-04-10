//O(E + V) ~ O(n * alpha(n)) - Time & O(n) Space - where n is the number 
//of nodes in the graph
class Solution {
    int[] parents;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        parents = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = i;
        }

        int res = n;

        for(int row = 0; row < edges.length; row++) {
            int n1 = edges[row][0];
            int n2 = edges[row][1];
            res -= union(n1, n2);
        }

        return res;
    }
    private int find(int num) {
        int par = parents[num];
        while(par != parents[par]) {
            parents[par] = parents[parents[par]];
            par = parents[par];
        }
        return par;
    }
    private int union(int num1, int num2) {
        int par1 = find(num1);
        int par2 = find(num2);

        if(par1 == par2) {
            return 0;
        }

        if(rank[par1] > rank[par2]) {
            parents[par2] = par1;
            rank[par1] += rank[par2];
        } else {
            parents[par1] = par2;
            rank[par2] += rank[par1];
        }
        return 1;
    }
}
