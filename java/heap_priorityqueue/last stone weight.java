O(n log n) Time
O(n) Space

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(y != x) {
                maxHeap.offer(y - x);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}

//Brute Force

class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        for(int i = stones.length - 1; i > 0; i--) {
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones);
        }
        return stones[0];
    }
}