class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {

            int lineLength = words[i].length();
            int j = i + 1;

            // Take maximum words
            while (j < words.length &&
                   lineLength + 1 + words[j].length() <= maxWidth) {

                lineLength += 1 + words[j].length();
                j++;
            }

            StringBuilder line = new StringBuilder();

            int numWords = j - i;

            // Last line OR one word
            if (j == words.length || numWords == 1) {

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k != j - 1)
                        line.append(" ");
                }

                while (line.length() < maxWidth)
                    line.append(" ");
            }

            else {

                int totalChars = 0;

                for (int k = i; k < j; k++)
                    totalChars += words[k].length();

                int spaces = maxWidth - totalChars;

                int gap = numWords - 1;

                int even = spaces / gap;
                int extra = spaces % gap;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int curr =
                            even + (extra > 0 ? 1 : 0);

                        for (int s = 0; s < curr; s++)
                            line.append(" ");

                        extra--;
                    }
                }
            }

            result.add(line.toString());

            i = j;
        }

        return result;
    }
}