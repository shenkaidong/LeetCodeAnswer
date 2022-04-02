//Given a string s, return true if the s can be palindrome after deleting at mos
//t one character from it. 
//
// 
// Example 1: 
//
// 
//Input: s = "aba"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.
// 
//
// Example 3: 
//
// 
//Input: s = "abc"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s consists of lowercase English letters. 
// 
// Related Topics Two Pointers String Greedy 
// 👍 4293 👎 255


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return palindrome(s, start + 1, end) || palindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }
    private boolean palindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
