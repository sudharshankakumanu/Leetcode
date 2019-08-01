package TreesGraphs.BinaryTree;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord.length() != endWord.length()) return 0;

        Set<String> visited = new HashSet<>();
        Map<String, Integer> ladderLength = new HashMap<>();
        wordList.add(endWord);

        int count = 0;

        for(int i = 0; i < beginWord.length(); i++){

            char[] charArray = beginWord.toCharArray();

            for(char c = 'a' ; c <= 'z'; c++){

                charArray[i] = c;

                String s = String.valueOf(charArray);
                if(s.equals(endWord))  return count+1;

            }
        }

        return -1;

    }
}
