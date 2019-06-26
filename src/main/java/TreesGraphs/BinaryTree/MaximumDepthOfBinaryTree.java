package TreesGraphs.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {

    public static void main (String[] args){

        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9);
        p.right = new TreeNode(20);

        p.left.left = null;
        p.left.right = null;

        p.right.left = new TreeNode(15);
        p.right.right = new TreeNode(7);

        System.out.println(maxDepth_iterative(p));

    }

    public int maxDepth_recursive(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth_recursive(root.left),maxDepth_recursive(root.right));
    }



    public static int maxDepth_iterative(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<List<Integer>> objlist = new ArrayList<>();
        if(root == null) return  0;
        q.add(root);
        int count = 0;

        while(!q.isEmpty()){

            q.add(null);
            TreeNode node = q.poll();

            List<Integer> list = new ArrayList<>();

            while(node != null){

               // System.out.print(node.val + " ");

                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }

                list.add(node.val);
                node = q.remove();

            }

           // System.out.println();
            count++;
            objlist.add(list);
        }

        return count;

    }

}
