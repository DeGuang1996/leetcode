package array;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int begin = -1, end = -1;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != nums[i]) {
                if (begin == -1) {
                    begin = i;
                } else {
                    end = i;
                }
            }
        }
        return end - begin;
    }

    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1, right = nums.length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                ans += (left - j - 1);
            }
        }
        return ans;
    }

    private boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }


    public int countDigitOne(int n) {
        int iCount = 0;
        long iFactor = 1;

        long iLowerNum = 0;
        long iCurrNum = 0;
        long iHigherNum = 0;

        while (n / iFactor > 0) {
            iLowerNum = n - (n / iFactor) * iFactor;
            iCurrNum = (n / iFactor) % 10;
            iHigherNum = (n / iFactor) / 10;

            switch ((int) iCurrNum) {
                case 0:
                    iCount += iHigherNum * iFactor;
                    break;
                case 1:
                    iCount += iHigherNum * iFactor + iLowerNum + 1;
                    break;
                default:
                    iCount += (iHigherNum + 1) * iFactor;
                    break;
            }
            iFactor *= 10;
        }
        return iCount;
    }

    public static void main(String[] args) {
        // List<String> stringList = Lists.newArrayList();
        // List<Integer> integerList = stringList.stream().map(Integer::valueOf).collect(Collectors.toList());
        // integerList.sort(Comparator.comparingInt(stringList::indexOf));

        List<String> stringList = Lists.newArrayList("1", "2", "3");
        stringList = stringList.stream().limit(stringList.indexOf("2") + 1).collect(Collectors.toList());
        stringList.forEach(System.out::println);
    }

}
