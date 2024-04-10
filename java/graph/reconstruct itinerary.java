//O(E*log(E)) Time & O(E) Space - where E is the number of edges
//log(E) because of PriorityQueue (insertion, removal)
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> itinerary = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        Stack<String> stack = new Stack<>();

        for(List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            graph.putIfAbsent(src, new PriorityQueue<>());
            graph.get(src).offer(dst);
        }

        
        stack.push("JFK");

        while(!stack.isEmpty()) {
            String nextDst = stack.peek();
            if(graph.containsKey(nextDst) && !graph.get(nextDst).isEmpty()) {
                stack.push(graph.get(nextDst).poll());
            } else {
                itinerary.addFirst(stack.pop());
            }
        }

        return itinerary;
    }
}