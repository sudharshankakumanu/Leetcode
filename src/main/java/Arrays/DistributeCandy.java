package Arrays;

//https://leetcode.com/problems/candy/

// first traverse left to right. If the ranking[i] < ranking[i-1] give the child at ith position one more candy than i-1th position.
// Then traverse right to left , if the ranking[i] > ranking[i+1] and if he has less or equal candies, give him one more candy.
public class DistributeCandy {

    public int candy(int[] ratings) {

        int[] candy = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++){
            candy[i] = 1;
        }

        for(int i = 1 ; i< candy.length ; i++) {

            if(ratings[i] > ratings[i-1] )
                candy[i]  = candy[i-1]  + 1;
        }

        for(int i = candy.length - 2 ; i >= 0 ; i--) {

            if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1])
                candy[i]  = candy[i+1]  + 1;
        }

        int sum = 0;
        for(int i : candy){
            sum += i;
        }

        return sum;
    }


}
