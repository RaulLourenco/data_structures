Brute Force

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder();
        return sb.append(s.trim()).reverse().toString().equals(s);
    }
}

Optimized Solution
O(n) Time
O(1) Space

class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;

        int first = 0;
        int last = s.length() - 1;
        while(first <= last) {
            char currentFirst = s.charAt(first);
            char currentLast = s.charAt(last);
            if(!Character.isLetterOrDigit(currentFirst)) {
                first++;
            } else if(!Character.isLetterOrDigit(currentLast)) {
                last--;
            } else {
                if(Character.toLowerCase(currentFirst) != Character.toLowerCase(currentLast)) {
                    return false;
                }
                first++;
                last--;
            }
        }
        return true;
    }
}