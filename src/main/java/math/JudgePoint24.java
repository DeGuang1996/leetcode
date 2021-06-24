package math;

import java.util.ArrayList;
import java.util.List;

public class JudgePoint24 {

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int num : cards) {
            list.add((double) num);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (list.size() == 1 && Math.abs(list.get(0) - 24) <= 1e-6) {
            return true;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    List<Double> temp = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        temp.add(list.get(k));
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        switch (k) {
                            case 0:
                                temp.add(list.get(i) + list.get(j));
                                break;
                            case 1:
                                temp.add(list.get(i) * list.get(j));
                                break;
                            case 2:
                                temp.add(list.get(i) - list.get(j));
                                break;
                            case 3:
                                if (Math.abs(list.get(j) - 0) <= 1e-6) {
                                    continue;
                                }
                                temp.add(list.get(i) / list.get(j));
                                break;
                            default:
                                break;
                        }
                        if (dfs(temp)) {
                            return true;
                        }
                        temp.remove(temp.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        JudgePoint24 judgePoint24 = new JudgePoint24();
        judgePoint24.judgePoint24(nums);
    }
}
