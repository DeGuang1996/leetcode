package math;

public class EscapeGhosts {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis = Math.abs(target[0]) + Math.abs(target[1]);
        for (int i = 0; i < ghosts.length; i++) {
            int curDis = Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]);
            if (curDis <= dis) {
                return false;
            }
        }
        return true;
    }
}
