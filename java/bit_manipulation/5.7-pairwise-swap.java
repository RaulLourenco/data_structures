//O(1) Time & Space - constant bitwise operations
int swapOddEvenBits(int x) {
    return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) );
}
//0xaaaaaaaa - mask of odd bits
//0x55555555 - mask of even bits