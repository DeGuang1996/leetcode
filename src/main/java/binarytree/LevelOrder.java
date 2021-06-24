package binarytree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<TreeNode> cur = new ArrayList<>(list);
            List<Integer> temp = new ArrayList<>();
            for (TreeNode node : cur) {
                temp.add(node.val);
            }
            res.add(temp);
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
