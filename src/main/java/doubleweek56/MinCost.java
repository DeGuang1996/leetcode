package doubleweek56;

import java.util.*;

public class MinCost {

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        ArrayList<HashMap<Integer, Integer>> graphEdges = new ArrayList<>();
        for (int i = 0; i < passingFees.length; i++) {
            graphEdges.add(new HashMap<>());
        }
        for (int[] edge : edges) {
            if (!graphEdges.get(edge[0]).containsKey(edge[1]) || graphEdges.get(edge[0]).get(edge[1]) > edge[2]) {
                graphEdges.get(edge[0]).put(edge[1], edge[2]);
            }
            if (!graphEdges.get(edge[1]).containsKey(edge[0]) || graphEdges.get(edge[1]).get(edge[0]) > edge[2]) {
                graphEdges.get(edge[1]).put(edge[0], edge[2]);
            }
        }
        int[][] dp = new int[passingFees.length][maxTime + 1];
        for (int[] nums : dp) {
            Arrays.fill(nums, Integer.MAX_VALUE);
        }
        dp[0][0] = passingFees[0];
        for (int i = 0; i < maxTime; i++) {
            for (int j = 0; j < passingFees.length; j++) {
                if (dp[j][i] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[j][i + 1] = Math.min(dp[j][i + 1], dp[j][i]);
                for (int next : graphEdges.get(j).keySet()) {
                    int nextCostTime = graphEdges.get(j).get(next);
                    if (nextCostTime + i <= maxTime) {
                        dp[next][i + nextCostTime] = Math.min(dp[next][i + nextCostTime], dp[j][i] + passingFees[next]);
                    }
                }
            }
        }
        return dp[passingFees.length - 1][maxTime] == Integer.MAX_VALUE ? -1 : dp[passingFees.length - 1][maxTime];
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,10},{1,2,10},{2,5,10},{0,3,1},{3,4,10},{4,5,15}};
        int[] passingFees = {5,1,2,20,20,3};
        MinCost minCost = new MinCost();
        minCost.minCost(29, edges, passingFees);
    }
}
