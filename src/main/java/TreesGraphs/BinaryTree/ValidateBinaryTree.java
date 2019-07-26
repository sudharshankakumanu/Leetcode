package TreesGraphs.BinaryTree;

public class ValidateBinaryTree {

    public boolean isValidBST(TreeNode root) {

        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, int minValue, int maxValue) {

        if(root == null) return true;

        if(root.val >= maxValue || root.val <= minValue) return false;

        return isValidBSTHelper(root.left, minValue, root.val) && isValidBSTHelper(root.right, root.val, maxValue);
    }
}
