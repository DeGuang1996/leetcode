package string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class FrequencySort {

    // class CharCount {
    //     char a;
    //     int count;
    //
    //     public CharCount(char a, int count) {
    //         this.a = a;
    //         this.count = count;
    //     }
    // }
    //
    // public String frequencySort(String s) {
    //     HashMap<Character, Integer> hashMap = new HashMap<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
    //     }
    //     TreeSet<CharCount> treeSet = new TreeSet<>((o1, o2) -> o2.count == o1.count ? o1.a - o2.a : o2.count - o1.count);
    //     for (Character key : hashMap.keySet()) {
    //         treeSet.add(new CharCount(key, hashMap.get(key)));
    //     }
    //     StringBuilder res = new StringBuilder();
    //     for (CharCount cur : treeSet) {
    //         for (int i = 0; i < cur.count; i++) {
    //             res.append(cur.a);
    //         }
    //     }
    //     return res.toString();
    // }

    public String frequencySort(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(128, (Character a, Character b) -> count[b] - count[a]);
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            priorityQueue.offer((char) i);
        }
        StringBuilder res = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Character cur = priorityQueue.poll();
            while (count[cur] > 0) {
                res.append(cur);
                count[cur]--;
            }
        }
        return res.toString();
    }
}
