//O(n!) Time & Space - where n is the length of the input String s
List<String> printPerms(String s) {
    List<String> result = new ArrayList<>();
    Map<Character, Integer> map = buildFreq(s);
    printPerms(map, "", s.length(), result);
    return result;
}

//O(n)
Map<Character, Integer> buildFreq(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for(char c : s.toCharArray()) {
        if(!map.containsKey(c)) {
            map.put(c, 0);
        }
        map.put(c, map.get(c) + 1);
    }
    return map;
}

//O(n!)
void printTerms(Map<Character, Integer> map, String prefix, int remaining, List<String> result) {
    if(remaining == 0) {
        result.add(prefix);
        return;
    }

    for(Character c : map.keySet()) {
        int count = map.get(c);
        if(count > 0) {
            map.put(c, count - 1);
            printTerms(map, prefix + c, remaining - 1, result);
            map.put(c, count);
        }
    }
}

