package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class CountPalindromicSubsequence {

    public int countPalindromicSubsequence(String s) {
        // int[] count = new int[26];
        // for (char a : s.toCharArray()) {
        //     count[a - 'a']++;
        // }
        // HashSet<String> hashSet = new HashSet<>();
        // for (int i = 0; i < count.length; i++) {
        //     if (count[i] < 3) {
        //         continue;
        //     }
        //     char cur = (char) (i + 'a');
        //     int first = s.indexOf(cur);
        //     int last = s.lastIndexOf(cur);
        //     StringBuilder stringBuilder = new StringBuilder();
        //     stringBuilder.append(cur).append(cur).append(cur);
        //     for (int j = first + 1; j < last; j++) {
        //         stringBuilder.setCharAt(1, s.charAt(j));
        //         hashSet.add(stringBuilder.toString());
        //     }
        // }
        // return hashSet.size();

        HashMap<Character, TreeSet<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.putIfAbsent(s.charAt(i), new TreeSet<>());
            hashMap.get(s.charAt(i)).add(i);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            TreeSet<Integer> treeSet = hashMap.get((char) (i + 'a'));
            if (treeSet != null && treeSet.size() >= 2) {
                int left = treeSet.first();
                int right = treeSet.last();
                for (int j = 0; j < 26; j++) {
                    char end = (char) (j + 'a');
                    if (hashMap.get(end) != null && hashMap.get(end).ceiling(left + 1) != null && hashMap.get(end).ceiling(left + 1) < right) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
