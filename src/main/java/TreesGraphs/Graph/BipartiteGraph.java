package TreesGraphs.Graph;

//https://leetcode.com/problems/is-graph-bipartite/

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public boolean isBipartite(int[][] graph) {

        //here graph is a adjacency list
        int[] colors = new int[graph.length]; // array of color of each node red = 1, blue = -1, no color = 0 by default

        for(int i = 0; i < graph.length; i++){

            if(colors[i] == 0){

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                colors[i] = 1; // paint it with red

                while(!queue.isEmpty()){

                    int node = queue.poll();

                    for(int adj : graph[node]){
                        // if the adj node is already red return false;
                        if(colors[adj] == colors[node]) return  false;

                        else if(colors[adj] == 0){

                            colors[adj] = -1 * colors[node]; // paint them with opposite color;
                            queue.add(adj);
                        }

                    }
                }
            }
        }

        return true;

    }

}
