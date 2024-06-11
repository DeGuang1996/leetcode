package everyday;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMaximizedCapital {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] projects = new int[profits.length][2];
        for (int i = 0; i < projects.length; i++) {
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }
        Arrays.sort(projects, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

        int total = 0;
        for (int i = 0; i < k; i++) {
            while (total < profits.length && projects[total][1] <= w) {
                priorityQueue.offer(projects[total++][0]);
            }
            if (priorityQueue.isEmpty()) {
                break;
            }
            w += priorityQueue.poll();
        }
        return w;
    }
}
