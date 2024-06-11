package everyday;

import java.util.ArrayList;
import java.util.List;

public class StringAllPermutation {

    private List<String> ans = new ArrayList<>();

    public void calc(String a, String b, String cur, ArrayList<Boolean> visitedA, ArrayList<Boolean> visitedB) {
        if (cur.length() == visitedA.size() + visitedB.size()) {
            ans.add(cur);
            return;
        }
        for (int i = 0; i < visitedA.size(); i++) {
            if (!visitedA.get(i)) {
                visitedA.set(i, true);
                calc(a, b, cur + a.charAt(i), new ArrayList<>(visitedA), new ArrayList<>(visitedB));
                visitedA.set(i, false);
            }
        }
        for (int i = 0; i < visitedB.size(); i++) {
            if (!visitedB.get(i)) {
                visitedB.set(i, true);
                calc(a, b, cur + b.charAt(i), new ArrayList<>(visitedA), new ArrayList<>(visitedB));
                visitedB.set(i, false);
            }
        }
    }

    public static void main(String[] args) {
        String a = "12";
        String b = "345";
        StringAllPermutation stringAllPermutation = new StringAllPermutation();
        ArrayList<Boolean> visitedA = new ArrayList<>();
        ArrayList<Boolean> visitedB = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            visitedA.add(false);
        }
        for (int i = 0; i < b.length(); i++) {
            visitedB.add(false);
        }
        stringAllPermutation.calc(a, b, "", visitedA, visitedB);
        for (String s : stringAllPermutation.ans) {
            System.out.println(s);
        }
    }
}
