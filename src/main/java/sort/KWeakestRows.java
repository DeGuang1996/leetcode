package sort;

import java.util.PriorityQueue;

public class KWeakestRows {

    class Team implements Comparable<Team> {
        int count;
        int id;

        public Team(int count, int id) {
            this.count = count;
            this.id = id;
        }

        @Override
        public int compareTo(Team team) {
            if (team.count != this.count) {
                return this.count - team.count;
            }
            return this.id - team.id;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        PriorityQueue<Team> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            priorityQueue.offer(new Team(count, i));
        }
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll().id;
        }
        return ans;
    }
}
