//minHeap O(n log n)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(
            a[0] * a[0] + a[1] * a[1], 
            b[0] * b[0] + b[1] * b[1]));

        for(int[] point : points) {
            heap.offer(point);
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] curr = heap.poll();
            result[i][0] = curr[0];
            result[i][1] = curr[1];
        }
        return result;
    }
}

//maxHeap O(n logK) - remove top elements from the heap 
//to maintain its size as k
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(
            b[0] * b[0] + b[1] * b[1],
            a[0] * a[0] + a[1] * a[1]));

        for(int[] point : points) {
            heap.offer(point);
            if(heap.size() > k) {
                heap.remove();
            }
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] curr = heap.poll();
            result[i][0] = curr[0];
            result[i][1] = curr[1];
        }
        return result;
    }
}

//O(n log n) sorting by comparing the result of the distance 
//between two points formula
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
}