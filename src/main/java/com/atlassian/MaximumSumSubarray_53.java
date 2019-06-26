package com.atlassian;

public class MaximumSumSubarray_53 {

    public static void main(String[] args) {


    }

    //-2,1,-3,4,-1,2,1,-5,4
    public static int maxSubArray(int[] nums) {

        int maxSum = 0;
        int curSum = 0;

        for(int j = 0; j < nums.length; j++) {

            curSum += nums[j];
            if(j == 0) maxSum = curSum;
            maxSum = Math.max(maxSum, curSum);
            if(curSum < 0 && j < nums.length-1) {

                curSum = 0;
            }

        }

        return maxSum;
    }

    public static int maxSubArray_DP_approach(int[] nums) {

        // our sub problem is maxSum(nums[] ,i) is max sum sub array ending at i
        //  maxSum(nums[] ,i) = nums[i] + ( maxSum(nums[] ,i-1) > 0 ? maxSum(nums[] ,i-1) : 0)

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < nums.length; i++){

            dp[i] = nums[i] + ( dp[i-1] > 0 ? dp[i-1]  : 0);
            max = Math.max(max, dp[i]);
        }

        return max;

    }

}
