//O(n log(n)) Time & O(n) Space - where n is the length of the array
class QuickSort {
    public void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            //partitioning index
            int pi = partition(arr, low, high);

            //sort elements before partition
            quickSort(arr, low, pi - 1);
            //sort elements after partition
            quickSort(arr, pi + 1, high);
        }
    }
    public int partition(int[] arr, int low, int high) {
        //choosing the pivot (last element)
        int pivot = arr[high];

        //index of smaller element (ISE) and indicates
        //the right position of pivot found so far
        int i = low - 1;

        for(int j = low; j <= high - 1; j++) {
            //if current element is smaller than the pivot
            if(arr[j] < pivot) {
                //increment ISE
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    //helper function to swap two elements
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]) {
        int arr[] = { 40, 3, 10, 7, 2, 15, 6 };

        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, arr.length - 1);
    }
}