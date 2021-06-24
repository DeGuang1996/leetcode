package binarytree;

public class IsValidBST {

    private boolean doIsValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return doIsValidBST(root.left, min, root.val) && doIsValidBST(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return doIsValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
