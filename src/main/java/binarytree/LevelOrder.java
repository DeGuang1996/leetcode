package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        // List<List<Integer>> res = new ArrayList<>();
        // Queue<Node> queue = new ArrayDeque<>();
        // if (root == null) {
        //     return res;
        // }
        // queue.offer(root);
        // while (!queue.isEmpty()) {
        //     List<Integer> curLevel = new ArrayList<>();
        //     int curSize = queue.size();
        //     while (curSize-- > 0) {
        //         Node curNode = queue.poll();
        //         if (curNode != null) {
        //             curLevel.add(curNode.val);
        //             if (curNode.children.size() > 0) {
        //                 for (Node nextLevel : curNode.children) {
        //                     queue.offer(nextLevel);
        //                 }
        //             }
        //         }
        //     }
        //     res.add(curLevel);
        // }
        // return res;

        doLevelOrder(root, 0);
        return res;
    }

    private void doLevelOrder(Node root, int depth) {
        if (root == null) {
            return;
        }
        if (depth >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        for (Node nextLevel : root.children) {
            doLevelOrder(nextLevel, depth + 1);
        }
    }
}
