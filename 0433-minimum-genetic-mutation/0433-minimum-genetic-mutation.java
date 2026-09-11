import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        // If end gene is not in bank, impossible
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        char[] genes = {'A', 'C', 'G', 'T'};
        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endGene)) {
                    return mutations;
                }

                char[] arr = current.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char oldChar = arr[j];

                    for (char ch : genes) {
                        arr[j] = ch;

                        String next = new String(arr);

                        if (bankSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    arr[j] = oldChar; // restore
                }
            }

            mutations++;
        }

        return -1;
    }
}