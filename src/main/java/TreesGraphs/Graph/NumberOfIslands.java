package TreesGraphs.Graph;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {

    private static int m;
    private static int n;


    public static void main(String[] args) {


    }

    public static int numIslands(char[][] grid) {

         m = grid.length;
         n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0 ; j < n ; j++) {

                if(grid[i][j] == 1) {

                    numIslandsHelper(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void numIslandsHelper(char[][] grid , int i , int j) {

        if(i < 0 || j < 0 || i > n-1 || j > m-1 || grid[i][j] != 0) return ;

        grid[i][j] = 0;

        //left neighbor
        numIslandsHelper(grid, i, j-1);
        //right neighbor
        numIslandsHelper(grid, i, j+1);
        //top neighbor
        numIslandsHelper(grid, i-1, j);
        //bottom neighbor
        numIslandsHelper(grid, i+1, j);

    }

}
