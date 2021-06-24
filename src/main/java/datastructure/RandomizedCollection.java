package datastructure;

import java.util.*;

public class RandomizedCollection {

    private HashMap<Integer, Set<Integer>> hashMap;
    private List<Integer> nums;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        hashMap = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (hashMap.containsKey(val)) {
            Set<Integer> set = hashMap.get(val);
            set.add(nums.size());
            hashMap.put(val, set);

            nums.add(val);
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(nums.size());
        hashMap.put(val, set);

        nums.add(val);
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> set = hashMap.get(val);
        if (set == null) {
            return false;
        }
        Iterator<Integer> iterator = set.iterator();
        int idx = iterator.next();
        hashMap.get(nums.get(nums.size() - 1)).remove(nums.size() - 1);
        if (!hashMap.get(nums.get(nums.size() - 1)).contains(idx)) {
            hashMap.get(nums.get(nums.size() - 1)).add(idx);
            set.remove(idx);
        }
        if (set.size() == 0) {
            hashMap.remove(val);
        } else {
            hashMap.put(val, set);
        }
        nums.set(idx, nums.get(nums.size() - 1));
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(1);
        randomizedCollection.insert(1);
        randomizedCollection.insert(2);
        randomizedCollection.remove(1);
        randomizedCollection.insert(1);
        randomizedCollection.insert(2);
        randomizedCollection.remove(2);
    }
}
