package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class EventualSafeNodes {

    ArrayList<Integer> visited = new ArrayList<>();

    // dfs解法
    // public List<Integer> eventualSafeNodes(int[][] graph) {
    //     List<Integer> ans = new ArrayList<>();
    //     for (int i = 0; i < graph.length; i++) {
    //         visited.add(0);
    //     }
    //     for (int i = 0; i < graph.length; i++) {
    //         if (dfs(graph, i)) {
    //             ans.add(i);
    //         }
    //     }
    //     return ans;
    // }

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
            } else if (visited.get(i) == 1) {
                return false;
            }
        }
        visited.set(i, 2);
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[graph.length];
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                edges.get(graph[i][j]).add(i);
            }
            inDegree[i] = graph[i].length;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            for (Integer next : edges.get(cur)) {
                if (--inDegree[next] == 0) {
                    deque.offer(next);
                }
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
