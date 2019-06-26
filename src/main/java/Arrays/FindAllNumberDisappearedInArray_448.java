package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumberDisappearedInArray_448 {

    public static void main(String[] args) {

        int[] a = {4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbers(a));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {


        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        for(int i : nums){

            if(nums[Math.abs(i)-1] > 0) nums[Math.abs(i)-1] = -1 * nums[Math.abs(i)-1];
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) res.add(i+1);
        }

        return res;

    }

}
