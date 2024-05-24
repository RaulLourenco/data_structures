//O(n*2^n) Time & Space - where n is the number of elements in the input set
List<List<Integer>> getSubsets(List<Integer> set, int index) {
    List<List<Integer>> allSubsets;
    if(set.size() == index) {
        allSubsets = new ArrayList<ArrayList<Integer>>();
        allSubsets.add(new ArrayList<>());
    } else {
        allSubsets = getSubsets(set, index + 1);
        int item = set.get(index);
        List<List<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
        for(List<Integer> subset : allSubsets) {
            List<Integer> newSubset = new ArrayList<>();
            newSubset.addAll(subset);
            newSubset.add(item);
            moreSubsets.add(newSubset);
        }
        allSubsets.addAll(moreSubsets);
    }
    return allSubsets;
}