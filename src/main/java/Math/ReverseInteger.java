package Math;

public class ReverseInteger {

    public static void main(String[] args){

        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

    public static int reverse(int x) {

        Boolean isNeg = x < 0 ? true : false;

        int num = Math.abs(x);
        int res = 0;

        while( num != 0){

            int newRes = res*10 + (num%10);
            if( (newRes - (num%10))/10 != res ) return 0; // we need to check this coz of overflow
            res = newRes;
            num = num/10;
        }

        return isNeg == true ? -1*res : res;

    }


}
