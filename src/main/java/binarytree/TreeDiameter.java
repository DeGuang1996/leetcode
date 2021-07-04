package binarytree;

import java.util.ArrayList;

public class TreeDiameter {

    // public int treeDiameter(int[][] edges) {
    //
    // }

    private ArrayList<ArrayList<Integer>> edges;
    private int res;

    public int numWays(int n, int[][] relation, int k) {
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < relation.length; i++) {
            edges.get(relation[i][0]).add(relation[i][1]);
        }
        res = 0;
        dfs(0, 0, n, k);
        return res;
    }

    private void dfs(int cur, int curDepth, int n, int k) {
        if (curDepth > k) {
            return;
        }
        if (cur == n - 1 && curDepth == k) {
            res++;
            return;
        }
        ArrayList<Integer> curEdge = edges.get(cur);
        for (int i = 0; i < curEdge.size(); i++) {
            dfs(curEdge.get(i), curDepth + 1, n, k);
        }
    }

}
