package everyday;

public class BalancedStringSplit {

    public int balancedStringSplit(String s) {
        int ans = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (leftCount == rightCount) {
                ans++;
                leftCount = 0;
                rightCount = 0;
            }
        }
        return ans;
    }
}
