//Given an array of integers nums sorted in non-decreasing order, find the start
//ing and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 9152 👎 267


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;
        int lb = bs(nums, target, true);
        if (lb == -1) {
            return res;
        }
        int ub = bs(nums, target, false);
        res[0] = lb;
        res[1] = ub;
        return res;
    }

    private int bs(int[] nums, int target, boolean lower) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = (hi - lo)/2 + lo;
            if (lower) {
                if (target > nums[mid]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            } else {
                if (target >= nums[mid]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }

        if (lower) {
            if (target == nums[lo]) {
                return lo;
            } else return target == nums[hi] ? hi : -1;
        } else {
            if (target == nums[hi]) {
                return hi;
            } else return target == nums[lo] ? lo : -1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
