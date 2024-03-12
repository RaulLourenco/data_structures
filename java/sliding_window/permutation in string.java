O(n) Time
O(26) Space

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];
        int n = s1.length();
        int m = s2.length();

        for(int i = 0; i < n; i++) {
            freqS1[s1.charAt(i) - 'a']++;
        }

        for(int j = 0; j < m; j++) {
            freqS2[s2.charAt(j) - 'a']++;
            if(j >= n) {
                freqS2[s2.charAt(j - n) - 'a']--;
            }
            if(Arrays.equals(freqS1, freqS2)) return true;
        }

        return false;
    }
}