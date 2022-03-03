//Given an integer array nums, return true if any value appears at least twice i
//n the array, and return false if every element is distinct. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,1]
//Output: true
// Example 2: 
// Input: nums = [1,2,3,4]
//Output: false
// Example 3: 
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics Array Hash Table Sorting 
// 👍 3939 👎 926


//leetcode submit region begin(Prohibit modification and deletion)
// clarification
// 1. Does this array sorted or not?

// I will use HashSet, Time O(n), Space O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        // loop the nums put it into the set if first-time appears
        // return true if set contains current number
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
