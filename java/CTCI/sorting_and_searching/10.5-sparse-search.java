//O(log(n)) Time & Space
//O(n) Worst Case
int search(String[] strings, String str) {
    if(strings == null || str == null || str == "") {
        return -1;
    }
    return search(strings, str, 0, strings.length - 1);
}

int search(String[] strings, String str, int first, int last) {
    if(first > last) return -1;

    int mid = (first + last) /2;
    
    //if mid is empty, find closest non-empty string
    if(strings[mid].isEmpty()) {
        int left = mid - 1;
        int right = mid + 1;
        while(true) {
            if(left < first && right > last) {
                return -1;
            } else if(right <= last && !strings[right].isEmpty()) {
                mid = right;
                break;
            } else if(left >= first && !strings[left].isEmpty()) {
                mid = left;
                break;
            }
            right++;
            left--;
        }
    }

    if(str.equals(strings[mid])) { //found it
        return mid;
    } else if(strings[mid].compareTo(str) < 0) { //search right
        return search(strings, str, mid + 1, last);
    } else { //search left
        return search(strings, str, first, mid - 1);
    }
}