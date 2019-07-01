package Strings;

public class ImplementStrstr {

    public static void main(String[] args) {
        System.out.println( strStr("a" , "a"));
    }

    public static int strStr(String haystack, String needle) {

        if(haystack.length() < needle.length()) return -1;

        if(needle.length() == 0) return 0;

        for(int i = 0; i <= haystack.length(); i++){

            for(int j = 0; j <= haystack.length(); j++) {

                if(j == needle.length()) return i;

                if(i+j == haystack.length()) return -1;

                if(needle.charAt(j) != haystack.charAt(i+j)) break;
            }
        }

        return -1;
    }
}
