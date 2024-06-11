package everyday;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers {

    private List<Integer> needs;
    private int ans = Integer.MAX_VALUE;
    private List<Integer> price;
    private List<List<Integer>> findPacks;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<List<Integer>> findPacks = new ArrayList<>();
        for (List<Integer> pack : special) {
            int sum = 0;
            boolean over = false;
            for (int i = 0; i < pack.size() - 1; i++) {
                sum += pack.get(i) * price.get(i);
                if (pack.get(i) > needs.get(i)) {
                    over = true;
                    break;
                }
            }
            if (!over && pack.get(pack.size() - 1) < sum) {
                findPacks.add(pack);
            }
        }
        this.needs = needs;
        this.price = price;
        this.findPacks = findPacks;
        List<Integer> curFill = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            curFill.add(0);
        }
        dfs(curFill, 0);
        return ans;
    }

    private boolean canAdd(List<Integer> pack, List<Integer> curFill) {
        for (int i = 0; i < curFill.size(); i++) {
            if (curFill.get(i) + pack.get(i) > needs.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void addPack(List<Integer> pack, List<Integer> curFill) {
        for (int i = 0; i < curFill.size(); i++) {
            curFill.set(i, curFill.get(i) + pack.get(i));
        }
    }

    private void delPack(List<Integer> pack, List<Integer> curFill) {
        for (int i = 0; i < curFill.size(); i++) {
            curFill.set(i, curFill.get(i) - pack.get(i));
        }
    }

    private int calDirCost(List<Integer> curFill) {
        int ans = 0;
        for (int i = 0; i < curFill.size(); i++) {
            ans += (needs.get(i) - curFill.get(i)) * price.get(i);
        }
        return ans;
    }

    private void dfs(List<Integer> curFill, int curCost) {
        for (List<Integer> pack : findPacks) {
            if (canAdd(pack, curFill)) {
                addPack(pack, curFill);
                curCost += pack.get(pack.size() - 1);
                dfs(new ArrayList<>(curFill), curCost);
                curCost -= pack.get(pack.size() - 1);
                delPack(pack, curFill);
            }
        }
        curCost += calDirCost(curFill);
        ans = Math.min(curCost, ans);
    }
}
