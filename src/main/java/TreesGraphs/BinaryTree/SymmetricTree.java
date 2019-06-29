package TreesGraphs.BinaryTree;

public class SymmetricTree {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {

        if(root == null) return false;

        return isSymmetric_helper(root.left , root.right);

    }

    private boolean isSymmetric_helper(TreeNode n1, TreeNode n2) {

        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;

        return (n1.val == n2.val && isSymmetric_helper(n1.left , n2.right) && isSymmetric_helper(n1.right , n2.left));
    }


}
