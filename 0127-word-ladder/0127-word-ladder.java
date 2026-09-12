import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        // If endWord is not present, transformation is impossible
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                char[] chars = word.toCharArray();

                // Try changing every character
                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) {
                            continue;
                        }

                        chars[j] = ch;

                        String newWord = new String(chars);

                        // Found the destination
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If valid and not visited
                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }

                    chars[j] = original;
                }
            }

            level++;
        }

        return 0;
    }
}