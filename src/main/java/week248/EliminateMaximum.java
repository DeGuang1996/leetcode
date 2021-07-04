package week248;

import java.util.PriorityQueue;

public class EliminateMaximum {

    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            priorityQueue.offer((dist[i] + speed[i] - 1) / speed[i]);
        }
        int ans = 0;
        int cur = 0;
        while (!priorityQueue.isEmpty()) {
            if (!(cur >= priorityQueue.peek())) {
                ans++;
                cur++;
                priorityQueue.poll();
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EliminateMaximum eliminateMaximum = new EliminateMaximum();
        int[] dist = {1,1,2,3};
        int[] speed = {1,1,1,1};
        eliminateMaximum.eliminateMaximum(dist, speed);
    }
}
