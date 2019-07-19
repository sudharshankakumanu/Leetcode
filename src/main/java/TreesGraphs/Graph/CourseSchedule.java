package TreesGraphs.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {

        int[][] arr = {{0,1}, {0,2} ,{1,3} , {4,1}};

        System.out.println(canFinish(5,arr));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;

        // Convert graph presentation from edges to degree of adjacent list.
        int degree[] = new int[numCourses];  // degree[i] - how many prerequisites are needed for i.

        int count = 0;

        for (int i = 0; i < prerequisites.length; i++)
            degree[prerequisites[i][0]]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {

            if (degree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                count++;
                queue.offer(i);
            }
        }


        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    degree[prerequisites[i][0]]--;
                    if (degree[prerequisites[i][0]] == 0) {
                        // If degree is zero, then add the course to the order.
                        count++;
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return (count == numCourses) ? true : false;
    }
}
