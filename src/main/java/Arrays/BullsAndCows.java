package Arrays;
//https://leetcode.com/problems/bulls-and-cows/
public class BullsAndCows {

    public static void main(String[] args) {


        System.out.println(getHint("1807" , "7810"));
    }

    public static String getHint(String secret, String guess) {

        int[] arr =  new int[10]; //0-9 digits
        int bulls = 0;
        int cows = 0;

        for(int i = 0; i < secret.length(); i++){

            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }

            else{
                int s = Character.getNumericValue(secret.charAt(i));
                int g = Character.getNumericValue(guess.charAt(i));

                if(arr[s] < 0 ){ // this means that this char has already occurred in guess string
                    cows++;
                }

                if(arr[g] > 0){ // this means that this char has already occurred in secret string
                    cows++;
                }
                arr[s]++; // increment  the value
                arr[g]--; // decrement the value

            }
        }

        return bulls + "A" + cows + "B";
    }


}
