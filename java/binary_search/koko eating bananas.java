O(N*log(M)) Time -> N is number of piles and M is range of K (left to right = max(piles))
O(1) Space

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles) {
            right = Math.max(right, pile);
        }

        while(left <= right) {
            int k = left + (right - left)/2;
            if(canEatInTime(piles, k, h)) {
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return left;
    }

    private boolean canEatInTime(int[] piles, int k, int h) {
        int hours = 0;
        for(int pile : piles) {
            hours += Math.ceil(pile / k);
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000; // constraint 10^9

        while(left <= right) {
            int k = left + (right - left)/2;
            if(canEatInTime(piles, k, h)) {
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return left;
    }

    private boolean canEatInTime(int[] piles, int k, int h) {
        int hours = 0;
        for(int pile : piles) {
            hours += Math.ceil(pile / k);
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }
}