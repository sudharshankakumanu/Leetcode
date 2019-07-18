package BackTracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/restore-ip-addresses/
public class RestoreIpAddresses {

    public static void main(String[] args) {

    }

    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();

        helper(res,  s, "",0);

        return res;
    }

    private static void helper(List<String> res, String s, String prefix, int count) {

        if(count == 3){
            //if(isValidIp(prefix)) res.add(new String(prefix));
        }

        for(int i = 0 ; i < s.length(); i++){


        }

    }
}
