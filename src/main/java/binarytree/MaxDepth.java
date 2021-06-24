package binarytree;

import java.util.ArrayList;
import java.util.List;

public class MaxDepth {

    private List<Integer> elements = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        put(root);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < elements.size(); i++) {
            res = Math.min(res, elements.get(i) - elements.get(i - 1));
        }
        return res;
    }

    private void put(TreeNode root) {
        if (root == null) {
            return;
        }
        put(root.left);
        elements.add(root.val);
        put(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else {
            if (left.val != right.val) {
                return false;
            }
            return symmetric(left.left, right.right) && symmetric(left.right, right.left);
        }
    }
}
