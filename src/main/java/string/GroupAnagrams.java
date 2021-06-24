package string;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> count = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String cur = String.valueOf(chars);
            if (count.containsKey(cur)) {
                List<String> stringList = count.get(cur);
                stringList.add(str);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                count.put(cur, stringList);
            }
        }
        return new ArrayList<>(count.values());
    }
}
