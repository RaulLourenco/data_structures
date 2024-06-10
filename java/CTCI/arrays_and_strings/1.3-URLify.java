//O(n) Time & Space
String URLify(String s, int n) {
    String helper = "02%";
    StringBuilder sb = new StringBuilder();

    for(int i = n - 1; i >= 0; i--) {
        char curr = s.charAt(i);
        if(curr != ' ') {
            sb.append(curr);
        } else {
            int k = 0;
            while(k < 3) {
                char p = helper.charAt(k);
                sb.append(p);
                k++;
            }
        }
    }
    return sb.reverse().toString();
}