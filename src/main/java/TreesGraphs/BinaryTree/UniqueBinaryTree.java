package TreesGraphs.BinaryTree;

import java.util.List;

public class UniqueBinaryTree {

    int count = 0;

    public int numTrees(int n) {

        helper(1,n);
        return count;
    }

    public static void helper(int start, int end) {
    }

}
