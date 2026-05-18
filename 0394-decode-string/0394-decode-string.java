class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {

            // Build number
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            }

            // Opening bracket
            else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currString);

                k = 0;
                currString = new StringBuilder();
            }

            // Closing bracket
            else if (ch == ']') {

                int repeat = countStack.pop();
                StringBuilder prevString = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    prevString.append(currString);
                }

                currString = prevString;
            }

            // Normal character
            else {
                currString.append(ch);
            }
        }

        return currString.toString();
    }
}