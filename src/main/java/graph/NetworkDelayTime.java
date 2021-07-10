package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, ArrayList<int[]>> edges = new HashMap<>();
        for (int[] edge : times) {
            edges.putIfAbsent(edge[0], new ArrayList<>());
            edges.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(term -> term[1]));
        priorityQueue.offer(new int[]{k, 0});
        HashMap<Integer, Integer> distance = new HashMap<>();
        int ans = 0;

        while (!priorityQueue.isEmpty()) {
            if (distance.size() >= n) {
                break;
            }
            int[] edge = priorityQueue.poll();
            int from = edge[0];
            int cost = edge[1];

            if (distance.containsKey(from)) {
                continue;
            }
            if (edges.containsKey(from)) {
                ArrayList<int[]> to = edges.get(from);
                for (int[] next : to) {
                    if (!distance.containsKey(next[0])) {
                        priorityQueue.offer(new int[]{next[0], cost + next[1]});
                    }
                }
            }
            distance.put(from, cost);
            ans = Math.max(ans, cost);
        }
        if (distance.size() < n) {
            return -1;
        }
        return ans;
    }
}
