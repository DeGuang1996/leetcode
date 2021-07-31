package doubleweek57;

import java.util.HashMap;

public class AreOccurrencesEqual {

    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
            count = hashMap.get(c);
        }
        for (Character c : hashMap.keySet()) {
            if (hashMap.get(c) != count) {
                return false;
            }
        }
        return true;
    }
}
