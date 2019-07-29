package DynamicProgramming;

//https://leetcode.com/problems/unique-binary-search-trees/

public class UniqueBinarySubTrees {

    public static void main(String[] args) {

        System.out.println(numTrees(3));
    }
    /**
     * This is called catalan number sequence
     *  G(i)  =  G(i-1)*G(N-i) is the  number of BST  with  i as root for 1  to N numbers
     *   1234 will have same numbr of possibilities as 2345 so  we use  d[i-j]
     * dp[n] represents number of possible BSTs until n, which
     */
    public static int numTrees(int n) {

        int [] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2 ;  i <=  n; i++){
            for(int j = 1; j  <= i; j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }

        return dp[n];

    }
}
