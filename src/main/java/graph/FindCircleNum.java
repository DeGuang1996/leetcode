package graph;

import java.util.ArrayList;
import java.util.List;

public class FindCircleNum {

    ArrayList<ArrayList<Integer>> edges;
    ArrayList<Integer> visited;

    public int findCircleNum(int[][] isConnected) {
        edges = new ArrayList<>();
        visited = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            edges.add(new ArrayList<>());
            visited.add(0);
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    ArrayList<Integer> edge = edges.get(i);
                    edge.add(j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (visited.get(i) == 0) {
                dfs(i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int i) {
        visited.set(i, 1);
        ArrayList<Integer> edge = edges.get(i);
        for (int j = 0; j < edge.size(); j++) {
            if (visited.get(edge.get(j)) == 0) {
                dfs(edge.get(j));
            }
        }
        visited.set(i, 2);
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        FindCircleNum findCircleNum = new FindCircleNum();
        findCircleNum.findCircleNum(isConnected);
    }
}
