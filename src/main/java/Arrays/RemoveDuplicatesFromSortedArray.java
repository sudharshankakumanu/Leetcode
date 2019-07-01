package Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] arr = {1,1,1,2,3,4,4,4,5,5};

        System.out.println(removeDuplicates(arr));
    }
    public static int removeDuplicates(int[] nums) {

        if(nums.length <= 1) return nums.length;

        int i = 0;
        int j = 1;
        int index = 1;

        while(j < nums.length) {

            if(nums[i] != nums[j]) {

                nums[index] = nums[j];
                index++;
                i++;
            }

            j++;
        }

        return index;
    }
}
