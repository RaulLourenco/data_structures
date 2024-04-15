//O(n log(n)) Time & O(n) Space - where n is the length of the array
class MergeSort {
    public void merge(int arr[], int left, int middle, int right) {
    // Find sizes of two subarrays to be merged
    int leftSize = middle - left + 1;
    int rightSize = right - middle;

    // Create temp arrays
    int leftArray[] = new int[leftSize];
    int rightArray[] = new int[rightSize];

    // Copy data to temp arrays
    for (int i = 0; i < leftSize; ++i)
        leftArray[i] = arr[left + i];
    for (int j = 0; j < rightSize; ++j)
        rightArray[j] = arr[middle + 1 + j];

    // Merge the temp arrays

    // Initial indices of first and second subarrays
    int indexLeftArray = 0, indexRightArray = 0;

    // Initial index of merged subarray array
    int indexMergedArray = left;

    while (indexLeftArray < leftSize && indexRightArray < rightSize) {
        if (leftArray[indexLeftArray] <= rightArray[indexRightArray]) {
            arr[indexMergedArray] = leftArray[indexLeftArray];
            indexLeftArray++;
        } else {
            arr[indexMergedArray] = rightArray[indexRightArray];
            indexRightArray++;
        }
        indexMergedArray++;
    }

    // Copy remaining elements of L[] if any
    while (indexLeftArray < leftSize) {
        arr[indexMergedArray] = leftArray[indexLeftArray];
        indexLeftArray++;
        indexMergedArray++;
    }

    // Copy remaining elements of R[] if any
    while (indexRightArray < rightSize) {
        arr[indexMergedArray] = rightArray[indexRightArray];
        indexRightArray++;
        indexMergedArray++;
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public void sort(int arr[], int left, int right) {
        if (left < right) {

            // Find the middle point
            int middle = left + (right - left) / 2;

            // Sort first and second halves
            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 40, 3, 10, 7, 2, 15, 6 };

        MergeSort ms = new MergeSort();
        ms.sort(arr, 0, arr.length - 1);
    }
}