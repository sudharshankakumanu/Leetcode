package DynamicProgramming;

import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];

       // dp[i] represents if 0 to i can be word breaked
        dp[0] = true; // because 0,0 is ""

        for(int i = 1 ; i <= s.length(); i++){

            for(int j = 0; j < i; j++){

                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }

}
