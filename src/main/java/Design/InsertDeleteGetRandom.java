package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {

    ArrayList<Integer> nums;
    Map<Integer, Integer> locationsMap;
    Random rand;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        nums = new ArrayList<>();
        locationsMap = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if(locationsMap.containsKey(val)) return false;

        locationsMap.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if(!locationsMap.containsKey(val)) return false;

        int location = locationsMap.get(val);
        // if it is not last swap it with last elem and remove last, if it is last just remove last
        if(location < nums.size()-1){
            //add last elem to location
            nums.set(location , nums.get(nums.size() - 1));
            // change that in map

            locationsMap.put(nums.get(location) , location);

        }
        //remove last
        locationsMap.remove(val);
        nums.remove(nums.size()-1);

        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {

        if(nums.size() > 0) // rand of 0 is not valid
            return nums.get( rand.nextInt(nums.size()) );
        return -1;
    }
}
