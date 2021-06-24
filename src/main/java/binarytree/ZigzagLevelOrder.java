package binarytree;

import java.util.*;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        boolean zig = true;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<TreeNode> cur = new ArrayList<>(list);
            List<Integer> temp = new ArrayList<>();
            if (zig) {
                for (TreeNode node : cur) {
                    temp.add(node.val);
                }
            } else {
                for (int i = cur.size() - 1; i >= 0; i--) {
                    temp.add(cur.get(i).val);
                }
            }
            res.add(temp);
            zig = !zig;
            list.clear();
            for (TreeNode node : cur) {
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
        }
        return res;
    }
}
