package Arrays;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/
public class NextPermutation {

    public static void main(String[] args) {

        int[] arr = {1,3,2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void nextPermutation(int[] nums) {

        if(nums == null || nums.length < 2) return;

        int i = 0;
        int j = 1;
        int indexToSwap = -1;

        while(j < nums.length){

            if(nums[j] > nums[i]){
                indexToSwap = i;
            }

            i++;
            j++;
        }

        if(indexToSwap == -1){
            reverseArray(nums, 0, nums.length-1);
            return;
        }

        else{
            int temp = nums[indexToSwap];
            nums[indexToSwap] = nums[indexToSwap+1];
            nums[indexToSwap+1] = temp;

            arrange(nums, indexToSwap+1);

        }

    }

    public static void reverseArray (int[] nums, int i, int j){

        while(i < j && i < nums.length) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void arrange (int[] nums , int i) {

        int idx = i;

        while(i < nums.length -1 ) {

            if(nums[i+1] > nums[i]) {
                int temp = nums[i+1];
                nums[i+1] = nums[i];
                nums[i] = temp;
            }

            else {
                break;
            }

            i++;
        }

        reverseArray(nums, idx, nums.length -1);
    }
}
