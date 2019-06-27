package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));

    }

    /*
    simple approach is to add characters to FIFO queue, remove elements one by one and add next possible char and add them back to queue
     */
    public static List<String> letterCombinations(String digits) {

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;

        ans.add("");

        for (int i = 0; i < digits.length(); i++) {

            while (ans.peek().length() == i) { // if we are adding 2nd digit num of characters should be 1 in the string that we are removing
                String t = ans.remove();
                for (char s : map.get(digits.charAt(i)).toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public static List<String> letterCombinationsRecursive(String digits) {

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        ans.add("");

        if (digits.isEmpty()) return ans;

        helper(digits.charAt(0), ans, map);

        return ans;

    }

    private static void helper(char charAt, List<String> ans, HashMap<Character, String> map) {

//        if()
//
//        char[] arr = map.get(charAt).toCharArray();
//        for(char c : arr){
//
//            for(String s : ans){
//                s = s + c;
//            }
    }
}

