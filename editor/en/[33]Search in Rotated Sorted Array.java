//There is an integer array nums sorted in ascending order (with distinct values
//). 
//
// Prior to being passed to your function, nums is possibly rotated at an unknow
//n pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, retur
//n the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 12425 👎 828


//leetcode submit region begin(Prohibit modification and deletion)
// clarification
// 1. sorted or not?
// does this have duplicate numbers? -- no it distinct values
// T O(logn)

// 本题先找到连续的子数组， 然后先看看target是否在子数组中， 如果在的话， 结果就在这个数组中
// 不在的话移动左右其中一边， 调整数组大小， 然后再重新找，
// 回到最开始， 先要找到连续递增的子数组，然后在连续的子数组中确认target的位置
// 难点在于如何处理rotated情况， 其实就是多一个判断，
// 如果子数组本身递增， 那么和普通二分法一致， 如果不是， 需要移动左右的一边， 缩小范围再继续

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 从lo到mid是递增的
            if (nums[mid] >= nums[lo]) {
                // target>= lo, target in the hi side of lo, or it is "lo"
                // target < nums[mid] which means target will find between the lo to mid
                if (target >= nums[lo] && target < nums[mid]) {
                    // so we move hi to mid, to shrink the size of the array
                    hi = mid;
                    // if the target is not between the lo to mid, we consider moving the lo to mid
                } else {
                    lo = mid;
                }
                // if lo to mid not ascending order, we start at the hi of mid
            } else {
                // target <= nums[hi], target is in the lo side of this subarray, or it is "hi"
                // target > nums[mid], which target will find between the mid to hi
                if (target <= nums[hi] && target > nums[mid]) {
                    // so we move lo to mid
                    lo = mid;
                    // if the target is not between the mid to the hi, that we move hi to mid
                } else {
                    hi = mid;
                }
            }
        }
        if (nums[lo] == target) {
            return lo;
        }
        return nums[hi] == target ? hi : -1;
    }
}


// This question first finds consecutive sub-arrays, and then first sees whether the target is in the sub-array, if so, the result is in this array
// If not, move one of the lo and hi sides, adjust the size of the array, and then search again,
// Go back to the beginning, first find the continuously ascending sub-array, and then confirm the position of the target in the continuous sub-array
// The difficulty lies in how to deal with the rotated situation, in fact, there is one more judgment,
// If the sub-array itself is ascending, it is consistent with the ordinary binary search, if not, you need to move the lo and hi sides, narrow the range and continue
//leetcode submit region end(Prohibit modification and deletion)
