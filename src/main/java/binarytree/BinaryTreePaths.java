package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, new StringBuilder());
        return res;
    }

    private void dfs(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }
        stringBuilder.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(stringBuilder.toString());
        }
        stringBuilder.append("->");
        int len = stringBuilder.length();
        dfs(root.left, stringBuilder);
        stringBuilder.setLength(len);
        dfs(root.right, stringBuilder);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val >= low && root.val <= high) {
            res += root.val;
            res += rangeSumBST(root.left, low, high);
            res += rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            res += rangeSumBST(root.right, low, high);
        } else {
            res += rangeSumBST(root.left, low, high);
        }
        return res;
    }
}
