//O(n) Time & O(26) Space
boolean isPermutationOfPalindrome(String s) {
    int[] freq = new int[26];
    int countOdd = 0;
    
    for(char c : s.toCharArray()) {
        int v = c - 'a';
        if(0 <= v && v <= 26) {
            freq[v]++;
            if(freq[v] % 2 == 1) { // odd
                countOdd++;
            } else { // even
                countOdd--;
            }
        }
    }
    return countOdd <= 1;
}