package binarytree;

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (preBegin > preEnd || preEnd >= preorder.length || inBegin > inEnd || inEnd >= inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preBegin]);
        int mid = inBegin;
        while (mid <= inEnd) {
            if (inorder[mid] == preorder[preBegin]) {
                break;
            }
            mid++;
        }
        int left = mid - inBegin;
        if (left > 0) {
            root.left = doBuildTree(preorder, inorder, preBegin + 1, preBegin + left, inBegin, inBegin + left - 1);
        }

        int right = inEnd - mid;
        if (right > 0) {
            root.right = doBuildTree(preorder, inorder, preBegin + left + 1, preEnd, inBegin + left + 1, inEnd);
        }
        return root;
    }
}
