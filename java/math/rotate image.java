//O(n^2) Time & O(1) Space - where n is the matrix length
class Solution {
    public void rotate(int[][] matrix) {
        int left = 0, right = matrix.length - 1;

        while(left < right) {
            for(int i = 0; i < right - left; i++) {
                int top = left, bottom = right;
                //save the topLeft
                int topLeft = matrix[top][left + i];

                //move bottom left into top left
                matrix[top][left + i] = matrix[bottom - i][left];
                //move bottom right into bottom left
                matrix[bottom - i][left] = matrix[bottom][right - i];
                //move top right into bottom right
                matrix[bottom][right - i] = matrix[top + i][right];
                //move top left into top right
                matrix[top + i][right] = topLeft;
            }
            left++;
            right--;
        }
    }
}

//O(n^2) Time & O(1) Space - where n is the matrix length
class Solution {
    public void rotate(int[][] matrix) {
        int left = 0, right = matrix.length - 1;

        //reverse top with bottom
        while(left < right) {
            int[] temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;
            left++;
            right--;
        }

        //swap positions
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}