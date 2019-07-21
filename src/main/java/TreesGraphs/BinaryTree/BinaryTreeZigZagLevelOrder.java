package TreesGraphs.BinaryTree;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrder {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return result;

        q.add(root);

        int count = 1;

        while (!q.isEmpty()) {

            q.add(null);
            TreeNode node = q.poll();

            List<Integer> tempList = new ArrayList<>();

            while (node != null) {

                if (count % 2 == 1) tempList.add(node.val);
                    // add to the result list beginning, this is same as reversing every other list in the result set
                else tempList.add(0, node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

                node = q.poll();
            }

            count++;

            result.add(tempList);

        }

        return result;

    }
}
