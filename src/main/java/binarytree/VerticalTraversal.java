package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class VerticalTraversal {

    // private TreeMap<Integer, TreeMap<Integer, List<Integer>>> treeMap = new TreeMap<>();
    // private List<List<Integer>> ans = new ArrayList<>();
    //
    // public List<List<Integer>> verticalTraversal(TreeNode root) {
    //     dfs(root, 0, 0);
    //     for (Integer col : treeMap.keySet()) {
    //         ans.add(new ArrayList<>());
    //         TreeMap<Integer, List<Integer>> rowMap = treeMap.get(col);
    //         for (Integer row : rowMap.keySet()) {
    //             List<Integer> list = rowMap.get(row);
    //             Collections.sort(list);
    //             for (Integer val : list) {
    //                 ans.get(ans.size() - 1).add(val);
    //             }
    //         }
    //     }
    //     return ans;
    // }
    //
    // private void dfs(TreeNode root, int row, int col) {
    //     if (root == null) {
    //         return;
    //     }
    //     TreeMap<Integer, List<Integer>> rowMap = treeMap.getOrDefault(col, new TreeMap<>());
    //     List<Integer> list = rowMap.getOrDefault(row, new ArrayList<>());
    //     list.add(root.val);
    //     rowMap.put(row, list);
    //     treeMap.put(col, rowMap);
    //     dfs(root.left, row + 1, col - 1);
    //     dfs(root.right, row + 1, col + 1);
    // }

    class Node implements Comparable<Node> {
        public int row;
        public int col;
        public int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Node node) {
            if (this.col != node.col) {
                return this.col - node.col;
            }
            if (this.row != node.row) {
                return this.row - node.row;
            }
            return this.val - node.val;
        }
    }

    List<Node> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        Collections.sort(list);
        Node pre = null;
        for (Node node : list) {
            if (pre == null || pre.col != node.col) {
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(node.val);
            pre = node;
        }
        return ans;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        list.add(new Node(row, col, root.val));
        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}
