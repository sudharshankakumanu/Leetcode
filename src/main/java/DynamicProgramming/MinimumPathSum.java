package DynamicProgramming;

public class MinimumPathSum {

    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // last col all rows
        for(int i = rows -2; i >= 0 ; i--){
            grid[i][cols-1] += grid[i + 1][cols-1];
        }

        // last row all cols
        for(int i = cols - 2; i >= 0 ; i--){
            grid[rows-1][i] += grid[rows-1][i+1];
        }

        for(int i = rows -2; i >= 0 ; i--){
            for(int j = cols -2; j >= 0 ; j--){

                grid[i][j] += Math.min(grid[i+1][j] , grid[i][j+1]);
            }
        }

        return grid[0][0];
    }

}
