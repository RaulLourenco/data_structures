Brute force

class Trie {
    private List<String> trie;

    public Trie() {
        trie = new ArrayList<>();
    }
    
    //O(1) Time
    public void insert(String word) {
        trie.add(word);
    }
    
    //O(n) Time
    public boolean search(String word) {
        return trie.contains(word);
    }
    
    //O(n^2) Time - for each word in the trie process the substring and compare to the prefix
    //O(n) - loop through list
    //O(n) - substring of each word
    public boolean startsWith(String prefix) {
        for(String word : trie) {
            int prefixLength = prefix.length();
            if(word.length() >= prefix.length() && word.substring(0, prefixLength).equals(prefix)) return true;
        }
        return false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    //O(n) where n is the word size - 1 <= word.length <= 2000
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    //O(n) where n is the word size - 1 <= word.length <= 2000
    public boolean search(String word) {
        TrieNode wordSearch = root;
        for(char c : word.toCharArray()) {
            if(wordSearch.children[c - 'a'] == null) return false;
            wordSearch = wordSearch.children[c - 'a'];
        }
        return wordSearch.isWord;
    }
    
    //O(26) ~ O(1) - 1 <= prefix.length <= 2000
    public boolean startsWith(String prefix) {
        TrieNode prefixSearch = root;
        for(char c : prefix.toCharArray()) {
            if(prefixSearch.children[c - 'a'] == null) return false;
            prefixSearch = prefixSearch.children[c - 'a'];
        }
        return true;
    }

    private class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode() {}
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */