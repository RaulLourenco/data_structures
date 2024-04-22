//O(n^2) Time & O(1) Space - where n is the length of the array
void selectionSort(int[] array) {
    int n = array.length;

    for(int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for(int j = i + 1; j < n; j++) {
            if(array[j] < array[minIdx]) {
                minIdx = j;
            }
        }
        int temp = array[minIdx];
        array[minIdx] = array[i];
        array[i] = temp;
    }
}