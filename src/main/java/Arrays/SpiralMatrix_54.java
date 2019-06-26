package Arrays;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    public static void main(String[] args) {

        int[][] matrix = { {1}, {4},{7}};

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;

        // int right, left,up,down = 0;

        List<Integer> result = new ArrayList<>();

        while(true){

            //traverse right
            for( int i = colBegin; i <= colEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            if(rowBegin > rowEnd || colBegin > colBegin) break;

            //traverse down
            for( int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowBegin > rowEnd || colBegin > colBegin) break;

            //traverse left
            for( int i = colEnd; i >= colBegin; i--) {
                result.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if(rowBegin > rowEnd || colBegin > colBegin) break;

            //traverse up
            for( int i = rowEnd; i >= rowBegin; i--) {
                result.add(matrix[i][colBegin]);
            }
            colBegin++;
            if(rowBegin > rowEnd || colBegin > colBegin) break;
        }

        return result;
    }
}
