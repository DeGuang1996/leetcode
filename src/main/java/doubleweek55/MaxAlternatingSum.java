package doubleweek55;

public class MaxAlternatingSum {

    public long maxAlternatingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        long res = 0;
        long preMaxOdd = 0;
        long preMaxEven = 0;
        for (int num : nums) {
            res = Math.max(res, preMaxOdd);

            long curOdd = preMaxEven + num;
            long curEven = preMaxOdd - num;

            preMaxOdd = Math.max(preMaxOdd, curOdd);
            preMaxEven = Math.max(preMaxEven, curEven);
        }
        return Math.max(res, preMaxOdd);
    }
}
