package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/
public class SubsetsII {

    public static void main(String[] args) {

        int[] arr = {2,1,2};
        System.out.println(subsetsWithDup(arr));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return  res;

        Arrays.sort(nums);
        helper(res,nums, new ArrayList<>(), 0);

        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, ArrayList<Integer> subList, int start) {

        if(subList.size() <= nums.length){
            res.add(new ArrayList<>(subList));
        }

        for(int i = start; i < nums.length; i++){

            if(i > start && nums[i] == nums[i-1]) continue;
            subList.add(nums[i]);
            helper(res, nums, subList, i + 1);
            subList.remove(subList.size() - 1);
        }
    }
}
