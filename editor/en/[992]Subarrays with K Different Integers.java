//Given an integer array nums and an integer k, return the number of good subarr
//ays of nums. 
//
// A good array is an array where the number of different integers in that array
// is exactly k. 
//
// 
// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3. 
// 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,1,2,3], k = 2
//Output: 7
//Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1],
// [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1,3,4], k = 3
//Output: 3
//Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2
//,1,3], [1,3,4].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// 1 <= nums[i], k <= nums.length 
// 
// Related Topics Array Hash Table Sliding Window Counting 
// 👍 2814 👎 40


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();


        while (end < nums.length) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            end++;
            while (start < end) {
                if (map.size() > k) {
                    map.put(nums[start], map.get(nums[start]) - 1);
                    map.remove(nums[start], 0); // 删除value为0的键值对
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
