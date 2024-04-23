//O(n^2) Time & O(n) Space - where n is the length of the array
//O(n + k) Best and Average Time, and O(n^2) in Worst case
void bucketSort(float[] array) {
    int n = array.length;

    //Create n empty buckets
    List<Float>[] buckets = new ArrayList[n];

    for(int i = 0; i < n; i++) {
        buckets[i] = new ArrayList<>();
    }

    //Put array elements in different buckets
    for(int i = 0; i < n; i++) {
        //for integer array, the bucketIndex is calculated by
        // (int) Math.floor(array[i] / n), when the array[i] is
        //greater than 0
        int bucketIndex = (int) (n * array[i]);
        buckets[bucketIndex].add(array[i]);
    }

    //Sort individual buckets using insertion sort or any other stable sort
    for(int i = 0; i < n; i++) {
        insertionSort(buckets[i]);
    }

    //Concatenate all buckets into array[]
    int index = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < buckets[i].size(); j++) {
            array[index++] = buckets[i].get(j);
        }
    }
}

void insertionSort(List<Float> bucket) {
    for(int i = 1; i < bucket.size(); i++) {
        int current = bucket.get(i);
        int j = i - 1;
        while(j >= 0 && bucket.get(j) > current) {
            bucket.set(j + 1, bucket.get(j));
            j--;
        }
        bucket.set(j + 1, current);
    }
}