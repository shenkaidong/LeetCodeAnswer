//Given a string s, return the length of the longest substring that contains at 
//most two distinct characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "eceba"
//Output: 3
//Explanation: The substring is "ece" which its length is 3.
// 
//
// Example 2: 
//
// 
//Input: s = "ccaabbb"
//Output: 5
//Explanation: The substring is "aabbb" which its length is 5.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s consists of English letters. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 1656 👎 25


//leetcode submit region begin(Prohibit modification and deletion)

// Here we can not put start++; inside of else.
// Because if we do this way, when end touch to the s.length(), start will never change
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] smap = new int[256];
        int start = 0;
        int end = 0;
        int res = 0;

        while (start < s.length()) {
            while (end < s.length()) {
                smap[s.charAt(end)]++;
                end++;
                if (isvalid(smap)) {
                    res = Math.max(res, end - start);
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
        int cnt = 0;
        for (int i = 0; i < 256; i++) {
            if (smap[i] > 0) {
                cnt++;
                if (cnt > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
