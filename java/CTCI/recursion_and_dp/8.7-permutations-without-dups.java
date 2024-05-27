//O(n*n!) Time & Space

//Building from permutations of firsts n-1 characters
List<String> getPerms(String str) {
    if(str == null) return null;

    List<String> permutations = new ArrayList<>();

    if(str.length() == 0) {
        permutations.add("");
        return permutations;
    }

    char first = str.charAt(0);
    String remainder = str.substring(1);
    List<String> words = getPerms(remainder);
    for(String word : words) {
        for(int j = 0; j <= word.length(); j++) {
            String s = insertCharAt(word, first, j);
            permutations.add(s);
        }
    }
    return permutations;
}

String insertCharAt(String word, char c, int i) {
    String start = word.substring(0, i);
    String end = word.substring(i);
    return start + c + end;
}

//Building from permutations of all n-1 character substrings
List<String> getPerms(String str) {
    List<String> result = new ArrayList<>();
    getPerms("", str, result);
    return result;
}

void getPerms(String prefix, String remainder, List<String> result) {
    if(remainder.length() == 0) result.add(prefix);

    int len = remainder.length();
    for(int i = 0; i < len; i++) {
        String before = remainder.substring(0, i);
        String after = remainder.substring(i + 1, len);
        char c = remainder.charAt(i);
        getPerms(prefix + c, before + after, result);
    }
}