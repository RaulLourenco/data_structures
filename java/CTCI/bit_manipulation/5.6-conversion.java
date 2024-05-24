//O(n) Time & O(1) Space - where n is the number of bits in the integer (32)
int bitSwapRequired(int a, int b) {
    int count = 0;
    //shifting c repeatedly while checking the least significant bit
    for(int c = a ^ b; c != 0; c = c >> 1) {
        count += c & 1;
    }
    return count;
}

int bitSwapRequired(int a, int b) {
    int count = 0;
    //clear the least significant bit and count how long it takes c to reach 0 (c = c & (c - 1))
    for(int c = a ^ b; c != 0; c = c & (c - 1)) {
        count++;
    }
    return count;
}