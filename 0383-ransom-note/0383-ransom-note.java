class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq = new int[26];

        // Count characters in magazine
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check ransomNote characters
        for (char ch : ransomNote.toCharArray()) {

            if (freq[ch - 'a'] == 0) {
                return false;
            }

            freq[ch - 'a']--;
        }

        return true;
    }
}