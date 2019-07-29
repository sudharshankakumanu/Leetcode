package TreesGraphs.BinaryTree;

import java.util.*;

public class InOrderTraversal {
    List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<Integer> inOrderRecursive(TreeNode root) {

        if(root == null) return res;

        inOrderRecursive(root.left);
        res.add(root.val);
        inOrderRecursive(root.right);

        return res;

    }

    public List<Integer> inOrderIterative(TreeNode root) {

        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while( cur != null || !stack.isEmpty()){

            // travel until left most node and add them to stack
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // pop the left most node and add it to res, now repeat it for all the right branch
            cur = stack.pop();
            res.add(cur.val);

            cur = cur.right;


        }

        return res;

    }
}
