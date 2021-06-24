package graph;

import java.util.*;

public class FindItinerary {

    private Map<String, PriorityQueue<String>> path = new HashMap<>();
    private List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets.isEmpty()) {
            return res;
        }
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if (path.containsKey(from)) {
                PriorityQueue<String> queue = path.get(from);
                queue.add(to);
            } else {
                PriorityQueue<String> queue = new PriorityQueue<>();
                queue.add(to);
                path.put(from, queue);
            }
        }

        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(String cur) {
        while (path.get(cur) != null && path.get(cur).size() > 0) {
            String next = path.get(cur).poll();
            dfs(next);
        }
        res.add(cur);
    }

}
