Brute Force - Two Maps
O(n) Time
O(n) Space

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();

        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++) {
            if(mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1);
            } else {
                mapS.put(s.charAt(i), 1);
            }
        }

        Map<Character, Integer> mapT = new HashMap<>();

        for(int j = 0; j < t.length(); j++) {
            if(mapT.containsKey(t.charAt(j))) {
                mapT.put(t.charAt(j), mapT.get(t.charAt(j)) + 1);
            } else {
                mapT.put(t.charAt(j), 1);
            }
        }
        
        for(Map.Entry<Character, Integer> map : mapS.entrySet()) {
            if(mapT.get(map.getKey()) == null || !mapT.get(map.getKey()).equals(map.getValue())) return false;
        }
        return true;
    }
}

More elegant solution using just one map

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char letter : s.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        for(char letter : t.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) - 1);
        }

        for(int value : map.values()) {
            if(value != 0) return false;
        }
        return true;
    }
}

Efficient solution, but has a bigger time complexity due to sorting
O(n logN) Time
O(1) Space

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}

Most efficient solution
O(n) Time
O(1) Space

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];

        for(char letter : s.toCharArray()) {
            map[letter - 'a']++;
        }

        for(char letter : t.toCharArray()) {
            map[letter - 'a']--;
        }

        for(int value : map) {
            if(value != 0) return false;
        }
        return true;
    }
}