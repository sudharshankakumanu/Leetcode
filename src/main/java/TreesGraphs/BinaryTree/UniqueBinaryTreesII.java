package TreesGraphs.BinaryTree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinaryTreesII {

    public List<TreeNode> generateTrees(int n) {

        return helper(1, n);
    }

    public static List<TreeNode> helper(int start, int end){
        List<TreeNode> trees = new ArrayList<>();

        if(start > end){
            trees.add(null);
            return trees;
        }

        for(int idx = start; idx <= end; idx++){

            List<TreeNode> leftSubTrees = helper(start, idx -1);
            List<TreeNode> rightSubTrees = helper(idx+1, end);

            // for each combination of left and right subtree make idx as root;
            for(TreeNode lst : leftSubTrees){
                for(TreeNode rst : rightSubTrees){
                    TreeNode root = new TreeNode(idx);
                    root.left = lst;
                    root.right = rst;
                    trees.add(root);
                }
            }
        }

        return trees;
    }
}
