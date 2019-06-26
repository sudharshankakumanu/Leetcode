package com.adobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest_16 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSumClosest(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi) {

                    if (nums[lo] + nums[hi] + nums[i] == 0) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] + nums[i] < 0) {
                        lo++;
                    } else {
                        hi--;
                    }
            }




//            if(i == 0 || nums[i-1] != nums[i]) {
//                int lo = i + 1;
//                int hi = nums.length - 1;
//                while (lo < hi) {
//
//                    if (nums[lo] + nums[hi] + nums[i] == 0) {
//                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
//                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
//                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
//                        lo++;
//                        hi--;
//                    } else if (nums[lo] + nums[hi] + nums[i] < 0) {
//                        lo++;
//                    } else {
//                        hi--;
//                    }
//                }
//
//
//            }
        }

        return result;
    }
}
