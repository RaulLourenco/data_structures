//O(V + E) Time & Space - where V is the number of courses (vertices) and E is the
// number of prerequisites

class Solution {
    Map<Integer, List<Integer>> prereqMap;
    Set<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        prereqMap = new HashMap<>();
        visited = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            prereqMap.put(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
           prereqMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(isCyclic(i)) {
                return false;
            }
        }
        return true;
    }
    private boolean isCyclic(int curr) {
        if(visited.contains(curr)) {
            return true;
        }

        List<Integer> prerequisites = prereqMap.get(curr);

        if(prerequisites.isEmpty()) return false;

        visited.add(curr); //visiting
        
        for(int i = 0; i < prerequisites.size(); i++) {
            if(isCyclic(prerequisites.get(i))) {
                return true;
            }
        }

        visited.remove(curr); //not visiting anymore
        prereqMap.put(curr, new ArrayList<Integer>());

        return false;
    }
}