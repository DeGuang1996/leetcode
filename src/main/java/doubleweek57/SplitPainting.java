package doubleweek57;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SplitPainting {

    public List<List<Long>> splitPainting(int[][] segments) {
        int max = 0;
        for (int[] temp : segments) {
            max = Math.max(max, temp[1]);
        }
        ArrayList<TreeSet<Integer>> mixColor = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            mixColor.add(new TreeSet<>());
        }

        long[] subPre = new long[max + 1];

        for (int i = 0; i < segments.length; i++) {
            int begin = segments[i][0];
            int end = segments[i][1];
            int color = segments[i][2];
            subPre[begin] += color;
            subPre[end] -= color;
            mixColor.get(begin).add(color);
            mixColor.get(end).add(color);
        }
        List<List<Long>> ans = new ArrayList<>();
        long[] colorRes = new long[max + 1];
        for (int i = 1; i < subPre.length; i++) {
            colorRes[i] = subPre[i] + colorRes[i - 1];
        }
        long begin = -1;
        long color = 0;
        for (int i = 1; i < colorRes.length; i++) {
            if (colorRes[i] > 0) {
                if (begin == -1) {
                    begin = i;
                    color = colorRes[i];
                } else if (colorRes[i] != color || !cmpList(mixColor.get((int) begin), mixColor.get(i))) {
                    List<Long> temp = new ArrayList<>();
                    temp.add(begin); temp.add((long) i); temp.add(color);
                    ans.add(temp);
                    begin = i; color = colorRes[i];
                }
            } else {
                if (begin != -1) {
                    List<Long> temp = new ArrayList<>();
                    temp.add(begin); temp.add((long) i); temp.add(color);
                    ans.add(temp);
                    begin = -1; color = -1;
                }
            }
        }
        return ans;
    }

    private boolean cmpList(TreeSet<Integer> treeSet1, TreeSet<Integer> treeSet2) {
        if (treeSet1.isEmpty() || treeSet2.isEmpty()) {
            return true;
        }
        if (treeSet1.size() != treeSet2.size()) {
            return false;
        }
        for (Integer a : treeSet1) {
            if (!treeSet2.contains(a)) {
                return false;
            }
        }
        return true;
    }
}
