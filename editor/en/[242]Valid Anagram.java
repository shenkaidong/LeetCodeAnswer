//Given two strings s and t, return true if t is an anagram of s, and false othe
//rwise. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: s = "anagram", t = "nagaram"
//Output: true
// Example 2: 
// Input: s = "rat", t = "car"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you adapt
// your solution to such a case? 
// Related Topics Hash Table String Sorting 
// 👍 4301 👎 202


//leetcode submit region begin(Prohibit modification and deletion)
// Clarification
// Does these two strings could be null?
// Does the String t always large or equal to String s

// This issue I will use counter to do this work
// T O(N), S O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] tmap = new int[256];
        int[] smap = new int[256];
        // Use these two counters to count each string of characters
        for (char c : t.toCharArray()) {
            tmap[c]++;
        }
        for (char c : s.toCharArray()) {
            smap[c]++;
        }
        // if these two string characters are do not match, return false, otherwise, return true;
        return isvalid(smap, tmap);
    }

    private boolean isvalid(int[] tmap, int[] smap) {
        for (int i = 0; i < 256; i++) {
            if (smap[i] != tmap[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
