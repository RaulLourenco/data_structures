//O(n^2) Time & O(1) Space - where n is the length of the array
public int[] bubbleSort(int[] array) {
    int n = array.length;

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n - i - 1; j++) {
            if(array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
    return array;
}

//O(n^2) Time & O(1) Space - where n is the length of the array
//Optimized way to stop if didn't happen any swap
public int[] bubbleSort(int[] array) {
    int n = array.length;
    boolean swapped = false;

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n - i - 1; j++) {
            if(array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped = true;
            }
        }
        if(!swapped) {
            break;
        }
    }
    return array;
}