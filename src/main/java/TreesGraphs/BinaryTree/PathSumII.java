package TreesGraphs.BinaryTree;
//https://leetcode.com/problems/path-sum-ii/

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left= new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);

        System.out.println(pathSum(node, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new ArrayList<>();
        pathSumHelper(root, res, new ArrayList<>(), sum);
        return res;
    }

    public static void pathSumHelper(TreeNode root,  List<List<Integer>> res, List<Integer> subList, int target){

        if(root == null) return;

        subList.add(root.val);

        if(root.left == null && root.right == null && target == root.val) {
           // System.out.println(subList);
            res.add(new ArrayList<>(subList));
            subList.remove(subList.size() -1);

        }
        else{
            pathSumHelper(root.left, res, subList, target - root.val);
            pathSumHelper(root.right, res, subList, target - root.val);
            subList.remove(subList.size() -1);
        }

    }

}
