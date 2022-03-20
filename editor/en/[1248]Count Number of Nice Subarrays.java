//Given an array of integers nums and an integer k. A continuous subarray is cal
//led nice if there are k odd numbers on it. 
//
// Return the number of nice sub-arrays. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2,1,1], k = 3
//Output: 2
//Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1
//].
// 
//
// Example 2: 
//
// 
//Input: nums = [2,4,6], k = 1
//Output: 0
//Explanation: There is no odd numbers in the array.
// 
//
// Example 3: 
//
// 
//Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//Output: 16
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10^5 
// 1 <= k <= nums.length 
// Related Topics Array Hash Table Math Sliding Window 
// 👍 1597 👎 39


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int res = 0;
        int cnt = 0;

        while (end < nums.length) {
            if (nums[end] % 2 == 1) {
                cnt++;
            }
            end++;
            while (start < end) {
                if (cnt > k) {
                    if (nums[start] % 2 == 1) {
                        cnt--;
                    }
                    start++;
                } else {
                    break;
                }
            }
            res += end-start;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
