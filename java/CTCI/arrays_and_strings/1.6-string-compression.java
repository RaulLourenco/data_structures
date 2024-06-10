//O(n) Time & Space
String compression(String s) {
    StringBuilder sb = new StringBuilder();
    int count = 0;

    for(int i = 0; i < s.length(); i++) {
        count++;

        if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
            sb.append(s.charAt(i)).append(count);
            count = 0;
        }
    }

    String compressed = sb.toString();
    return compressed.length() < s.length() ? compressed : s;
}