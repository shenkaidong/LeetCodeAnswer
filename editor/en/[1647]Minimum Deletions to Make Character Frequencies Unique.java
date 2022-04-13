//A string s is called good if there are no two different characters in s that 
//have the same frequency. 
//
// Given a string s, return the minimum number of characters you need to delete 
//to make s good. 
//
// The frequency of a character in a string is the number of times it appears 
//in the string. For example, in the string "aab", the frequency of 'a' is 2, while 
//the frequency of 'b' is 1. 
//
// 
// Example 1: 
//
// 
//Input: s = "aab"
//Output: 0
//Explanation: s is already good.
// 
//
// Example 2: 
//
// 
//Input: s = "aaabbbcc"
//Output: 2
//Explanation: You can delete two 'b's resulting in the good string "aaabcc".
//Another way it to delete one 'b' and one 'c' resulting in the good string 
//"aaabbc". 
//
// Example 3: 
//
// 
//Input: s = "ceabaacb"
//Output: 2
//Explanation: You can delete both 'c's resulting in the good string "eabaab".
//Note that we only care about characters that are still in the string at the 
//end (i.e. frequency of 0 is ignored).
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s contains only lowercase English letters. 
// 
// Related Topics String Greedy Sorting 👍 1259 👎 27


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDeletions(String s) {
        // Store the frequency of each character
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        // Add the frequencies to the priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                pq.add(frequency[i]);
            }
        }

        int deleteCount = 0;
        while (pq.size() > 1) {
            int topElement  = pq.remove();

            // If the top two elements in the priority queue are the same
            if (topElement == pq.peek()) {
                // Decrement the popped value and push it back into the queue
                if (topElement - 1 > 0) {
                    pq.add(topElement - 1);
                }
                deleteCount++;
            }
        }

        return deleteCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
