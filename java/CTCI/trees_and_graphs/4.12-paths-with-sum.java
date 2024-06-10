//O(n) Time
//O(log(n)) Space - balanced - //O(n) Space - unbalanced
int countPathsWithSum(TreeNode root, int targetSum) {
    return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
}

int countPathsWithSum(TreeNode node, int targetSum, int runningSum, Map<Integer, Integer> pathCount) {
    if(node == null) return 0; //base case

    runningSum += node.data;
    int sum = runningSum - targetSum;
    int totalPaths = pathCount.getOrDefault(sum, 0);

    if(runningSum == targetSum) {
        totalPaths++;
    }

    incrementMap(pathCount, runningSum, 1); //increment
    totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
    totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
    incrementMap(pathCount, runningSum, -1); //decrement
    return totalPaths;
}

void incrementMap(Map<Integer, Integer> map, int key, int delta) {
    int newCount = map.getOrDefault(key, 0) + delta;
    if(newCount == 0) {
        map.remove(key);
    } else {
        map.put(key, newCount);
    }
}