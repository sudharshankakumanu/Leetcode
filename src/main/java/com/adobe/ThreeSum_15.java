package com.adobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public static void main(String[] args) {

    }

    public int threeSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = nums[lo] + nums[hi] + nums[i];
                while (lo < hi) {

                    if(sum == target) return sum;

//                    else if()

                }
        }

        return 0;
    }
}
