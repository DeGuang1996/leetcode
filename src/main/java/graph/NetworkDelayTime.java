package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, ArrayList<int[]>> edges = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int from = times[i][0];
            int to = times[i][1];
            int cost = times[i][2];

            edges.putIfAbsent(from, new ArrayList<>());
            edges.get(from).add(new int[]{to, cost});
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((term1, term2) -> term1[1] - term2[1]);
        priorityQueue.offer(new int[]{k, 0});
        HashMap<Integer, Integer> visited = new HashMap<>();
        int ans = 0;

        while (!priorityQueue.isEmpty()) {
            if (visited.size() >= n) {
                break;
            }
            int[] cur = priorityQueue.poll();
            int from = cur[0];
            int cost = cur[1];

            if (visited.containsKey(from)) {
                continue;
            }
            if (edges.containsKey(from)) {
                ArrayList<int[]> to = edges.get(from);
                for (int[] next : to) {
                    if (!visited.containsKey(next[0])) {
                        priorityQueue.offer(new int[]{next[0], next[1] + cost});
                    }
                }
            }
            visited.put(from, cost);
            ans = Math.max(ans, cost);
        }

        if (visited.size() < n) {
            return -1;
        }
        return ans;
    }
}
