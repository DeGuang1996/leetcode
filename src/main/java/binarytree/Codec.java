package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Codec {

    private int cur;
    private StringBuilder code;

    private void doSerialize(TreeNode root) {
        if (root == null) {
            code.append("null,");
            return;
        }
        code.append(root.val).append(",");
        doSerialize(root.left);
        doSerialize(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        code = new StringBuilder();
        doSerialize(root);
        return code.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        cur = 0;
        String[] strings = data.split(",");
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));
        return doDeserialize(stringList);
    }

    private TreeNode doDeserialize(List<String> data) {
        if (cur >= data.size()) {
            return null;
        }
        if (data.get(cur).equals("null")) {
            cur++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.get(cur)));
        cur++;
        root.left = doDeserialize(data);
        root.right = doDeserialize(data);
        return root;
    }
}
