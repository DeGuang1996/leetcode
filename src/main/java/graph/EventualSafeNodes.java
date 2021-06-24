package graph;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes {

    ArrayList<Integer> visited;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        visited = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            visited.add(0);
        }
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean dfs(int[][] graph, int i) {
        if (visited.get(i) != 0) {
            return visited.get(i) == 2;
        }
        visited.set(i, 1);
        for (int j = 0; j < graph[i].length; j++) {
            if (visited.get(graph[i][j]) == 0) {
                if (!dfs(graph, graph[i][j])) {
                    return false;
                }
            } else if (visited.get(graph[i][j]) == 1) {
                return false;
            }
        }
        visited.set(i, 2);
        return true;
    }
}
