//Given an array of integers nums and an integer k, return the number of contigu
//ous subarrays where the product of all the elements in the subarray is strictly 
//less than k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,5,2,6], k = 100
//Output: 8
//Explanation: The 8 subarrays that have product less than 100 are:
//[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
//Note that [10, 5, 2] is not included as the product of 100 is not strictly les
//s than k.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3], k = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 106 
// 
// Related Topics Array Sliding Window 
// 👍 3698 👎 128


//leetcode submit region begin(Prohibit modification and deletion)
// clarification
// 1. does this array have a negative value?
// 2. does this array sorted or not?
// 3. does this array possible be none?

// Two Pointers, T O(n), S O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int res = 0;
        int pro = 1;

        while (end < nums.length) {
            pro *= nums[end];
            end++;
            while (start < end) {
                if (pro >= k) { // 当乘积大于k的时候才需要移动start指针
                    pro /= nums[start];
                    start++;
                } else {
                    break;
                }
            }
            res += (end - start); // 每次end或者start有变化时都要更新res
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
