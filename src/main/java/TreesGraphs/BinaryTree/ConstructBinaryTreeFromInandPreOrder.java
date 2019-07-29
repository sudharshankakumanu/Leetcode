package TreesGraphs.BinaryTree;

import Arrays.TrappingRainWater;

public class ConstructBinaryTreeFromInandPreOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        return buildTreeHelper(preorder,0,preorder.length-1, inorder, 0, inorder.length-1);


    }

    public static TreeNode buildTreeHelper(int[] preorder , int pstart, int pend, int[] inorder, int istart, int iend){

        if(pstart > preorder.length-1 || pstart > pend || istart > iend){
            return null;
        }

        TreeNode root = new TreeNode(preorder[pstart]);
        int rootIndex = 0;

        for(int i = istart; i <= iend; i++){
            if(inorder[i] == preorder[pstart])
                rootIndex = i;
        }

        root.left = buildTreeHelper(preorder,pstart + 1, pstart + rootIndex, inorder, istart, rootIndex - 1);
        root.right = buildTreeHelper(preorder,pstart + rootIndex + 1, pend, inorder, rootIndex + 1, iend);

        return root;
    }
}
