import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Indegree of each course
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        // Queue for courses with no prerequisites
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // Topological Sort
        while (!q.isEmpty()) {

            int current = q.poll();

            result[index++] = current;

            for (int next : adj.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // If not all courses are processed, cycle exists
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}