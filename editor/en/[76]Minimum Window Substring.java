//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is i
//ncluded in the window. If there is no such substring, return the empty string ""
//. 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' fr
//om string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 105 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related Top
//ics Hash Table String Sliding Window 
// 👍 9686 👎 525


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] smap = new int[256];
        int[] tmap = new int[256];
        // smap和tmap可以看成一个counter
        for (char c : t.toCharArray()) {
            tmap[c]++;
        }


        int start = 0;
        int end = 0;
        int minlen = Integer.MAX_VALUE;
        int minstart = 0;


        while (end < s.length()) {
            smap[s.charAt(end)]++;
            end++;
            while (start < end) {
                if (isvalid(smap, tmap)) {
                    int len = end-start;
                    if (len < minlen) {
                        minlen = len;
                        minstart = start;
                    }
                    // 通过记录minlen和minstart的位置, 来更好地找到substring
                    smap[s.charAt(start)]--;
                    start++;
                    // 这一轮的循环结束, start需要++, 来向右运动
                } else {
                    break;
                }
            }
        }


        return minlen == Integer.MAX_VALUE ? "" : s.substring(minstart, minstart + minlen);
    }

    private boolean isvalid(int[] smap, int[] tmap) {
        for (int i = 0; i < 256; i++) {
            if (smap[i] < tmap[i]) {
                // 判断smap是否包含了所有的tmap的值, smap里记录过的Character, 会++
                // 没有就是0, 所以当smap[i] 总 < tmap[i], 说明肯定有tmap中有的但是smap中没有
                // 所以smap可以看成是一个counter
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
