package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RestoreArray {

    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int[] temp : adjacentPairs) {
            hashMap.putIfAbsent(temp[0], new ArrayList<>());
            hashMap.putIfAbsent(temp[1], new ArrayList<>());
            hashMap.get(temp[0]).add(temp[1]);
            hashMap.get(temp[1]).add(temp[0]);
        }
        int[] ans = new int[adjacentPairs.length + 1];
        for (int key : hashMap.keySet()) {
            if (hashMap.get(key).size() == 1) {
                ans[0] = key;
                break;
            }
        }
        ans[1] = hashMap.get(ans[0]).get(0);
        for (int i = 2; i < ans.length; i++) {
            ArrayList<Integer> arrayList = hashMap.get(ans[i - 1]);
            ans[i] = arrayList.get(0) == ans[i - 2] ? arrayList.get(1) : arrayList.get(0);
        }
        return ans;
    }
}
