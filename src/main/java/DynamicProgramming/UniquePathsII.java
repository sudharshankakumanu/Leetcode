package DynamicProgramming;
//https://leetcode.com/problems/unique-paths-ii/

public class UniquePathsII {

    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int numRows = obstacleGrid.length;
        int numCols = obstacleGrid[0].length;

        if( obstacleGrid[0][0] == 1) return 0;

        obstacleGrid[0][0] = 1;

        //first row all columns is 1
        for(int i = 1; i < numCols; i++ ){

            obstacleGrid[0][i] = ( obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i-1] );
        }

        //first col all rows is 1
        for(int i = 1; i < numRows; i++ ){
            obstacleGrid[i][0] = ( obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i-1][0] );
        }

        for(int i = 1; i < numRows; i ++){
            for(int j = 1; j < numCols; j++){
                obstacleGrid[i][j] = ( obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i][j-1] + obstacleGrid[i-1][j] );
            }
        }

        return obstacleGrid[numRows - 1 ][numCols - 1 ] ;

    }
}
