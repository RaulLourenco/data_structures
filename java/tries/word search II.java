//O(n*m*4^n) Time & Space - where n * m is the board dimensions and 4^n is
//the backtracking process
class Solution {
    Trie current;
    Set<String> res = new HashSet<>();
    Set<String> visit = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        
        for(String word : words) {
            root.addWord(word);
        }

        int rows = board.length;
        int cols = board[0].length;
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                backtrack(board, "", row, col, root, root);
            }
        }
        return new ArrayList<>(res);
    }
    private void backtrack(char[][] board, String word, int row, int col, Trie root, Trie node) {
        if(row < 0 || row >= board.length 
        || col < 0 || col >= board[0].length 
        || node.children[board[row][col] - 'a'] == null
        || node.children[board[row][col] - 'a'].refs < 1
        || visit.contains(row + "-" + col)) return;

        visit.add(row + "-" + col);
        node = node.children[board[row][col] - 'a'];
        word += board[row][col];

        if(node.isWord) {
            node.isWord = false;
            res.add(word);
            root.removeWord(word);
        }

        backtrack(board, word, row + 1, col, root, node);
        backtrack(board, word, row - 1, col, root, node);
        backtrack(board, word, row, col + 1, root, node);
        backtrack(board, word, row, col - 1, root, node);
        
        visit.remove(row + "-" + col);
    }

    private class Trie {
        boolean isWord;
        Trie[] children = new Trie[26];
        int refs = 0;
        Trie() {}

        void addWord(String word) {
            current = this;
            current.refs += 1;
            for(char c : word.toCharArray()) {
                if(current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new Trie();
                }
                current = current.children[c - 'a'];
                current.refs += 1;
            }
            current.isWord = true;
        }

        void removeWord(String word) {
            current = this;
            current.refs -= 1;
            for(char c : word.toCharArray()) {
                if(current.children[c - 'a'] != null) {
                    current = current.children[c - 'a'];
                    current.refs -= 1;
                }
            }
        }
    }
}

class Solution {
    Trie current;
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        
        for(String word : words) {
            root.addWord(word);
        }

        int rows = board.length;
        int cols = board[0].length;
        Set<String> res = new HashSet<>();
        Set<String> visit = new HashSet<>();
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                backtrack(board, "", row, col, root, root, visit, res);                    
            }
        }
        return new ArrayList<>(res);
    }
    private void backtrack(char[][] board, String word, int row, int col, Trie root, Trie node, Set<String> visit, Set<String> res) {
        if(row < 0 || row >= board.length 
        || col < 0 || col >= board[0].length 
        || !node.children.containsKey(board[row][col])
        || node.children.get(board[row][col]).refs < 1
        || visit.contains(row + "-" + col)) return;

        visit.add(row + "-" + col);
        node = node.children.get(board[row][col]);
        word += board[row][col];

        if(node.isWord) {
            node.isWord = false;
            res.add(word);
            root.removeWord(word);
        }

        backtrack(board, word, row + 1, col, root, node, visit, res);
        backtrack(board, word, row - 1, col, root, node, visit, res);
        backtrack(board, word, row, col + 1, root, node, visit, res);
        backtrack(board, word, row, col - 1, root, node, visit, res);
        
        visit.remove(row + "-" + col);
    }

    private class Trie {
        boolean isWord;
        Map<Character, Trie> children = new HashMap<>();
        int refs = 0;
        Trie() {}

        void addWord(String word) {
            current = this;
            current.refs += 1;
            for(char c : word.toCharArray()) {
                if(!current.children.containsKey(c)) {
                    current.children.put(c, new Trie());
                }
                current = current.children.get(c);
                current.refs += 1;
            }
            current.isWord = true;
        }

        void removeWord(String word) {
            current = this;
            current.refs -= 1;
            for(char c : word.toCharArray()) {
                if(current.children.containsKey(c)) {
                    current = current.children.get(c);
                    current.refs -= 1;
                }
            }
        }
    }
}