package LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {

    public static void main(String[] args) {




    }

    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;

        while(curr != null){
            map.put(curr,new Node(curr.val,null,null));
            curr = curr.next;
        }

       // Node temp = null;

        for(Node n : map.keySet()){

            Node temp = map.get(n);
            temp.next = map.get(n.next);
            temp.random = map.get(n.random);

        }

        return map.get(head);

    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
