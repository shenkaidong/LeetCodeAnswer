//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 22173 👎 995


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int res = 0;
        int[] smap = new int[256];

        while (start < s.length()) {
            while (end < s.length()) {
                smap[s.charAt(end)]++;
                end++;
                if (isvalid(smap)) {
                    int len = end - start;
                    if (len > res) {
                        res = len;
                    }
                } else {
                    break;
                }
            }
            smap[s.charAt(start)]--;
            start++;
        }
        return res;
    }

    private boolean isvalid(int[] smap) {
        for (int i = 0; i < 256; i++)  {
            if (smap[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
