package TreesGraphs.BinaryTree;

//https://leetcode.com/problems/same-tree/

import java.util.Stack;

public class SameTree {

    public static void main (String[] args){

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(isSameTree_iterative(p,q));


    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if(p == null || q == null) return false;

        return ((p.val == q.val) && isSameTree( p.left,  q.left) && isSameTree( p.right,  q.right));
    }

    public static boolean isSameTree_iterative(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if(p == null || q == null) return false;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(p);
        s2.push(q);

        while(!s1.isEmpty() && !s2.isEmpty()){

            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();

            if(n1.val != n2.val) return false;

            if(n1.left != null) s1.push(n1.left);
            if(n2.left != null) s2.push(n2.left);

            if(s1.size() != s2.size()) return false;

            if(n1.right != null) s1.push(n1.right);
            if(n2.right != null) s2.push(n2.right);

            if(s1.size() != s2.size()) return false;

        }

        return s1.size() == s2.size();
    }



}
