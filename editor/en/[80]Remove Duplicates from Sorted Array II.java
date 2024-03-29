//Given an integer array nums sorted in non-decreasing order, remove some duplic
//ates in-place such that each unique element appears at most twice. The relative 
//order of the elements should be kept the same. 
//
// Since it is impossible to change the length of the array in some languages, y
//ou must instead have the result be placed in the first part of the array nums. M
//ore formally, if there are k elements after removing the duplicates, then the fi
//rst k elements of nums should hold the final result. It does not matter what you
// leave beyond the first k elements. 
//
// Return k after placing the final result in the first k slots of nums. 
//
// Do not allocate extra space for another array. You must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// Custom Judge: 
//
// The judge will test your solution with the following code: 
//
// 
//int[] nums = [...]; // Input array
//int[] expectedNums = [...]; // The expected answer with correct length
//
//int k = removeDuplicates(nums); // Calls your implementation
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
// 
//
// If all assertions pass, then your solution will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3]
//Output: 5, nums = [1,1,2,2,3,_]
//Explanation: Your function should return k = 5, with the first five elements o
//f nums being 1, 1, 2, 2 and 3 respectively.
//It does not matter what you leave beyond the returned k (hence they are unders
//cores).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,1,1,2,3,3]
//Output: 7, nums = [0,0,1,1,2,3,3,_,_]
//Explanation: Your function should return k = 7, with the first seven elements 
//of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
//It does not matter what you leave beyond the returned k (hence they are unders
//cores).
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums is sorted in non-decreasing order. 
// 
// Related Topics Array Two Pointers 
// 👍 3480 👎 910


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num != nums[i-2]) { // 只有排序的数组可以这样思考， 否则不成立
                nums[i++] = num; // 只有在条件允许的情况下放入nums里
            }
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
