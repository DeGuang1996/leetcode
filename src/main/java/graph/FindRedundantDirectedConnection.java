package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class FindRedundantDirectedConnection {

    private int[] inDegree;
    private int[] outDegree;
    private ArrayList<ArrayList<Integer>> graphEdges = new ArrayList<>();

    public int[] findRedundantDirectedConnection(int[][] edges) {
        inDegree = new int[edges.length + 1];
        outDegree = new int[edges.length + 1];
        for (int i = 0; i <= edges.length; i++) {
            graphEdges.add(new ArrayList<>());
        }
        int[] ans = null;
        int problemNode = -1;
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
            outDegree[edge[0]]++;
            graphEdges.get(edge[0]).add(edge[1]);
            if (inDegree[edge[1]] == 2) {
                problemNode = edge[1];
            }
            // 所有入度都是1的话删除任一节点都可以解环
            if (inDegree[edge[1]] == 1 && outDegree[edge[1]] == 1) {
                ans = edge;
            }
        }
        if (problemNode != -1) {
            ans = null;
            for (int i = edges.length - 1; i >= 0; i--) {
                int from = edges[i][0];
                int to = edges[i][1];
                // 保证节点不孤立
                if (to == problemNode && inDegree[from] + outDegree[from] > 1) {
                    if (ans == null) {
                        ans = edges[i];
                    }
                    // 有向图中互相指向
                    if (graphEdges.get(to).contains(from)) {
                        return edges[i];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindRedundantDirectedConnection findRedundantDirectedConnection = new FindRedundantDirectedConnection();
        int[][] edges = {{1,2},{1,3},{2,3}};
        findRedundantDirectedConnection.findRedundantDirectedConnection(edges);
    }
}
