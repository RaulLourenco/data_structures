Brute Force
O(n) Time
O(n) Space

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1) ;
            } else {
                map.put(num, 1);
            }
        }
        
        int count = 0;
        int[] result = new int[k];

        while(count < k) {
           Integer key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
           result[count] = key;
           map.remove(key);
           count++;
        }

        return result;
    }

}

O(n) Time
O(n) Space

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

       for(int num : nums) {
           map.put(num, map.getOrDefault(num, 0) + 1);
       }

       List<Integer>[] bucket = new List[nums.length + 1];

       for(int key : map.keySet()) {
           int frequency = map.get(key);
           if(bucket[frequency] == null) {
               bucket[frequency] = new ArrayList<>();
           }  
           bucket[frequency].add(key);
       }

       List<Integer> result = new ArrayList<>();

       for(int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
           if(bucket[i] != null) {
               result.addAll(bucket[i]);
           }
       }

       return result.stream().mapToInt(i->i).toArray();
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

       for(int num : nums) {
           map.put(num, map.getOrDefault(num, 0) + 1);
       }

       List<Integer>[] bucket = new List[nums.length + 1];

       for(int key : map.keySet()) {
           int frequency = map.get(key);
           if(bucket[frequency] == null) {
               bucket[frequency] = new ArrayList<>();
           }  
           bucket[frequency].add(key);
       }

       int[] result = new int[k];
       int index = 0;

       for(int i = bucket.length - 1; i >= 0; i--) {
           if(bucket[i] != null) {
               for(int value : bucket[i]) {
                   result[index++] = value;
                   if(index == k) return result;
               }
           }
       }

       return result;
    }
}