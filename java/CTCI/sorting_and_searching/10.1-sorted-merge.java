//O(n) Time & O(1) Space - where n is the total number of elements in both arrays
void merge(int[] a, int[] b, int lastA, int lastB) {
    int indexA = lastA - 1;
    int indexB = lastB - 1;
    int indexMerged = lastA + lastB - 1;

    while(indexB >= 0) {
        if(indexA >= 0 && a[indexA] > b[indexB]) {
            a[indexMerged] = a[indexA];
            indexA--;
        } else {
            a[indexMerged] = b[indexB];
            indexB--;
        }
        indexMerged--;
    }
}

//O(n log(n)) Time & O(1) Space
//Brute Force
void merge(int[] a, int[] b) {
    int m = a.length;
    int n = b.length;

    int startBuffer = 0;

    for(int i = 0; i < m; i++) {
        //Assuming that the first buffer element will have null value or zero. 
        //If this info is given, it isn't necessary this to find the real end of A[].
        if(a[i] == 0 || a[i] == null) {
            startBuffer = i;
            break;
        }
    }
    
    //Inserting B[] values in the end of A[]
    int j = 0;
    for(int i = startBuffer; i < m; i++) {
        if(j < n) {
            a[i] = b[j];
            j++;
        }
    }

    //Sorting everything in the end
    Arrays.sort(a);
}