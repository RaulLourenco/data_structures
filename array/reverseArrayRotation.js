function reverseArray(arr, start, end) {
    while (start < end) {
        let tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        start++;
        end--;
    }
}

function leftRotate(arr, qtt) {
    if (qtt == 0) {
        return;
    }
    var n = arr.length;
    reverseArray(arr, 0, qtt - 1);
    reverseArray(arr, qtt, n - 1);
    reverseArray(arr, 0, n - 1);
}