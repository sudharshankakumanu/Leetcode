package Arrays;

import java.util.Arrays;

public class ShortestDistanceToACharacter_821 {

    public static void main(String[] args){

        System.out.println(shortestToChar("loveleetcode" , 'e'));
    }

    public static int[] shortestToChar(String S, char C) {

        int[] res = new int[S.length()];
        int max = Integer.MAX_VALUE;

        if (S.charAt(0) == C) res[0] = 0;
        else res[0] = max;

        for(int i = 1; i < res.length; i++){

            if(S.charAt(i) == C) res[i] = 0;

            else if (res[i-1] == max) res[i] = max;

            else {
                res[i] = res[i-1] + 1;
            }

        }
        System.out.println(Arrays.toString(res));

        for(int i = res.length-2; i >= 0; i--){

            res[i] = Math.min(res[i] , res[i+1] + 1);

        }

        System.out.println(Arrays.toString(res));

        return res;
    }

//    public static int[] shortestToChar(String s, char c) {
//        int n = s.length();
//        int[] dist = new int[n];
//        for (int i = 0; i < n; i++) {
//            if (s.charAt(i) == c) continue;
//            dist[i] = Integer.MAX_VALUE;
//        }
//        System.out.println(Arrays.toString(dist));
//        for (int i = 0; i < n-1; i++) {
//            if (dist[i] == Integer.MAX_VALUE) continue;
//            else dist[i + 1] = Math.min(dist[i+1], dist[i] + 1);
//        }
//        System.out.println(Arrays.toString(dist));
//        for (int i = n-1; i > 0; i--) {
//            dist[i-1] = Math.min(dist[i-1], dist[i] + 1);
//        }
//        System.out.println(Arrays.toString(dist));
//        return dist;
//    }
}
