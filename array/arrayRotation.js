function leftRotate(arr, qtt, n) {
    for (i = 0; i < qtt; i++) {
        leftRotatebyOne(arr, n);
    }

    const leftRotatebyOne = (arr, n) => {
        let temp = arr[0];
        for (j = 0; j < n - 1; j++) {
            arr[j] = arr[j + 1];
        }
        arr[n - 1] = temp;
    }
}