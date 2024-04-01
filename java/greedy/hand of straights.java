//O(n log n) Time & O(n) Space - where n is the hand length
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);
        for(int card : hand) {
            if(map.get(card) > 0) {
                for(int j = groupSize - 1; j >= 0; j--) {
                    int currCard = card + j;
                    if(map.getOrDefault(currCard, 0) < map.get(card)) return false;
                    map.put(currCard, map.get(currCard) - map.get(card));
                }
            }
        }
        return true;
    }
}

//O(n^2) Time & O(n) Space - where n is the hand length
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int card : hand) {
            minHeap.offer(card);
        }

        while(minHeap.size() != 0) {
            int card = minHeap.poll();
            for(int next = 1; next < groupSize; next++) {
                if(minHeap.remove(card + next)) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

//O(n log n) Time & O(n) Space - where n is the hand length
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while(map.size() != 0) {
            int start = map.firstKey();
            for(int i = start; i < start + groupSize; i++) {
                if(!map.containsKey(i)) return false;
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0) map.remove(i);
            }
        }
        return true;
    }
}