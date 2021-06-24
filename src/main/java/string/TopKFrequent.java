package string;

import java.util.*;

public class TopKFrequent {

    // class WordCount {
    //     String word;
    //     Integer count;
    // }
    //
    // public List<String> topKFrequent(String[] words, int k) {
    //     HashMap<String, Integer> hashMap = new HashMap<>();
    //     for (String word : words) {
    //         if (hashMap.containsKey(word)) {
    //             hashMap.put(word, hashMap.get(word) + 1);
    //         } else {
    //             hashMap.put(word, 1);
    //         }
    //     }
    //
    //     TreeSet<WordCount> treeSet = new TreeSet<>((o1, o2) -> {
    //         if (!o1.count.equals(o2.count)) {
    //             return o1.count < o2.count ? 1 : -1;
    //         } else {
    //             return o1.word.compareTo(o2.word);
    //         }
    //     });
    //     for (String string : hashMap.keySet()) {
    //         WordCount wordCount = new WordCount();
    //         wordCount.word = string;
    //         wordCount.count = hashMap.get(string);
    //         treeSet.add(wordCount);
    //     }
    //     List<String> res = new ArrayList<>();
    //     while (k-- > 0) {
    //         res.add(treeSet.first().word);
    //         treeSet.remove(treeSet.first());
    //     }
    //     return res;
    // }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((entry1, entry2) -> {
            if (entry1.getValue().equals(entry2.getValue())) {
                return entry2.getKey().compareTo(entry1.getKey());
            } else {
                return entry1.getValue() - entry2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }

}
