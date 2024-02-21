O(n^2) Time
O(1) Space

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            int sum = 1;
            for(int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                sum *= nums[j];
            }
            answer[i] = sum;
        }
        return answer;
    }
}

O(n) Time
O(n) Space

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] preffix = new int[n];
        int[] suffix = new int[n];
        preffix[0] = 1;
        suffix[n - 1] = 1;

        for(int i = 1; i < nums.length; i++) {
            preffix[i] = preffix[i - 1] * nums[i - 1];
        }

        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = preffix[i] * suffix[i];
        }

        return answer;
    }
}

O(n) Time
O(1) Space

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        int preffix = 1;
        for(int i = 0; i < nums.length; i++) {
            answer[i] *= preffix;
            preffix *= nums[i];
        }

        int suffix = 1;
        for(int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }       

        return answer;
    }
}

Best solution

O(n) Time -> instead of using Arrays.fill() I made a for loop to fill array with 1s
O(1) Space

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = 1;
        }
        int preffix = 1;
        for(int i = 0; i < nums.length; i++) {
            answer[i] *= preffix;
            preffix *= nums[i];
        }
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }       
        return answer;
    }
}