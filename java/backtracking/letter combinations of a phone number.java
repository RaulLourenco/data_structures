O(3^n * 4 * m) Time - where n is for digits that maps to 3 letters 
and m is for digits that maps to 4 letters
O(3^n * 4 * m) Space

class Solution {
    Map<Character, String> digitsToChar;
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits == null || digits.isEmpty()) {
            return res;
        }

        digitsToChar = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
        );

        backtrack(res, digits, 0, "");
        return res;
    }
    private void backtrack(List<String> res, String digits, int index, String curr) {
        if(curr.length() == digits.length()) {
            res.add(curr);
            return;
        }
        for(char c : digitsToChar.get(digits.charAt(index)).toCharArray()) {
            backtrack(res, digits, index + 1, curr + c);
        }
    }
}

Iterative solution
O(4^n) Time
O(4^n) Space

class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits.isEmpty()) return res;

        String[] digitsToChar = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        res.add("");
        for(int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while(res.peek().length() == i) {
                String curr = res.remove();
                for(char c : digitsToChar[index].toCharArray()) {
                    res.add(curr + c);
                }
            }
        }
        return res;
    }
}