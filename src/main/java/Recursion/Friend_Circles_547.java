package Recursion;

public class Friend_Circles_547 {
    int count = 0;
    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;

        for(int i = 0; i<rows; i++)
        {
            for(int j =0; j<cols; j++)
            {
                if(M[i][j] == 1)
                {
                    count++;
                    M[i][j] = 0;
                    M[j][i] = 0;
                    dfs(i,M);
                }
            }
        }
        return count;
    }

    private void dfs(int rownum, int[][] M) {
        int cols = M[0].length;
        for(int i = 0; i<cols; i++)
        {
            if(M[rownum][i] == 1)
            {
                M[rownum][i] = 0;
                M[i][rownum] = 0;
                if(i != rownum)
                {
                    dfs(i,M);
                }
            }
        }
    }
}
