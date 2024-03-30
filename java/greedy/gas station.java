//O(n) time & O(1) Space
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        for(int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        //find out if there is a solution
        if(total < 0) return -1;

        int tank = 0;
        int res = 0;
        //find out where to start
        for(int i = 0; i < cost.length; i++) {
            tank += gas[i] - cost[i];
            if(tank < 0) {
                tank = 0;
                res = i + 1;
            }
        }

        return res;
    }
}

//O(n) time & O(1) Space
//Brute Force that I started to develop (10 min), but I don't want to spend
//a lot of time on this (19/40 test cases passed)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int index = 0;
        
        //find out where to start
        for(int i = 0; i < cost.length; i++) {
            if(cost[i] < gas[i]) {
                index = i;
                tank += gas[i];
                break;
            }
        }

        //traverse the right portion
        for(int i = index; i < cost.length - 1; i++) {
            tank = tank - cost[index] + gas[i + 1];
        }
        //traverse the left portion
        int lastIndex = cost.length - 1;
        for(int i = 0; i <= index; i++) {
            tank = tank - cost[lastIndex] + gas[i];
            if(i == 0) {
                lastIndex = 0;
            }
            //if arrive at the index again and tank value is greater
            //than gas[i], return the index 
            if(i == index && tank > gas[i]) {
                return i;
            }
        }
        //return -1 if there isn't a solution
        return -1;
    }
}