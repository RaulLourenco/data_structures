//O(log(n)) Time & O(1) Space
int search(Listy list, int value) {
    int index = 1;
    while(list.elementAt(index) != -1 && list.elementAt(index) < value) {
        index *= 2;
    }
    return binarySearch(list, value, index/2, index);
}
int binarySearch(Listy list, int value, int low, int high) {
    int mid;

    while(low <= high) {
        mid = (low + high) / 2;
        int middle = list.elementAt(mid);
        if(middle > value || middle == -1) {
            high = mid - 1;
        } else if(middle < value) {
            low = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}