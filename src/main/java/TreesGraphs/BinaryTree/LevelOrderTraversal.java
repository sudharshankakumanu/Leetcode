package TreesGraphs.BinaryTree;

import Util.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return result;

        q.add(root);

        while (!q.isEmpty()){

            q.add(null);
            TreeNode node = q.poll();

            List<Integer> tempList  = new ArrayList<>();

            while (node != null){

                tempList.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

                node = q.poll();
            }

            result.add(tempList);

        }

        return result;



    }
}
