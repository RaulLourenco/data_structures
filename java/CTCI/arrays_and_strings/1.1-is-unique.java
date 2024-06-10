//O(n^2) Time & O(1) Space
boolean hasUnique(String s) {
    int n = s.length();

    for(int i = 0; i < n; i++) {
        char curr = s.charAt(i);
        for(int j = i + 1; j < n; j++) {
            char possibleMatch = s.charAt(j);
            if(curr == possibleMatch) return false;
        }
    }
    return true;
}

//O(n) Time & Space
boolean hasUnique(String s) {
    Map<Character, Boolean> map = new HashMap<>();

    for(int i = 0; i < s.length; i++) {
        char curr = s.charAt(i);
        if(map.containsKey(curr)) {
            return false;
        }
        map.put(curr, true);
    }
    return true;
}