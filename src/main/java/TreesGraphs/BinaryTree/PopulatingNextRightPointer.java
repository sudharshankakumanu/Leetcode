package TreesGraphs.BinaryTree;

public class PopulatingNextRightPointer {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {

        root.next = null;
        connecthelper(root.left, root.right);
        return root;

    }

    private void connecthelper(Node left, Node right) {

        if(left == null || right == null) return;

        left.next = right;

        if(left.left == null){
            return;
        }

        connecthelper(left.left, left.right);
        connecthelper(left.right, right.left);
        connecthelper(right.left, right.right);
    }

}
