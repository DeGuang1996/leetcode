package binarytree;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    private int maxDepth;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        maxDepth = 0;
        doRightSideView(root, ans, 0);
        return ans;
    }

    private void doRightSideView(TreeNode root, List<Integer> ans, int depth) {
        if (root != null) {
            if (maxDepth == depth) {
                ans.add(root.val);
                maxDepth++;
            }
            doRightSideView(root.right, ans, depth + 1);
            doRightSideView(root.left, ans, depth + 1);
        }
    }

    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans - 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
