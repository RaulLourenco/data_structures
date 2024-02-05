O(NlogN + M) Time -> O(NlogN) sorting + O(M) loop to compare characteres of the strings
O(1) Space

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstString = strs[0];
        String lastString = strs[strs.length-1];
        int index = 0;
        while(index < firstString.length() && index < lastString.length()) {
            if(firstString.charAt(index) == lastString.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return firstString.substring(0, index);
    }
}