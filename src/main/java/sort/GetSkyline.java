package sort;

import binarytree.TreeNode;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class GetSkyline {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((term1, term2) -> term2[1] - term1[1]);
        ArrayList<Integer> boundaries = new ArrayList<>();
        for (int[] build : buildings) {
            boundaries.add(build[0]);
            boundaries.add(build[1]);
        }
        Collections.sort(boundaries);
        List<List<Integer>> ans = new ArrayList<>();
        int idx = 0;
        for (int boundary : boundaries) {
            while (idx < buildings.length && buildings[idx][0] <= boundary) {
                priorityQueue.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= boundary) {
                priorityQueue.poll();
            }
            int maxHeight = priorityQueue.isEmpty() ? 0 : priorityQueue.peek()[1];
            if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) != maxHeight) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(boundary);
                temp.add(maxHeight);
                ans.add(temp);
            }
        }
        return ans;
    }

}
