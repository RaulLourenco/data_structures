//O(V + E) Time & Space - where V is the number of courses (vertices) and E is the
// number of prerequisites

class Solution {
    Map<Integer, List<Integer>> prereqMap;
    Set<Integer> visited;
    Set<Integer> cycle;
    List<Integer> order;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        prereqMap = new HashMap<>();
        visited = new HashSet<>();
        cycle = new HashSet<>();
        order = new LinkedList<>();

        int[] res = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            prereqMap.put(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            prereqMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) {
                return new int[]{};
            }
        }

        for(int i = order.size() - 1; i >= 0; i--) {
            res[i] = order.get(i);
        }
        return res;
    }
    private boolean dfs(int curr) {
        if(cycle.contains(curr)) {
            return false;
        }
        if(visited.contains(curr)) {
            return true;
        }

        cycle.add(curr);

        for(int i = 0; i <  prereqMap.get(curr).size(); i++) {
            if(!dfs(prereqMap.get(curr).get(i))) {
                return false;
            }
        }
        cycle.remove(curr);
        visited.add(curr);
        order.add(curr);

        return true;
    }
}