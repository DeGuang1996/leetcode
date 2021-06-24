package array;

import java.util.ArrayList;

public class KthLargestValue {

    public int kthLargestValue(int[][] matrix, int k) {
        int[][] preSum = new int[matrix.length + 1][matrix[0].length + 1];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 1; j < preSum[i].length; j++) {
                preSum[i][j] = preSum[i - 1][j] ^ preSum[i][j - 1] ^ preSum[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                result.add(preSum[i][j]);
            }
        }
        result.sort((num1, num2) -> num2 - num1);
        return result.get(k - 1);
    }
}
