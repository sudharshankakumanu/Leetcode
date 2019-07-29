package DynamicProgramming;

//https://leetcode.com/problems/decode-ways/

public class DecodeWays {

    public static void main(String[] args) {

    }

    public int numDecodings(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();

        int[] dp = new int[len];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <=  len; i++){
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[len];

    }
}
