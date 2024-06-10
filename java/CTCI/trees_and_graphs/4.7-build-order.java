//O(P + D) Time & Space
Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects(graph.getNodes());
}

Graph buildGraph(String[] projects, String[][] dependencies) {
    Graph graph = new Graph();

    for(String project : projects) {
        graph.createNode(project);
    }

    for(String[] dependency : dependencies) {
        String first = dependency[0];
        String second = dependency[1];
        graph.addEdge(first, second);
    }
    return graph;
}

Stack<Project> orderProjects(ArrayList<Project> projects) {
    Stack<Project> stack = new Stack<>();
    for(Project project : projects) {
        if(project.getState() == Project.State.BLANK) {
            if(!doDFS(project, stack)) {
                return null;
            }
        }
    }
    return stack;
}

boolean doDFS(Project project, Stack<Project> stack) {
    if(project.getState() == Project.State.PARTIAL) {
        return false; //Cycle
    }

    if(project.getState() == Project.State.BLANK) {
        project.setState(Project.State.PARTIAL);
        ArrayList<Project> children = project.getChildren();
        for(Project child : children) {
            if(!doDFS(child, stack)) {
                return false;
            }
        }
        project.setState(Project.State.COMPLETE);
        stack.push(project);
    }
    return true;
}

//Linearly ordering the vertices in a graph -> Topological Sort
public class Graph {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if(!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public ArrayList<Project> getNodes() { return nodes; }
}

public class Project {
    public enum State { COMPLETE, PARTIAL, BLANK };
    private State state = State.BLANK;
    private ArrayList<Project> children = new ArrayList<>();
    private Map<String, Project> map = new HashMap<>();
    private String name;

    public Project(String n) { name = n; }

    public void addNeighbor(Project node) {
        if(!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
        }
    }

    getName()...
    getChildren()...
    getState()...
    setState(...)...
}