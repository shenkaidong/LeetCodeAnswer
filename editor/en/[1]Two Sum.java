//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists. 
// 
// Related Topics Array Hash Table 
// 👍 18792 👎 667


//leetcode submit region begin(Prohibit modification and deletion)
// clarification
// 1. Does this Array have duplicate numbers?
// 2. Does this Array sorted or not?
// 3. Does this has mutiplal solutions?
// 4. Can I use the same element twice?
// 5. if I do not find the correct answer, what should I return?

// Hashmap to solve, Time O(n), Spece O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // put each element to the Hashmap
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            // We need concider that the same element do not allow use twice, so here we need to compare the index
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[] {i, map.get(target - nums[i])};
            }

        }
        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
