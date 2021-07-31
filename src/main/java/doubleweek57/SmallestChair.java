package doubleweek57;

import java.util.ArrayList;
import java.util.Collections;

public class SmallestChair {

    class Chair implements Comparable<Chair> {
        public int begin;
        public int end;
        public int id;

        @Override
        public int compareTo(Chair o) {
            return this.begin - o.begin;
        }

        public Chair(int begin, int end, int id) {
            this.begin = begin;
            this.end = end;
            this.id = id;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        ArrayList<Chair> allChairs = new ArrayList<>();
        ArrayList<Chair> addChair = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            Chair chair = new Chair(times[i][0], times[i][1], i);
            allChairs.add(chair);
        }
        Collections.sort(allChairs);
        int pre = 0, cur = 0;
        for (int i = 0; i < allChairs.size(); i++) {
            cur = allChairs.get(i).begin;
            int during = cur - pre;
            boolean found = false;
            for (int j = 0; j < addChair.size(); j++) {
                int left = addChair.get(j).end - addChair.get(j).begin;
                addChair.get(j).end -= during;
                if (left <= during && !found) {
                    if (targetFriend == allChairs.get(i).id) {
                        return j;
                    } else {
                        addChair.set(j, allChairs.get(i));
                        found = true;
                    }
                }
            }
            if (!found) {
                addChair.add(allChairs.get(i));
                if (targetFriend == allChairs.get(i).id) {
                    return addChair.size() - 1;
                }
            }
            pre = cur;
        }
        return addChair.size();
    }
}
