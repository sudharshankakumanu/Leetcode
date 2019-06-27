package Math;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {

        if( x < 0 || (x!=0 && x%10 == 0) )  return false;

        int res = 0;
        int temp = x;

        while( x != 0){

            int newRes = res*10 + (x%10);
            if( (newRes - (x%10))/10 != res ) return false;
            res = newRes;
            x = x/10;
        }

        return (res == temp);

    }
}
