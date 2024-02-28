O(2^(2n)) Time
O(n) Space

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String element, int opened, int closed, int max) {
        if(element.length() == max * 2) {
            res.add(element);
            return;
        }

        if(opened < max) {
            backtrack(res, element + "(", opened + 1, closed, max);
        }
        if(closed < opened) {
            backtrack(res, element + ")", opened, closed + 1, max);
        }
    }
}