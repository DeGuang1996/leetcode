package week245;

import java.util.HashMap;

public class WonderfulSubstrings {

    public long wonderfulSubstrings(String word) {
        char[] chars = word.toCharArray();
        long res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int mask = 0;

        hashMap.put(0 ,1);
        for (int i = 0; i < chars.length; i++) {
            mask = mask ^ (1 << (chars[i] - 'a'));
            if (hashMap.containsKey(mask)) {
                res += hashMap.get(mask);
            }

            for (int j = 0; j < 10; j++) {
                int temp = mask ^ (1 << j);
                if (hashMap.containsKey(temp)) {
                    res += hashMap.get(temp);
                }
            }
            hashMap.put(mask, hashMap.getOrDefault(mask, 0) + 1);
        }
        return res;
    }
}
