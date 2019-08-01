package Arrays;

public class BestTimeToBuySellStock {

    public static void main(String[] args) {

        int[] stock  =  {7,1,5,3,6,4};

        System.out.println(maxProfit(stock));
    }

    public static int maxProfit(int[] prices) {

        int buyIndex = 0;
        int sellIndex = 0;

        int maxProfit = 0;

        while (sellIndex < prices.length){

            if(prices[sellIndex] <  prices[buyIndex]){
                buyIndex = sellIndex;
            }
            else{
                maxProfit = Math.max(prices[sellIndex]  - prices[buyIndex] , maxProfit);
            }

            sellIndex++;
        }

        return maxProfit;
    }
}
