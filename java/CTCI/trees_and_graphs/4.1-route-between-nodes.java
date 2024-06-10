//O(E + V) Time & Space - where E is the number of edges and V is the number of vertices
boolean routeBetweenTwo(Graph g, Node a, Node b) {
    if(a == b) return true;

    Queue<Node> q = new LinkedList<>();
    Set<Node> visited = new HashSet<>();

    visited.add(a);
    queue.offer(a);

    while(!queue.isEmpty()) {
        Node u = queue.poll();
        if(u != null) {
            for(Node v : u.getAdjacent()) {
                if(visited.contains(v)) {
                    if(v == b) {
                        return true;
                    } else {
                        visited.add(v);
                        queue.offer(v);
                    }
                }
            }
            visited.add(u);
        }
    }
    return false;
}