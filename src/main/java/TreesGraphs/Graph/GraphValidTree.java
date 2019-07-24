package TreesGraphs.Graph;

//https://leetcode.com/problems/graph-valid-tree/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphValidTree {

    public static void main(String[] args) {

        int[][] arr = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(validTree(5, arr));
    }

    public static boolean validTree(int n, int[][] edges) {

        if(n == 0) return true;

        ArrayList[] adj = new ArrayList[n]; // adj[i] is list of all nodes adjacent to i

        for(int i = 0; i < adj.length; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){

            int u = edges[i][0];
            int v = edges[i][1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean visited[] = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()) {

            int node = queue.poll();

            if(visited[node]) return false;

            visited[node] = true;

            for(int i = 0; i < adj[node].size(); i++){

                int adjNode = (int) adj[node].get(i);
                queue.offer(adjNode);

                if(adj[adjNode].size() > 0)
                    adj[adjNode].remove(new Integer(node)); // remove because 0,1 is same as 1,0 and we will have
                //remove(new Integer(node) will remove and element have value node in the list
                //  remove (node)  will  remove  value at index `node`
            }

        }

        //makes sure there are no nodes that doesn't have any connections, it means every node must be visited
        for(boolean b : visited){

            if(!b) return false;
        }


        return true;

    }
}
