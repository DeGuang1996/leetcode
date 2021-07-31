package week250;

public class AddRungs {

    public int addRungs(int[] rungs, int dist) {
        int ans = 0;
        int begin = 0;
        for (int i = 0; i < rungs.length; i++) {
            if (begin + dist < rungs[i]) {
                ans += (rungs[i] + dist - 1 - begin) / dist - 1;
            }
            begin = rungs[i];
        }
        return ans;
    }
}
