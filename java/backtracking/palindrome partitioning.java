O(n^2 * 2^n) Time - for each each partition check if its a palindrome O(n) 
and 2^n is the backtracking (2 choices at each step). The copy of partition list 
when added to result is also considered. Thus increment another O(n) to final 
runtime.
O(n^2 * 2^n) Space

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }
    private void backtrack(List<List<String>> res, List<String> palindrome, String s, int index) {
        if(index >= s.length()) {
            res.add(new ArrayList<>(palindrome));
            return;
        }
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                palindrome.add(s.substring(index, i + 1));
                backtrack(res, palindrome, s, i + 1);
                palindrome.remove(palindrome.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String word, int left, int right) {
        if(word.isEmpty()) return true;

        while(left < right) {
            if(word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}