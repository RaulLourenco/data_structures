//O(n) Time & O(26) Space
boolean isPermutation(String a, String b) {
    int[] countA = new int[26];
    int[] countB = new int[26];

    for(int i = 0; i < a.length(); i++) {
        countA[a.charAt(i) - 'a']++;
    }

    for(int j = 0; j < b.length(); j++) {
        countB[b.charAt(j) - 'a']++;
    }

    for(int i = 0; i < a.length(); i++) {
        char currA = a.charAt(i);
        char currB = b.charAt(i);

        if(countA[currA - 'a'] != countB[currB - 'a']) {
            return false;
        }
    }
    return true;
}

//Using only one int array
boolean isPermutation(String a, String b) {
    if(a.length() != b.length()) return false;

    int[] count = new int[26];

    for(int i = 0; i < a.length(); i++) {
        count[a.charAt(i) - 'a']++;
    }

    for(int j = 0; j < b.length(); j++) {
        count[b.charAt(j) - 'a']--;
    }

    for(int i = 0; i < a.length(); i++) {
        if(count[a.charAt(i) - 'a'] > 0) return false;
    }
    return true;
}