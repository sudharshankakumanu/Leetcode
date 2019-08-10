package DynamicProgramming;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

public class BestTimeToBuyAndSellStockIV {

    public static void main(String[] args) {

    }

    /**
     *
     */
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k+1][prices.length];

        //dp[i][j] represents profit at jth day with at most i transactions until then
        // there are two choices at jth day, if we don't sell the stock dp[i][j] is same as dp[i][j-1]

        //if we sell the stock, then it means we must have brought it some day (t) from 0...j-1
        // so maxProfit at jth day  t -> 0..j-1 Max (prices[j] - prices[t] + dp[t-1][i-1]) dp[t-1][j-1] is max profit until t-1th day as we are buying on t th day

        // t -> 0..j-1 Max (prices[j] - prices[t] + dp[t-1][i-1]) can be written as prices[j] + max (dp[t-1][i-1] - prices[t])

        // so max profit at jth day with at most i transactions is MAX ( dp[i][j-1] , prices[j] + max (dp[t-1][i-1] - prices[t]) )

        for(int i = 1; i < k+1; i++){

            int tempMax = Integer.MIN_VALUE;

            for(int j = 1; j < prices.length; j++){

                dp[i][j] = Math.max(dp[i][j-1] , prices[j] + tempMax);
                tempMax = Math.max(tempMax , dp[j-1][i-1] - prices[j]);
            }
        }

        return dp[k][prices.length-1];
    }

}
