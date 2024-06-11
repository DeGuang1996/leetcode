package everyday;

import java.util.HashMap;
import java.util.Map;

public class GetHint {

    public String getHint(String secret, String guess) {
        int bullsCount = 0;
        int cowsCount = 0;
        Map<Integer, Integer> unMatchSecret = new HashMap<>();
        Map<Integer, Integer> unMatchGuess = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullsCount++;
            } else {
                unMatchSecret.put(secret.charAt(i) - '0', unMatchSecret.getOrDefault(secret.charAt(i) - '0', 0) + 1);
                unMatchGuess.put(guess.charAt(i) - '0', unMatchGuess.getOrDefault(guess.charAt(i) - '0', 0) + 1);
            }
        }
        for (Integer key : unMatchSecret.keySet()) {
            cowsCount += Math.min(unMatchSecret.get(key), unMatchGuess.getOrDefault(key, 0));
        }
        return bullsCount + "A" + cowsCount + "B";
    }
}
