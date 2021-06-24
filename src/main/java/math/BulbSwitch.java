package math;

import java.util.HashMap;

public class BulbSwitch {

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public int flipLights(int n, int presses) {
        n = Math.min(n, 3);
        if (presses == 0) {
            return 1;
        }
        if (presses == 1) {
            return n == 1 ? 2 : n == 2 ? 3 : 4;
        }
        if (presses == 2) {
            return n == 1 ? 2 : n == 2 ? 4 : 7;
        }
        return n == 1 ? 2 : n == 2 ? 4 : 8;
    }

    public int numTimesAllBlue(int[] light) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < light.length; i++) {
            count = Math.max(count, light[i]);
            if (count == i + 1) {
                res++;
            }
        }
        return res;
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        }
        int gcd = calcGCD(jug1Capacity, jug2Capacity);
        return targetCapacity % gcd == 0;
    }

    private int calcGCD(int jug1Capacity, int jug2Capacity) {
        if (jug1Capacity == jug2Capacity) {
            return jug1Capacity;
        }
        return calcGCD(Math.max(jug1Capacity, jug2Capacity) - Math.min(jug1Capacity, jug2Capacity), Math.min(jug1Capacity, jug2Capacity));
    }

    public int minDays(int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        return dfs(n, hashMap);
    }

    private int dfs(int n, HashMap<Integer, Integer> hashMap) {
        if (n <= 1) {
            return n;
        }
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }
        int res = Math.min(n % 2 + dfs(n / 2, hashMap) + 1, n % 3 + dfs(n / 3, hashMap) + 1);
        hashMap.put(n , res);
        return res;
    }
}
