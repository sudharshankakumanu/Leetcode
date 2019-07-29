package Arrays;

//https://leetcode.com/problems/daily-temperatures/

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {

        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }

    public static int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        for(int i = 0; i < T.length; i++){

            while(!stack.isEmpty() && T[i] > T[stack.peek()]){

                int index = stack.pop();
                res[index] = i-index;
            }

            stack.push(i);
        }

        return res;

    }
}
