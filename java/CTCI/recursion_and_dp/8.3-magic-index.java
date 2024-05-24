//O(n) Time & O(1) Space - where n is the length of the array
//Brute Force
int findMagic(int[] array) {
    for(int i = 0; i < array.length; i++) {
        if(array[i] == i) return i;
    }
    return -1;
}

//O(log(n)) Time & Space - where n is the length of the array
//Divide and Conquer - Binary Search for distinct elements
int findMagic(int[] array) {
    return find(array, 0, array.length - 1);
}
int find(int[] array, int start, int end) {
    if(end < start) return -1;

    int mid = (start + end) / 2;
    if(array[mid] == mid) {
        return mid;
    } else if(array[mid] > mid) {
        return find(array, start, mid - 1);
    } else {
        return find(array, mid + 1, end);
    }
}

//O(log(n)) Time & Space - where n is the length of the array
//Divide and Conquer - Binary Search for elements that are not distinct
int findMagic(int[] array) {
    return find(array, 0, array.length - 1);
}
int find(int[] array, int start, int end) {
    if(end < start) return -1;

    int midIndex = (start + end) / 2;
    int midValue = array[midIndex];

    if(midIndex == midValue) return midIndex;

    //Search left
    int leftIndex = Math.min(midIndex - 1, midValue);
    int left = find(array, start, leftIndex);
    if(left >= 0) return left;

    //Search right
    int rightIndex = Math.max(midIndex + 1, midValue);
    int right = find(array, rightIndex, end);
    
    return right;
}
