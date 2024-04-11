//O(E + V) Time & Space - where V represents the number of vertices (chars) and
//E represents the number of edges (relationships between chars)
class Solution {
    Map<Character, Set<Character>> adj;
    Map<Character, Boolean> visited; 
    StringBuilder sb;

    public String foreignDictionary(String[] words) {
      adj = new HashMap<>();

      for(String word : words) {
        for(char c : word.toCharArray()) {
            adj.putIfAbsent(c, new HashSet<>());
        }
      }

      for(int i = 0; i < words.length - 1; i++) {
        String w1 = words[i];
        String w2 = words[i + 1];
        int minLength = Math.min(w1.length(), w2.length());
        if(w1.length() > w2.length() && w1.substring(0, minLength) == w2.substring(0, minLength)) {
            return "";
        }
        for(int j = 0; j < minLength; j++) {
            if(w1.charAt(j) != w2.charAt(j)) {
                adj.get(w1.charAt(j)).add(w2.charAt(j));
                break;
            }
        }
      }

      visited = new HashMap<>();
      sb = new StringBuilder();

      for(Character c : adj.keySet()) {
        if(dfs(c)) return "";
      }

      return sb.toString();
    }
    private boolean dfs(char c) {
        if(visited.containsKey(c)) return visited.get(c);

        visited.put(c, true);

        for(char neighbor : adj.get(c)) {
            if(dfs(neighbor)) return true;
        }

        visited.put(c, false);
        sb.append(c);

        return visited.get(c);
    }
}
