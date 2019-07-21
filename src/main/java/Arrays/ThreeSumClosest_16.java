package Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest_16 {

    public static void main(String[] args) {

    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int mindiff = Integer.MAX_VALUE;
        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {

            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi) {

                int sum = nums[lo] + nums[hi] + nums[i];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    if (target - sum < mindiff) {
                        mindiff = target - sum;
                        closest = sum;
                    }
                    lo++;
                } else {
                    if (sum - target < mindiff) {
                        mindiff = sum - target;
                        closest = sum;
                    }
                    hi--;
                }
            }
        }

        return closest;
    }
}
