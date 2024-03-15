class WordDictionary {
    WordDictionary[] children;
    boolean isWord;

    public WordDictionary() {
        children = new WordDictionary[26];
        isWord = false;
    }
    
    public void addWord(String word) {
        WordDictionary curr = this;
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new WordDictionary();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    //O(m) ~ worst case O(m*26^n) where M is the search and N is the number of choices for each char
    public boolean search(String word) {
        WordDictionary wordSearch = this;
        for(int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if(c == '.') {
                for(WordDictionary node : wordSearch.children) {
                   if(node != null && node.search(word.substring(i+1))) return true;
                }
                return false;
            }
            if(wordSearch.children[c - 'a'] == null) return false;
            wordSearch = wordSearch.children[c - 'a'];
        }
        return wordSearch != null && wordSearch.isWord;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }
    
    //O(m^2) Time
    public boolean search(String word) {
        return search(word, root, 0);        
    }

    private boolean search(String word, TrieNode wordSearch, int index) {
        for(int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode node : wordSearch.children) {
                   if(node != null && search(word, node, i+1)) return true;
                }
                return false;
            }
            if(wordSearch.children[c - 'a'] == null) return false;
            wordSearch = wordSearch.children[c - 'a'];
        }
        return wordSearch != null && wordSearch.isEndOfWord;
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */