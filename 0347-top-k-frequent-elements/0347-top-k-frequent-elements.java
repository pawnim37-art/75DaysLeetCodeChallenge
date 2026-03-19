import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        // Step 3: Keep only top k elements
        for (int num : map.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll(); // remove least frequent
            }
        }

        // Step 4: Build result array
        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }

        return result;
    }
}