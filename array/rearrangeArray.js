function rearrange(arr) {
    arr.forEach( (_current, index, _arr) => {
        if(_arr[index] >= 0 && _arr[index] != index){
            let x = _arr[_arr[index]];
            _arr[_arr[index]] = _arr[index];
            _arr[index] = x;
        }
    });
    return arr;
}