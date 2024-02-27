O(n) Time
O(n) Space

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numbers.length; i++) {
            int probableMatch = target - numbers[i];
            if(map.containsKey(probableMatch)) {
                if(map.get(probableMatch) > i) {
                    return new int[]{i + 1, map.get(probableMatch) + 1};
                } else {
                    return new int[]{map.get(probableMatch) + 1, i + 1};
                }
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}

O(n logN) Time
O(1) Space

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        for(int i =0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            int probableMatch = target - numbers[i];
            while(left <= right) {
                int mid = left + (right - left)/2;
                if(numbers[mid] == probableMatch) {
                    return new int[]{++i, ++mid};
                } else if(numbers[mid] < probableMatch) {
                    left = mid + 1;
                } else if(numbers[mid] > probableMatch) {
                    right = mid - 1;
                }
            }
        }
        return new int[]{};
    }
}

O(n) Time - Best Solution
O(1) Space

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left <= right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{++left, ++right};
            } else if(sum < target) {
                left += 1;
            } else if(sum > target) {
                right -= 1;
            }
        }
        return new int[]{};
    }
}