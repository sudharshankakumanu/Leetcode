package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        if(n == 0) return res;

        helper(res, n , "", 0, 0);

        return res;
    }

    private static void helper(List<String> res, int n, String s, int open, int close) {

        if(s.length() >= n*2) {
            res.add(s);
            return;
        }

        if(open < n) {

            helper(res, n , s + "(", open + 1, close);
        }
        if(open > close) {

            helper(res, n , s + ")", open, close + 1);
        }
    }
}
