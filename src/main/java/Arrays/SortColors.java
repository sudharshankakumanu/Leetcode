package Arrays;

import java.util.Arrays;

public class SortColors {

    public  static void main (String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static  void sortColors(int[] nums) {

        if(nums == null || nums.length == 0 || nums.length == 1) return;

        int lo = 0;
        int hi = nums.length - 1;

        for(int i = lo; i <= hi;) {

            if(nums[i] == 2) {

                // swap hi and i and decrement hi
                int temp = nums[i];
                nums[i] = nums[hi];
                nums[hi] = temp;

                hi--;
            }

            else if (nums[i] == 0) {
                //swap lo and i and increment lo
                int temp = nums[i];
                nums[i] = nums[lo];
                nums[lo] = temp;

                lo++; i++;
            }

            else { // when nums[i] == 1 , just increment i and lo will keep track of 1

                i++;
            }
        }

        return;
    }
}
