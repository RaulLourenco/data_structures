//O(n) Time & Space - where n is the string length
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        
        int size = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));
            if(i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}

//O(n) Time & Space - where n is the string length
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        int index = 0;
        for(char c : s.toCharArray()) {
            lastIndex.put(c, index);
            index++;
        }
        
        int size = 0, end = 0;
        index = 0;
        for(char c : s.toCharArray()) {
            size++;
            end = Math.max(end, lastIndex.get(c));
            if(index == end) {
                res.add(size);
                size = 0;
            }
            index++;
        }
        return res;
    }
}