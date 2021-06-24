package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Codec {

    private String doSerialize(TreeNode root, String code) {
        if (root == null) {
            code += "null,";
            return code;
        }
        code += root.val + ",";
        code = doSerialize(root.left, code);
        code = doSerialize(root.right, code);
        return code;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return doSerialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));
        return doDeserialize(stringList);
    }

    private TreeNode doDeserialize(List<String> data) {
        if (data.isEmpty()) {
            return null;
        }
        if (data.get(0).equals("null")) {
            data.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.get(0)));
        data.remove(0);
        root.left = doDeserialize(data);
        root.right = doDeserialize(data);
        return root;
    }

    public static void main(String[] args) {
        String data = "1,2,3,null,null,4,5";
        Codec codec = new Codec();
        codec.deserialize(data);
    }
}
