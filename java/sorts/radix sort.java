//O(nk) Time & O(n + k) Space - where n is the length of the array
//and k is the number of digits
void radixSort(int[] array, int n) {
    //get the max value in array[] to know how many interactions
    //will occurr based on quantity of digits (k)
    int m = getMax(array, n);

    for(int exp = 1; m / exp > 0; exp *= 10) {
        countingSort(arr, n, exp);
    }
}

//utility function to get max value in array[]
int getMax(int[] array, int n) {
    int max = array[0];
    for(int i = 1; i < n; i++) {
        if(array[i] > max) {
            max = array[i];
        }
    }
    return max;
}

//a function to do counting sort of array[] according to the digit 
//represented by exp
void countingSort(int[] array, int n, int exp) {
    int[] count = new int[10];
    int[] output = new int[n];

    Arrays.fill(count, 0);

    //store count occurrences in count[]
    for(int i = 0; i < n; i++) {
        count[(array[i] / exp ) % 10]++;
    }

    //modify the count[] by adding the previous values, so that contains
    //actual position of this digit
    for(int i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }

    //build the output array
    for(int i = n - 1; i >= 0; i--) {
        output[ count[(array[i] / exp) % 10] - 1] = array[i];
        count[(array[i] / exp) % 10]--;
    }

    //copy the output[] to array[]
    for(int i = 0; i < n; i++) {
        array[i] = output[i];
    }
}