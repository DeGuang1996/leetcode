package graph;

import java.util.*;

public class NumBusesToDestination {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        boolean[][] edges = new boolean[routes.length][routes.length];
        HashMap<Integer, HashSet<Integer>> routeMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                HashSet<Integer> hashSet = routeMap.getOrDefault(routes[i][j], new HashSet<>());
                if (hashSet.contains(i)) {
                    continue;
                }
                hashSet.add(i);
                routeMap.put(routes[i][j], hashSet);
            }
        }
        HashSet<Integer> sourceList = routeMap.get(source);
        HashSet<Integer> targetList = routeMap.get(target);
        if (sourceList == null || targetList == null) {
            return -1;
        }
        if (sourceList.size() >= routes.length) {
            return 1;
        }

        for (Integer i : routeMap.keySet()) {
            HashSet<Integer> hashSet = routeMap.get(i);
            for (Integer begin : hashSet) {
                for (Integer end : hashSet) {
                    edges[begin][end] = true;
                    edges[end][begin] = true;
                }
            }
        }

        int[] dis = new int[routes.length];
        Arrays.fill(dis, -1);
        Queue<Integer> queue = new LinkedList<>();
        for (int end : routeMap.getOrDefault(source, new HashSet<>())) {
            dis[end] = 1;
            queue.offer(end);
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y = 0; y < dis.length; y++) {
                if (edges[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    queue.offer(y);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int end : routeMap.getOrDefault(target, new HashSet<>())) {
            res = Math.min(res, dis[end]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[][] routes = {{1,2,7},{3,6,7}};
        NumBusesToDestination numBusesToDestination = new NumBusesToDestination();
        numBusesToDestination.numBusesToDestination(routes, 1, 6);
    }
}
