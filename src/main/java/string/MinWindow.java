package string;

import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverFragment;

import java.util.HashMap;

public class MinWindow {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        String res = "";
        int count = 0;
        int i = 0, j = 0;

        while (i < s.length() && j < s.length()) {
            while (i < j) {
                i++;
            }
            if (hashMap.containsKey(s.charAt(i))) {
                if (hashMap.get(s.charAt(i)) > 0) {
                    count++;
                }
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) - 1);
            }
            while (count == t.length() && j <= i) {
                if (res.length() == 0 || res.length() > i - j + 1) {
                    res = s.substring(j, i + 1);
                }
                if (hashMap.containsKey(s.charAt(j))) {
                    hashMap.put(s.charAt(j), hashMap.get(s.charAt(j)) + 1);
                    if (hashMap.get(s.charAt(j)) > 0) {
                        count--;
                        j++;
                        break;
                    }
                }
                j++;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        minWindow.minWindow("ADOBECODEBANC", "ABC");
    }
}
