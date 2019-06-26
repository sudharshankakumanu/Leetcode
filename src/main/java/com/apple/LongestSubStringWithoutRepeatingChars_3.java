package com.apple;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChars_3 {

    public static void main(String[] args) {

        System.out.print(lengthOfLongestSubstring("dvdf"));

    }
    //Input: "abcabcbb"
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.

    //Input: "pwwkew"
    //Output: 3
    //Explanation: The answer is "wke", with the length of 3.
    //             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.isEmpty()) return 0;
        if(s.length() == 1) return 1;


        Map<Character,Integer> map = new HashMap<Character, Integer>();

        int max = 0;

        for(int i = 0, j = 0; j < s.length(); j++){

            if(map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j)) + 1);

            }

            map.put(s.charAt(j) , j);

            max = Math.max(max, j - i + 1 );

        }
        return max;
    }

}
