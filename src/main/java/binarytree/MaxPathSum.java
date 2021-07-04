package binarytree;

public class MaxPathSum {

    private int res;

    private int doMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = doMaxPathSum(root.left);
        int right = doMaxPathSum(root.right);
        res = Math.max(res, root.val + Math.max(left, 0) + Math.max(right, 0));
        return Math.max(0, Math.max(left, right)) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        doMaxPathSum(root);
        return res;
    }
}
