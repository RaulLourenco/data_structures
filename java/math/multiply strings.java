//(m*n) Time & O(m + n) Space - where m is num1 string length and 
//n is num2 string length
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] positions = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int curr = i + j, carry = i + j + 1;
                int sum = product + positions[carry];

                positions[curr] += sum / 10;
                positions[carry] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : positions) {
            if(!(sb.length() == 0 && p == 0)) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}