package datastructure;

import java.util.*;

public class RandomizedSet {

    private HashMap<Integer, Integer> hashMap;
    private List<Integer> nums;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        hashMap = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hashMap.containsKey(val)) {
            return false;
        }
        hashMap.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) {
            return false;
        }
        int idx = hashMap.get(val);
        hashMap.put(nums.get(nums.size() - 1), idx);
        hashMap.remove(nums.get(idx));
        Collections.swap(nums, idx, nums.size() - 1);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        randomizedSet.getRandom();
    }
}
