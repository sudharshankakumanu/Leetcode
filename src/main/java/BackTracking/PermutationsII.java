package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://ibb.co/k4zv00
https://ibb.co/ncMm7f
https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {

    public static void main(String[] args) {

        int[] arr = {1,1,2};
        System.out.println(permuteUnique(arr));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return  res;

        Arrays.sort(nums);
        helper(res, nums, new ArrayList<>(), new boolean[nums.length]);

        return res;


    }

    private static void helper(List<List<Integer>> res, int[] nums, ArrayList<Integer> subList, boolean[] used) {

        if(subList.size() == nums.length){
            res.add(new ArrayList<>(subList));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;

            used[i] = true;
            subList.add(nums[i]);

            helper(res, nums, subList, used);

            used[i] = false;
            subList.remove(subList.size() - 1);
        }
    }
}
