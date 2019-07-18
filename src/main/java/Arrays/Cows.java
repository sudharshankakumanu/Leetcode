package Arrays;

public class Cows {

    public static void main(String[] args) {

        int[] secret = {1,2,3,4};
        int[] guess = {1,6,3,3};

        System.out.println(getCowsBulls(secret,guess));
    }

//    public String getHint(String secret, String guess) {
//        int bulls = 0;
//        int cows = 0;
//        int[] numbers = new int[10];
//        for (int i = 0; i<secret.length(); i++) {
//            int s = Character.getNumericValue(secret.charAt(i));
//            int g = Character.getNumericValue(guess.charAt(i));
//            if (s == g) bulls++;
//            else {
//                if (numbers[s] < 0) cows++;
//                if (numbers[g] > 0) cows++;
//                numbers[s] ++;
//                numbers[g] --;
//            }
//        }
//        return bulls + "A" + cows + "B";
//    }

    public  static String getCowsBulls (int[] secret, int[] guess){

        int bulls = 0;
        int cows = 0;
        int[] number = new int[100];

        for(int i = 0; i < secret.length; i++){
            int s = secret[i];
            int g = guess[i];
            if(s == g) bulls++;

            else {
                if(number[g] > 0) cows++;
                number[s] ++;
            }
        }

        return "bulls : " + bulls + " cows: " + cows;
    }
}
