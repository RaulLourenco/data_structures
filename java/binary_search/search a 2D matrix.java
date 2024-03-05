O(log m*n) Time
O(1) Space

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns;

        while(left < right) {
            int mid = (left + right)/2;
            if(matrix[mid/columns][mid%columns] == target) {
                return true;
            } else if(matrix[mid/columns][mid%columns] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;        
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(matrix[mid/columns][mid%columns] == target) {
                return true;
            } else if(matrix[mid/columns][mid%columns] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;  
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int col = matrix[0].length - 1;

        int row = 0;

        while(row < rows && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;        
    }
}

O(m*n) Time
O(1) Space

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;        
    }
}    