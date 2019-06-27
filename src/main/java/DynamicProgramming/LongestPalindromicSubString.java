package DynamicProgramming;

public class LongestPalindromicSubString {

    public  static void main(String[] args){

        String s = "aaaa";
        System.out.println(longestPalindrome(s));

    }

    public static String longestPalindrome(String s) {

        Boolean[][] dp = new Boolean[s.length()][s.length()];

        String res = "";

        // we need to start at end because dp[i+1][j-1] might have been calculated already, if we start from beginning, we will get
        // null pointer exception as d[i+1] is not calculated before

        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){

                boolean b1 = (s.charAt(i) == s.charAt(j));

                dp[i][j] = b1 && ((j - i < 3) || dp[i+1][j-1] );

                if( dp[i][j] && (j - i + 1 > res.length())){
                    res = s.substring(i, j+1);
                }
            }
        }

        return res;

    }
}
