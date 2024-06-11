package autumnProgramming;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaxmiumScore {

    public int maxmiumScore(int[] cards, int cnt) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] % 2 == 0) {
                even.add(cards[i]);
            } else {
                odd.add(cards[i]);
            }
        }
        even.sort((num1, num2) -> num2 - num1);
        odd.sort((num1, num2) -> num2 - num1);
        int idxEven = 0;
        int idxOdd = 0;

        int ans = 0;
        while (cnt > 0) {
            if (cnt % 2 == 0) {
                if (even.size() - idxEven >= 2 && odd.size() - idxOdd >= 2) {
                    int evenValue = even.get(idxEven) + even.get(idxEven + 1);
                    int oddValue = odd.get(idxOdd) + odd.get(idxOdd + 1);
                    if (evenValue > oddValue) {
                        idxEven += 2;
                        ans += evenValue;
                    } else {
                        idxOdd += 2;
                        ans += oddValue;
                    }
                    cnt -= 2;
                } else if (even.size() - idxEven >= 2) {
                    int evenValue = even.get(idxEven) + even.get(idxEven + 1);
                    idxEven += 2;
                    ans += evenValue;
                    cnt -= 2;
                } else if (odd.size() - idxOdd >= 2) {
                    int oddValue = odd.get(idxOdd) + odd.get(idxOdd + 1);
                    idxOdd += 2;
                    ans += oddValue;
                    cnt -= 2;
                } else {
                    ans += even.get(idxEven);
                    idxEven++;
                    ans += odd.get(idxOdd);
                    idxOdd++;
                    cnt -= 2;
                }
            } else {
                if (ans % 2 == 0) {
                    if (idxEven < even.size()) {
                        ans += even.get(idxEven);
                        idxEven++;
                    } else {
                        ans += odd.get(idxOdd);
                        idxOdd++;
                    }
                    cnt--;
                } else {
                    if (idxOdd < odd.size()) {
                        ans += odd.get(idxOdd);
                        idxOdd++;
                    } else {
                        ans += even.get(idxEven);
                        idxEven++;
                    }
                    cnt--;
                }
            }
        }
        if (ans % 2 == 1) {
            return 0;
        }
        return ans;
    }
}
