package Arrays;

public class BestTimeToBuySellStockII {

    public static void main(String[] args) {

        int[] stock  =  {7,1,5,3,6,4};

        System.out.println(maxProfit(stock));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i = 0; i < prices.length - 1; i++){

            if(prices[i+1] > prices[i]) maxProfit += prices[i+1] -  prices[i];
        }

        return maxProfit;
    }
}
