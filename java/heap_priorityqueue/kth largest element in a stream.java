O(n*log(k)) Time

class KthLargest {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int kthElement;

    //O(n*log(k)) where n is the size of nums (how many calls to add method)
    //and log(k) to add the value into the minHeap
    public KthLargest(int k, int[] nums) {
        kthElement = k;
        for(int num : nums) {
            add(num);
        }
    }
    
    //log(k) to add the new value in the minHeap 
    //if > than the kth element (heap.peek())
    public int add(int val) {
        if(heap.size() < kthElement) {
            heap.offer(val);
        } else if(val > heap.peek()) {
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */