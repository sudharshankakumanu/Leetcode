package PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRommsII_253 {

    public static void main(String[] args){

        int[][] arr = {{0, 30},{5, 16},{15, 20}};

        System.out.println(minMeetingRooms(arr));

    }

    public static int minMeetingRooms(int[][] intervals) {

        if(intervals == null || intervals.length < 1) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(intervals.length , Comparator.comparingInt(a -> a[1]));

        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++){

            int[] interval = pq.poll();

            if(intervals[i][0] < interval[1]) {

                pq.offer(intervals[i]);
            } else {
                interval[1] = intervals[i][1];
            }

            pq.offer(interval);

        }

        return pq.size();

    }
}
