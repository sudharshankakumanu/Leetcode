package DynamicProgramming;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 5;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];

        // dp[i][j] represents min coins used to get to amount j with first i coins in the given list of coins

        for(int row = 0; row < coins.length; row++){

            for(int col = 0; col < amount+1; col++){

                // if amount at j is equal to ith coin then we can just use that coin
                if( col == coins[row]){
                    dp[row][col] = 1;
                }

                // if amount at amount is greater than the coin value
                else if(col > coins[row]) {

                    dp[row][col] = row > 0 ? Math.min(dp[row-1][col] , dp[row][col - coins[row]] + 1) :
                            dp[row][col - coins[row]] == 0 ? 0 : dp[row][col - coins[row]] + 1;
                }

                else  {
                    dp[row][col] = row > 0 ? dp[row-1][col] : 0; // if it is first row it is zero
                }
            }
        }

        return dp[coins.length-1][amount] == 0 ? -1 : dp[coins.length-1][amount];


    }
}
