import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;

        // Store {capital, profit}
        int[][] projects = new int[n][2];

        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort projects by required capital
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);

        // Max Heap for profits
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;

        // Pick at most k projects
        for (int project = 0; project < k; project++) {

            // Add all projects we can currently afford
            while (i < n && projects[i][0] <= w) {
                maxHeap.offer(projects[i][1]);
                i++;
            }

            // No project can be started
            if (maxHeap.isEmpty()) {
                break;
            }

            // Take the project with maximum profit
            w += maxHeap.poll();
        }

        return w;
    }
}