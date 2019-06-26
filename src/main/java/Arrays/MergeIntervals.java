package Arrays;

//https://leetcode.com/problems/merge-intervals/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] - b[0]));

        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];

        result.add(newInterval);

        for (int[] interval : intervals) {

            if (interval[0] <= newInterval[1]) { // overlapping
                newInterval[1] = Math.max(newInterval[1], interval[1]);

            } else { //non-overlapping

                newInterval = interval;
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

}
