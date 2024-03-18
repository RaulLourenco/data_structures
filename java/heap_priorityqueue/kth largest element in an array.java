//maxHeap - O(n log k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int num : nums) {
            maxHeap.offer(num);
        }

        for(int i = 0; i < k - 1; i++) {
            maxHeap.remove();
        }

        return maxHeap.peek();
    }
}

//minHeap - O(n log n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}