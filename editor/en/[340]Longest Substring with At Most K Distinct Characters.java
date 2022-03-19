//Given a string s and an integer k, return the length of the longest substring 
//of s that contains at most k distinct characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "eceba", k = 2
//Output: 3
//Explanation: The substring is "ece" with length 3. 
//
// Example 2: 
//
// 
//Input: s = "aa", k = 1
//Output: 2
//Explanation: The substring is "aa" with length 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 104 
// 0 <= k <= 50 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 2200 👎 68


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int start = 0;
        int end = 0;
        int res = 0;
        while (start < s.length()) {
            while (end < s.length()) {
                map[s.charAt(end)]++;
                end++;
                if (isvalid(map, k)) {
                    res = Math.max(res, end - start);
                } else {
                    break;
                }
            }
            map[s.charAt(start)]--;
            start++;
        }
        return res;
    }

    private boolean isvalid(int[] map, int k) {
        int cnt = 0;
        for (int i = 0; i < 256; i++) {
            if (map[i] > 0) {
                cnt++;
                if (cnt > k) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
