//Given a sorted array of distinct integers and a target value, return the index
// if the target is found. If not, return the index where it would be if it were i
//nserted in order. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,6], target = 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3,5,6], target = 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [1,3,5,6], target = 7
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums contains distinct values sorted in ascending order. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 7090 👎 389


//leetcode submit region begin(Prohibit modification and deletion)
// clarification
// 1. does this array sorted or not?
// 2. the return of this question is Index right?
// 3. does this array contain duplicate numbers?
// 4. if array is null or nums length is 0, should I return 0 or anything else?
// 5. do I need to consider a large number that can out of boundary

//T O (logn)  S O(1)

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = (hi - lo)/2 + lo;
            if (target >= nums[mid]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (target <= nums[lo]) {
            return lo;
        } else if (target <= nums[hi]) {
            return hi;
        } else {
            return hi + 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
