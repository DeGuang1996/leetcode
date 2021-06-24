package string;

import java.util.ArrayList;

public class Permutation {

    public String[] permutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        calc(result, 0, s);
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void calc(ArrayList<String> result, int begin, String s) {
        result.add(s);
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = begin; i < s.length(); i++) {
            stringBuilder.setCharAt(i, s.charAt(begin));
            stringBuilder.setCharAt(begin, s.charAt(i));
            calc(result, i + 1, stringBuilder.toString());
            stringBuilder.setCharAt(i, s.charAt(i));
            stringBuilder.setCharAt(begin, s.charAt(begin));
        }
    }
}
