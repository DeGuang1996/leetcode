package contest;

import java.util.*;

public class Week264 {

    public int countValidWords(String sentence) {
        int ans = 0;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                if (word.length() > 0 && dealWord(word.toString())) {
                    ans++;
                }
                word = new StringBuilder();
            } else {
                word.append(sentence.charAt(i));
            }
        }
        if (word.length() > 0 && dealWord(word.toString())) {
            ans++;
        }
        return ans;
    }

    private boolean dealWord(String word) {
        boolean con = false;
        boolean end = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '-' && !con) {
                if (i > 0 && i < word.length() - 1 && Character.isLowerCase(word.charAt(i - 1)) && Character.isLowerCase(word.charAt(i + 1))) {
                    con = true;
                } else {
                    return false;
                }
            } else if (word.charAt(i) == '!' || word.charAt(i) == '.' || word.charAt(i) == ',') {
                if (i == word.length() - 1) {
                    end = true;
                } else {
                    return false;
                }
            } else if (Character.isLetter(word.charAt(i))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private int[] nums = new int[]{1, 22, 333, 4444, 55555, 666666};
    private int MaxNum = 666667;

    private void dfs(Set<Long> allNum, String cur, boolean[] visited) {
        if (cur.length() > 0 && Long.parseLong(cur) >= MaxNum) {
            return;
        }
        StringBuilder curBuilder = new StringBuilder(cur);
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            String curNum = String.valueOf(nums[i]);
            if (curBuilder.length() + curNum.length() > 6) {
                break;
            }
            visited[i] = true;
            Set<String> strings = new HashSet<>();
            test(cur, curNum, strings);
            for (String next : strings) {
                allNum.add(Long.valueOf(next));
                dfs(allNum, next, visited);
            }
            visited[i] = false;
        }
    }

    private void test(String a, String b, Set<String> ans) {
        ans.add(a + b);
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                String nexta = a.substring(0, i) + b.substring(0, j) + a.substring(i);
                String nextb = b.substring(j);
                if (nexta.equals(a) && nextb.equals(b)) {
                    continue;
                }
                test(nexta, nextb, ans);
            }
        }
    }

    public int nextBeautifulNumber(int n) {
        TreeSet<Long> allNum = new TreeSet<>();
        boolean[] visited = new boolean[nums.length];
        dfs(allNum, "", visited);
        if (allNum.ceiling(Long.valueOf(n + 1)) == null) {
            return 1224444;
        }
        return allNum.ceiling(Long.valueOf(n + 1)).intValue();
    }


    class ScoreNode {
        public int leftCount = 0;
        public int rightCount = 0;
    }

    private int dfs(ScoreNode[] scoreNodes, int i, Map<Integer, ArrayList<Integer>> childMap) {
        ArrayList<Integer> childList = childMap.getOrDefault(i, new ArrayList<>());
        if (childList.size() == 2) {
            if (scoreNodes[childList.get(0)].leftCount != 0 || scoreNodes[childList.get(0)].rightCount != 0) {
                scoreNodes[i].leftCount += (scoreNodes[childList.get(0)].leftCount + scoreNodes[childList.get(0)].rightCount + 1);
            } else {
                scoreNodes[i].leftCount += dfs(scoreNodes, childList.get(0), childMap);
            }
            if (scoreNodes[childList.get(1)].leftCount != 0 || scoreNodes[childList.get(1)].rightCount != 0) {
                scoreNodes[i].rightCount += (scoreNodes[childList.get(1)].leftCount + scoreNodes[childList.get(1)].rightCount + 1);
            } else {
                scoreNodes[i].rightCount += dfs(scoreNodes, childList.get(1), childMap);
            }
        } else if (childList.size() == 1) {
            if (scoreNodes[childList.get(0)].leftCount != 0 || scoreNodes[childList.get(0)].rightCount != 0) {
                scoreNodes[i].leftCount += (scoreNodes[childList.get(0)].leftCount + scoreNodes[childList.get(0)].rightCount + 1);
            } else {
                scoreNodes[i].leftCount += dfs(scoreNodes, childList.get(0), childMap);
            }
        }
        return scoreNodes[i].leftCount + scoreNodes[i].rightCount + 1;
    }

    public int countHighestScoreNodes(int[] parents) {
        ScoreNode[] scoreNodes = new ScoreNode[parents.length];
        for (int i = 0; i < parents.length; i++) {
            scoreNodes[i] = new ScoreNode();
        }
        Map<Integer, ArrayList<Integer>> childMap = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] > -1) {
                ArrayList<Integer> curList = childMap.getOrDefault(parents[i], new ArrayList<>());
                curList.add(i);
                childMap.put(parents[i], curList);
            }
        }
        dfs(scoreNodes, 0, childMap);
        long maxScore = 0L;
        int maxCount = 0;
        for (ScoreNode scoreNode : scoreNodes) {
            long curScore = 1;
            if (scoreNode.leftCount > 0) {
                curScore *= scoreNode.leftCount;
            }
            if (scoreNode.rightCount > 0) {
                curScore *= scoreNode.rightCount;
            }
            if (scoreNode.leftCount + scoreNode.rightCount + 1 < parents.length) {
                curScore *= (parents.length - scoreNode.leftCount - scoreNode.rightCount - 1);
            }
            if (curScore > maxScore) {
                maxCount = 1;
                maxScore = curScore;
            } else if (curScore == maxScore) {
                maxCount++;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Week264 week264 = new Week264();
        // week264.nextBeautifulNumber(1000);
        week264.nextBeautifulNumber(22452);
    }
}
