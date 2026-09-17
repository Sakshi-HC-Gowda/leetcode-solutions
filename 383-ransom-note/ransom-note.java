class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        // Count characters in magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Use characters for ransomNote
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;

            if (count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
