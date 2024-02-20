O(n * m log(m)) Time
O(n) Space

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word : strs) {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String sortedWord = String.valueOf(wordArray);
            
            map.putIfAbsent(sortedWord, new ArrayList<>());

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }
}

O(n * m) Time - using char[] to calculate the frequency instead of Arrays.sort()
O(n) Space

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word : strs) {
            char[] frequencyArray = new char[26];

            for(int i = 0; i < word.length(); i++) {
                frequencyArray[word.charAt(i) - 'a']++;
            }
            
            String key = String.valueOf(frequencyArray);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}