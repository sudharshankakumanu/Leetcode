package DynamicProgramming;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AmazonTest1 {

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        if (numRows == 0 || numColumns == 0) return 0;
        int dp[][] = new int[numRows][numColumns];

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        return minDistHelper(area, 0, 0, dp, dx, dy);

    }

    private  int minDistHelper(List<List<Integer>> area, int i, int j , int[][] dp, int[] dx, int[] dy) {

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i,j));

        while(!queue.isEmpty()){

            Pair p = queue.peek();

            int m = p.i;
            int n = p.j;

            if(area.get(m).get(n) == 9){
                return dp[m][n];
            }

            queue.poll();

            for(int k=0;k<4;k++) {
                int u = m+dx[k];
                int v = n+dy[k];
                if(isvalid(area,u,v)) {
                    if(dp[u][v]==0) {
                        dp[u][v] = dp[m][n] + 1;
                        queue.offer(new Pair(u,v));
                    }
                }
            }
        }

        return -1;
    }


    boolean isvalid(List<List<Integer>> area,int x,int y) {

        return x>=0 && y>=0 && x< area.size() && y< area.get(0).size() && area.get(x).get(y) != 0;
    }

    public  class Pair {
        int i , j;
        Pair(int i, int j){
           this.i = i;
           this.j = j;
        }

    }
}
