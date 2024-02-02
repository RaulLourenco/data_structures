Time Complexity = O(log(N))
Space Complexity = O(1)

public boolean binarySearchIterative(int[] array, int x) {
    int left = 0;
    int right = array.length - 1;
    
    while(left <= right) {
        int mid = left + (right - left) / 2;
        if(array[mid] == x) {
            return true;
        } else if(x < array[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
}

public boolean binarySearchRecursive(int[] array, int x, int left, int right) {
    if(left > right) {
        return false;
    }

    int mid = left + (right - left) / 2;
    if(array[mid] == x) {
        return true;
    } else if(x < array[mid]) {
        binarySearchRecursive(array, x, left, mid - 1);
    } else {
        binarySearchRecursive(array, x, mid + 1, right);
    }
}