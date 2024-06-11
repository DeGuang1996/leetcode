package everyday;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {

    public List<Integer> majorityElement(int[] nums) {
        return Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(v -> v.getValue() > nums.length / 3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
