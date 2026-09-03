import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
        }

        // 0 = not visited
        // 1 = currently visiting
        // 2 = completely visited
        int[] state = new int[numCourses];

        // Check every course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] state) {

        // Cycle found
        if (state[course] == 1) {
            return false;
        }

        // Already completely checked
        if (state[course] == 2) {
            return true;
        }

        // Mark as currently visiting
        state[course] = 1;

        // Visit all dependent courses
        for (int next : graph.get(course)) {
            if (!dfs(next, graph, state)) {
                return false;
            }
        }

        // Mark as completely visited
        state[course] = 2;

        return true;
    }
}
