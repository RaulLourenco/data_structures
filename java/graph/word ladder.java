//O(n*(m^2)) Time & O(n*m) Space - where n is the size of wordList and m
//is the length of each word
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adj = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int res = 1;
        
        wordList.add(beginWord);
        queue.offer(beginWord);
        visited.add(beginWord);

        for(String word : wordList) {
            StringBuilder sb = null;
            for(int i = 0; i < word.length(); i++) {
                sb = new StringBuilder(word);
                sb.setCharAt(i, '*');
                String pattern = sb.toString();

                adj.putIfAbsent(pattern, new ArrayList<>());
                adj.get(pattern).add(word);
            }
        }

        StringBuilder sb = null;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) return res;

                for(int j = 0; j < word.length(); j++) {
                    sb = new StringBuilder(word);
                    sb.setCharAt(j, '*');

                    for(String neighbor : adj.get(sb.toString())) {
                        if(!visited.contains(neighbor)) {                       
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
            res++;
        }

        return 0;
    }
}