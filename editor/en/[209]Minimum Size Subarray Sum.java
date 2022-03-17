//Given an array of positive integers nums and a positive integer target, return
// the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, nums
//r] of which the sum is greater than or equal to target. If there is no such suba
//rray, return 0 instead. 
//
// 
// Example 1: 
//
// 
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem const
//raint.
// 
//
// Example 2: 
//
// 
//Input: target = 4, nums = [1,4,4]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//Follow up: If you have figured out the O(n) solution, try coding another solut
//ion of which the time complexity is O(n log(n)). Related Topics Array Binary Sea
//rch Sliding Window Prefix Sum 
// 👍 6079 👎 182


//leetcode submit region begin(Prohibit modification and deletion)
// clarification
// does this input array sorted or not?
// what should I return if the target not in the array ?
// do I need to consider the Spece Complexity of this question?

// Ok, I will use a sliding window and two pointers to find the minimum size of the subarray.
// T O(n), S O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            end++;
            while (start < end) {
                if (sum >= target) {
                    res = Math.min(res, end - start);
                    sum -= nums[start];
                    start++;
                } else {
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
