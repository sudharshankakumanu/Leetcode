package Strings;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/reorder-log-files/
public class ReaderLogFiles {

    public static void main(String[] args) {

    }

    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                //it is guaranteed to have a word after prefix
                int s1i = s1.indexOf(" ");
                int s2i = s2.indexOf(" ");
                //fir st chars after space is what we need to compare to sort
                char c1 = s1.charAt(s1i + 1);
                char c2 = s2.charAt(s2i + 1);

                if(c1 <= '9'){

                    if(c2 <= '9'){
                        // this means both are  numbers so preserve order
                        return 0;
                    }
                    // c2 is not number so c1 is > c2
                    return 1;
                }

                if(c2 <= '9'){
                    // this means c1 is not number so c1 is < c2
                    return -1;
                }

                //both are not numbers, so just compare rest of strings
                int val = s1.substring(s1i + 1).compareTo(s2.substring(s2i + 1));
                // val will be zero if both are equal, then compare prefixes
                if(val == 0) return s1.substring(0,s1i).compareTo(s2.substring(0,s2i));

                return val;


            }
        };

        Arrays.sort(logs, comparator);

        return logs;
    }
}
