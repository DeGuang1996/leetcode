package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class HIndex {

    public int hIndex(int[] citations) {
        // Arrays.sort(citations);
        // int h = 0, i = citations.length - 1;
        // while (i >= 0 && citations[i] > h) {
        //     h++;
        //     i--;
        // }
        // return h;

        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations.length - mid > citations[mid]) {
                left = mid + 1;
            } else if (citations.length - mid < citations[mid]) {
                right = mid - 1;
            } else {
                return citations[mid];
            }
        }
        return citations.length - left;
    }
}
