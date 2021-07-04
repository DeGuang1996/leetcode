package binarytree;

import java.util.HashMap;
import java.util.HashSet;

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

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root == null) {
    //         return null;
    //     }
    //     if (root.val == p.val || root.val == q.val) {
    //         return root;
    //     }
    //     TreeNode left = lowestCommonAncestor(root.left, p, q);
    //     TreeNode right = lowestCommonAncestor(root.right, p, q);
    //
    //     if (left != null && right != null) {
    //         return root;
    //     } else if (left == null) {
    //         return right;
    //     } else {
    //         return left;
    //     }
    // }


    private HashMap<Integer, TreeNode> father = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        calFather(root);
        father.put(root.val, root);
        HashSet<TreeNode> hashSet = new HashSet<>();
        while (p != null) {
            hashSet.add(p);
            p = father.get(p.val);
        }
        while (q != null) {
            if (hashSet.contains(q)) {
                return q;
            }
            q = father.get(q.val);
        }
        return root;
    }

    private void calFather(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            father.put(root.left.val, root);
            calFather(root.left);
        }
        if (root.right != null) {
            father.put(root.right.val, root);
            calFather(root.right);
        }
    }

}
