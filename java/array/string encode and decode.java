//O(n) Time & O(1) Space (not considering SB and the result List) - where n
//is the total length of all the words.
class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String word : strs) {
            sb.append(word.length()).append("#").append(word);
            System.out.println("testando " + sb.toString());
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') j++;

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }
}
