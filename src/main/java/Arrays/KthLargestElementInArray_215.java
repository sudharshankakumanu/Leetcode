package Arrays;

import java.util.Random;

public class KthLargestElementInArray_215 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};

        System.out.println(findKthLargest(nums, 3));

    }

    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length- 1;
        /*
            A Random object we will use later repeatedly to choose random pivots
        */
        Random rand = new Random(0);

        while(left <= right) {

            int choosenPivotIndex = rand.nextInt(right - left + 1) + left;

            int finalPivotIndex = partition(nums, left, right, choosenPivotIndex);

            if(finalPivotIndex == nums.length-k) return nums[finalPivotIndex];

            else if (finalPivotIndex < nums.length-k) {
                left = finalPivotIndex+1;
            } else {
                right = finalPivotIndex - 1;
            }
        }
        return -1;
    }

    private static int partition(int[] nums, int left, int right, int choosenPivotIndex) {

        while(left <= right) {

            while(left < nums.length && nums[choosenPivotIndex] >= nums[left]) left ++;

            while(right > 0 && nums[choosenPivotIndex] <= nums[right]) right --;

            if(left > right) break;

            swap(nums, left, right);
        }

        swap(nums, choosenPivotIndex, right);

        return right;

    }

    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
