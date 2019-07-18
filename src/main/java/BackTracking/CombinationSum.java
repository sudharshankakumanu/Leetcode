package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int[] arr = {2,3,6,7};
        System.out.println(combinationSum(arr, 7));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;

        helper(res, candidates, target, new ArrayList<>(), 0);

        return res;

    }

    private static  void helper(List<List<Integer>> res, int[] candidates, int target, ArrayList<Integer> subList, int start) {

        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(subList));
            return;
        }

        for(int i = start ; i < candidates.length; i++) {

            subList.add(candidates[i]);
            helper(res, candidates, target - candidates[i], subList, i );
            subList.remove(subList.size() - 1);
        }

    }
}
