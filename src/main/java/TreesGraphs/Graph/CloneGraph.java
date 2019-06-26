package TreesGraphs.Graph;

//https://leetcode.com/problems/clone-graph/

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        if(node == null) return null;

        if (map.containsKey(node)) {
            return map.get(node);
        }

        map.put(node , new Node(node.val, new ArrayList<>()));

        for(Node n : node.neighbors){
            map.get(node).neighbors.add(cloneGraph(n));
        }

        return map.get(node);
    }
}
