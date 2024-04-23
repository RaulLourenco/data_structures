//O(n + k) Time & O(n + k) Space - where n is the length of the array and
//k is the range of the input (maxValue of the array, which impact the
//count[])
void countingSort(int[] array) {
    int n = array.length;
    int max = 0;
    int[] output = new int[n];

    //find the max value in the array[]
    for(int i = 0; i < n; i++) {
        max = Math.max(max, array[i]);
    }

    //create a count[] to store the occurrences of each number
    int[] count = new int[max + 1];

    for(int i = 0; i < n; i++) {
        count[array[i]]++;
    }
    
    //modify the count[] to store the prefix sum of the elements, so that
    //will help placing the elements of array[] in the correct position 
    //in the output[]
    for(int i = 1; i <= max; i++) {
        count[i] += count[i - 1];
    }

    //update the output[] with the elements in the correct position
    //from end of the input array to preserve the order of equal elements,
    //which eventually makes this sorting algorithm stable
    for(int i = n - 1; i >= 0; i--) {
        output[ count[array[i]] - 1] = array[i];
        count[array[i]]--;
    }
}