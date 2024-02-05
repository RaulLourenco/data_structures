import java.util.Arrays;
import java.util.Collections;

public int[] sortArrayAscending(int[] array) {
    return Arrays.sort(array);
}

public int[] sortArrayDescending(int[] array) {
    return Arrays.sort(array, Collections.reverseOrder());
}

public int[] sortArrayAscendingWithoutLib(int[] array) {
    int temp;
    for(int i=0 ; i < array.length - 1 ; i++) {
        for(int j = i+1 ; j < array.length; j++) {
            if(array[i] > array[j]) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
    return array;
}

public int[] sortArrayDescendingWithoutLib(int[] array) {
    int temp;
    for(int i=0 ; i < array.length - 1 ; i++) {
        for(int j = i+1 ; j < array.length; j++) {
            if(array[i] < array[j]) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
    return array;
}