O(n log 26) ~ O(n)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[] freq = new int[26];
        for(char task : tasks) {
            freq[task - 'A']++;
        }
        for(int count : freq) {
            if(count > 0) {
                maxHeap.offer(count);
            }
        }

        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if(!maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                count--;
                if(count > 0) {
                    queue.add(new Pair(count, time + n));
                }
            }
            if(!queue.isEmpty() && queue.peek().getValue() == time) {
                maxHeap.offer(queue.poll().getKey());
            }
        }
        return time;
    }
}