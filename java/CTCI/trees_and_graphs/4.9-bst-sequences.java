//O(2^n * n) Time & Space
ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
    ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<>>();

    if(node == null) {
        result.add(new LinkedList<Integer>());
        return result;
    }

    LinkedList<Integer> prefix = new LinkedList<Integer>();
    prefix.add(node.data);

    ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
    ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

    for(LinkedList<Integer> left : leftSeq) {
        for(LinkedList<Integer> right : rightSeq) {
            ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<>>();
            weaveLists(left, right, weaved, prefix);
            result.addAll(weaved);
        }
    }
    return result;
}

void weaveLists(LinkedList<Integer> first, 
                LinkedList<Integer> second, 
                ArrayList<LinkedList<Integer>> results, 
                LinkedList<Integer> prefix) {
    if(first.size() == 0 || second.size() == 0) {
        LinkedList<Integer> res = (LinkedList<Integer>) prefix.clone();
        res.addAll(first);
        res.addAll(second);
        results.add(res);
        return;
    }
    int headFirst = first.removeFirst();
    prefix.addLast(headFirst);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    first.addFirst(headFirst);

    int headSecond = second.removeFirst();
    prefix.addLast(headSecond);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    second.addFirst(headSecond);
}