package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        // Set<Character> set = new HashSet<>();
        // int i = 0, j = 0;
        // int res = 0;
        // for (; j < s.length(); j++) {
        //     if (set.contains(s.charAt(j))) {
        //         for (; i < j; i++) {
        //             set.remove(s.charAt(i));
        //             if (!set.contains(s.charAt(j))) {
        //                 i++;
        //                 set.add(s.charAt(j));
        //                 break;
        //             }
        //         }
        //     } else {
        //         set.add(s.charAt(j));
        //         res = Math.max(res, j - i + 1);
        //     }
        // }
        // return res;

        if (s.isEmpty()) {
            return 0;
        }
        int left = 0, res = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

}
