package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 5, -1, -4};

        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if(i == 0 || nums[i-1] != nums[i]){ // this avoids duplicates

                int lo = i + 1;
                int hi = nums.length - 1;

                while (lo < hi) {

                    int sum = nums[lo] + nums[hi] + nums[i];

                    if(sum == 0) {
                        result.add( Arrays.asList(nums[i] , nums[lo] , nums[hi]));
                        System.out.println(Arrays.asList(nums[i] , nums[lo] , nums[hi]));
                        lo++;
                        while(lo < nums.length && nums[lo] == nums[lo-1]) lo++;
                        hi--;
                        while(hi >= 0 && nums[hi] == nums[hi+1]) hi--;
                    }

                    else if(sum < 0){
                        lo++;
                    }

                    else {
                        hi--;
                    }
                }

            }

        }

        return result;
    }
}
