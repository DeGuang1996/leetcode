package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistanceK {
    
    private List<Integer> ans = new ArrayList<>();
    private HashMap<Integer, TreeNode> fatherMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        calFather(root, null);
        calAns(target, null, 0, k);
        return ans;
    }

    private void calFather(TreeNode root, TreeNode father) {
        if (father != null && root != null) {
            fatherMap.put(root.val, father);
        }
        if (root != null) {
            calFather(root.left, root);
            calFather(root.right, root);
        }
    }

    private void calAns(TreeNode root, TreeNode from, int depth, int k) {
        if (root == from || root == null) {
            return;
        }
        if (depth == k) {
            ans.add(root.val);
            return;
        }
        if (fatherMap.containsKey(root.val) && fatherMap.get(root.val) != from) {
            calAns(fatherMap.get(root.val), root, depth + 1, k);
        }
        if (root.left != from) {
            calAns(root.left, root, depth + 1, k);
        }
        if (root.right != from) {
            calAns(root.right, root, depth + 1, k);
        }
    }
}
