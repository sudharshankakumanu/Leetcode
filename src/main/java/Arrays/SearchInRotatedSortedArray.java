package Arrays;

//https://leetcode.com/problems/search-in-rotated-sorted-array/

public class SearchInRotatedSortedArray {

    public static void main(String[] args){

        int[] arr = {4,5,6,7,0,1,2};

        System.out.println(search(arr, 0));
    }

    //[4,5,6,7,0,1,2]

    // trick is that ,after we pick mid one part of the array is always sorted,
    // we check if our target falls in that sorted range we continue binary search on that range,
    // else we do binary search on other half.

    public static int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        if(nums== null || nums.length == 0) return -1;

        while(start <= end){

            int mid = start + (end - start) / 2 ;

            if(nums[mid] == target) return mid;

            // this means left part is sorted
            if(nums[start] <= nums[mid] ) {

                if(target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            // this means right part is sorted
             else if(nums[mid] <= nums[end]){

                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
