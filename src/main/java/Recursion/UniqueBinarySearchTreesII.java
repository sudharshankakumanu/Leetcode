package Recursion;

import TreesGraphs.BinaryTree.InOrderTraversal;
import TreesGraphs.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {

        InOrderTraversal  i = new InOrderTraversal();

        List<TreeNode> res = generateTrees(3);

        for(TreeNode  n :  res){
            System.out.println((i.inOrderRecursive(n)));
            System.out.println(n.val);
        }
    }


    public static List<TreeNode> generateTrees(int n) {
        /**
         * for 1...n numbers with i as root, left subtree will be all possible BSTs with 1...i-1 and right subtrees
         * will  be all  possible  BSTs from  i+1...n, we call that  recursively.
         */
        return genTreeList(1,n);
    }

    private static List<TreeNode> genTreeList (int start, int end) {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
        }

        for(int idx = start; idx <= end; idx++) {
            List<TreeNode> leftList = genTreeList(start, idx - 1);
            List<TreeNode> rightList = genTreeList(idx + 1, end);
            for (TreeNode left : leftList) {
                for(TreeNode right: rightList) {
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
