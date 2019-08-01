package BackTracking;

import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchII {

    public static void main(String[] args) {

        //char[][] board = { {'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'} };
        //String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'b','b','a','a','b','a'},{'b','b','a','b','a','a'},{'b','b','b','b','b','b'},{'a','a','a','b','a','a'},{'a','b','a','a','b','b'}};
        String[] words = {"abbbababaa"};
        System.out.println(findWords(board, words));

    }

    public static List<String> findWords(char[][] board, String[] words){

        int numRows = board.length;
        int numCols = board[0].length;

        List<String> res = new ArrayList<>();

        List<String> wordList = new ArrayList<>();
        for(String s: words){ // have to do it this way as List.remove is not supported if list is created as Arrays.asList()
            wordList.add(s);
        }

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                helper(board,res, wordList,i,j,"");
            }
        }
        return res;
    }

    public static void helper(char[][] board, List<String> res, List<String> wordList, int i, int j, String prefix ){

        System.out.println(prefix);
        if(wordList.contains(prefix)){
            wordList.remove(prefix);
            res.add(new String(prefix));
            return;
        }

        if(i < 0  || i > board.length -  1 || j < 0 || j > board[0].length - 1 || board[i][j] == '*'){
            return;
        }

        char c = board[i][j];
        board[i][j] = '*' ;// marking it as visited

        helper(board, res, wordList, i+1, j , prefix + c);
        helper(board, res, wordList, i-1, j , prefix + c);
        helper(board, res, wordList, i, j+1 , prefix + c);
        helper(board, res, wordList, i, j-1 , prefix + c);

        board[i][j] =  c;// unmarking it to original char

        return;
    }
}
