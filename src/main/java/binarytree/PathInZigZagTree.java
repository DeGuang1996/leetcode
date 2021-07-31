package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigZagTree {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        if (label == 1) {
            ans.add(1);
            return ans;
        } else if (label == 2 || label == 3) {
            ans.add(1);
            ans.add(label);
            return ans;
        }

        while (label > 0) {
            ans.add(label);
            label /= 2;
        }
        int depth = ans.size();
        for (int i = 0; i < depth; i++) {
            if (i % 2 == 0) {
                continue;
            }
            int part = (int) (Math.pow(2, depth - i - 1) + Math.pow(2, depth - i) - 1);
            ans.set(i, part - ans.get(i));
        }
        Collections.reverse(ans);
        return ans;
    }
}
