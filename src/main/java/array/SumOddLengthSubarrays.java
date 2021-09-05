package array;

public class SumOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int[] preSum = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= arr.length - i; j += i) {
                ans += preSum[j + i] - preSum[j];
            }
        }
        return ans;
    }
}
