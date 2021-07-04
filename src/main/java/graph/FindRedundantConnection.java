package graph;

import java.util.ArrayList;

public class FindRedundantConnection {

    private boolean[] visited;
    private ArrayList<ArrayList<Integer>> graphEdges;
    private boolean hasCycle;

    private void addEdge(int u, int v) {
        graphEdges.get(u).add(v);
    }

    private void dfs(int x, int father) {
        visited[x] = true;
        for (Integer y : graphEdges.get(x)) {
            if (y == father) {
                continue;
            }
            if (visited[y]) {
                hasCycle = true;
            } else {
                dfs(y, x);
            }
        }
        visited[x] = false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int node = edges.length + 1;
        visited = new boolean[node];
        graphEdges = new ArrayList<>();

        for (int i = 0; i < node; i++) {
            graphEdges.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
            addEdge(edge[1], edge[0]);

            dfs(1, -1);
            if (hasCycle) {
                return edge;
            }
        }
        return null;
    }
}
