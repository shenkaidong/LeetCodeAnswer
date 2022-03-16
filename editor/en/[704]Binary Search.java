//Given an array of integers nums which is sorted in ascending order, and an int
//eger target, write a function to search target in nums. If target exists, then r
//eturn its index. Otherwise, return -1. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 < nums[i], target < 104 
// All the integers in nums are unique. 
// nums is sorted in ascending order. 
// 
// Related Topics Array Binary Search 
// 👍 3357 👎 87


//leetcode submit region begin(Prohibit modification and deletion)
// clarification
// 1. array sorted or not?
// 2. what should I return, an int?
// 3. if the input array does not contain the target number, what should I return?
// 4. how large is this array? do I need to consider out of boundary

// T O(logn) S O(1)
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int lo  = 0;
        int hi = nums.length - 1;
        while (hi > lo + 1) {
            int mid = (hi - lo)/2 + lo;
            if (target >= nums[mid]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (target == nums[lo]) {
            return lo;
        } else if (target == nums[hi]) {
            return hi;
        } else return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
