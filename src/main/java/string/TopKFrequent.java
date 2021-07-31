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

    public String maximumTime(String time) {
        StringBuilder stringBuilder = new StringBuilder(time);
        if (stringBuilder.charAt(0) == '?' && stringBuilder.charAt(1) == '?') {
            stringBuilder.setCharAt(0, '2');
            stringBuilder.setCharAt(1, '3');
        } else if (stringBuilder.charAt(0) == '?' && stringBuilder.charAt(1) < '4' && stringBuilder.charAt(1) >= '0') {
            stringBuilder.setCharAt(0, '2');
        } else if (stringBuilder.charAt(0) == '?' && stringBuilder.charAt(1) >= '4' && stringBuilder.charAt(1) <= '9') {
            stringBuilder.setCharAt(0, '1');
        }
        if (stringBuilder.charAt(1) == '?') {
            if (stringBuilder.charAt(0) == '2') {
                stringBuilder.setCharAt(1, '3');
            } else {
                stringBuilder.setCharAt(1, '9');
            }
        }
        if (stringBuilder.charAt(3) == '?') {
            stringBuilder.setCharAt(3, '5');
        }
        if (stringBuilder.charAt(4) == '?') {
            stringBuilder.setCharAt(4, '9');
        }
        return stringBuilder.toString();
    }

    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            ans = ans * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return ans;
    }

}
