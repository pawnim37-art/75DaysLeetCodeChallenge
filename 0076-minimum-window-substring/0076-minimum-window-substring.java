class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();

        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int required = need.size();
        int formed = 0;

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch) &&
                window.get(ch).intValue() == need.get(ch).intValue()) {
                formed++;
            }

            while (formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}