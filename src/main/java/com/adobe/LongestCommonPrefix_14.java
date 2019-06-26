package com.adobe;

import javax.xml.transform.Source;
import java.util.Arrays;

public class LongestCommonPrefix_14 {

    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};

        //Arrays.sort(strs);

       //System.out.println(Arrays.asList(strs));

        String prefix = longestCommonPrefix(strs);
        System.out.println(prefix);

    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) return null;
        if(strs.length == 1) return strs[0];

        String minString = strs[0];
        String maxString = strs[0];

        for(String s : strs) {

            minString = minString.compareTo(s) < 0 ? minString : s;
            maxString = maxString.compareTo(s) > 0 ? maxString : s;

        }

        int count = 0;
        for(int i = 0; i < minString.length(); i++){
            if(minString.charAt(i) == maxString.charAt(i)){
                count++;
            } else {
                break;
            }
        }
        //System.out.println(count);
        return minString.substring(0, count);
    }
}
