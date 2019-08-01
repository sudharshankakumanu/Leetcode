package BackTracking;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        int numRows = board.length;
        int numCols = board[0].length;

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(helper(board,word,i,j,0))
                    return true;
            }
        }

        return false;
    }

    public static boolean helper(char[][] board, String word, int i, int j, int ind){
        if(ind == word.length()){
            return true;
        }

        if(i < 0  || i > board.length -  1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind)){
            return false;
        }

        board[i][j] = '*' ;// marking it as visited

        boolean exist = helper(board,word, i+1, j , ind+1) ||
                        helper(board,word, i-1, j , ind+1) ||
                        helper(board,word, i, j+1 , ind+1) ||
                        helper(board,word, i, j-1 , ind+1);

        board[i][j] =  word.charAt(ind);// unmarking it to original char

        return exist;
    }
}
