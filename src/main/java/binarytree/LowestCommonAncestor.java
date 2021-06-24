package binarytree;

public class LowestCommonAncestor {

    // private TreeNode ans = null;
    //
    // private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root == null) {
    //         return false;
    //     }
    //     boolean lson = dfs(root.left, p, q);
    //     boolean rson = dfs(root.right, p, q);
    //     if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
    //         ans = root;
    //     }
    //     return (root.val == p.val || root.val == q.val) || (lson || rson);
    // }
    //
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     dfs(root, p, q);
    //     return ans;
    // }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
