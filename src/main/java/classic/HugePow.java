package classic;

public class HugePow {

    public static int hugePow(int x, int n, int[] nums) {
        if (n == 0) {
            nums[0] = 1;
            return 1;
        }
        int resSize = 0;
        int temp = x;

        while (temp > 0) {
            nums[resSize++] = temp % 10;
            temp /= 10;
        }
        for (int i = 2; i <= n; i++) {
            int carry = 0;
            for (int j = 0; j < resSize; j++) {
                nums[j] = nums[j] * x + carry;
                carry = nums[j] / 10;
                nums[j] = nums[j] % 10;
            }
            while (carry > 0) {
                nums[resSize++] = carry % 10;
                carry /= 10;
            }
        }
        for (int i = resSize - 1; i >= 0; i--) {
            System.out.print(nums[i]);
        }
        System.out.println();
        System.out.println(resSize);
        return resSize;
    }

    public static void main(String[] args) {
        int[] nums = new int[10000];
        hugePow(255, 33, nums);
        System.out.println(Math.pow(255, 33));
    }
}
