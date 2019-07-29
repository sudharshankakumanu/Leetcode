package DynamicProgramming;

public class RegularExpressionMatching {
    // s= aab p = c*a*b
    public boolean isMatch(String s, String p) {

        /**
         *  dp[i][j] represents if it is a match untul ith char of s and jth char of p
         *
         *  case1 : if p.charAt(j) = s.charAt(i) then dp[i][j] = dp[i-1][j-1]
         *  case2 : if p.charAt(j) = '.' , then it doesn't matter what is at s.charAt(i), then dp[i][j] = dp[i-1][j-1]
         *  case3 : if p.charAt(j) = '*' , then there can be multiple sub cases
         *          case 3.1 : if if two chars not equal or its not a '.' i.e p.charAt(j-1) != s.charAt(i) and p.charAt(j-1) != '.'
         *                     dp[i][j] = dp[i]dp[j-2] a* here contributes to nothing
         *
         *          case 3.2 : if  p.charAt(j-1) = '.' || p.charAt(j-1) = s.charAt(i)
         *                          dp[i][j] = dp[i][j-2] //if a* matches empty
         *                          dp[i][j] = dp[i-1][j-2] //if a* is counted as a
         *                          dp[i][j] = dp[i-1][j] //if a* matches multiple a's
         *
         *  d[i][0] = false , as empty pattern can't match anything
         *  dp[0][j] , if string is empty any pattern of type _*_*_*... matches empty string
         *
         */

        if(s == null || p == null) return false;

        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }

        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 1; j < p.length() + 1; j++){
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);
                if(curS == curP || curP == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(curP == '*'){
                    char preCurP = p.charAt(j - 2);
                    if(preCurP != '.' && preCurP != curS){
                        dp[i][j] = dp[i][j - 2];
                    }else{
                        dp[i][j] = (dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j]);
                    }
                }
            }
        }

        return dp[s.length()][p.length()];

    }
}
