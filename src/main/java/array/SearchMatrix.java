package array;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[i].length - 1;
        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
