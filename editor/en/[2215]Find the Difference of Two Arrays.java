//Given two 0-indexed integer arrays nums1 and nums2, return a list answer of si
//ze 2 where: 
//
// 
// answer[0] is a list of all distinct integers in nums1 which are not present i
//n nums2. 
// answer[1] is a list of all distinct integers in nums2 which are not present i
//n nums1. 
// 
//
// Note that the integers in the lists may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3], nums2 = [2,4,6]
//Output: [[1,3],[4,6]]
//Explanation:
//For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 a
//nd nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
//For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 a
//nd nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6]. 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
//Output: [[3],[]]
//Explanation:
//For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == n
//ums1[3], their value is only included once and answer[0] = [3].
//Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// -1000 <= nums1[i], nums2[i] <= 1000 
// 
// Related Topics Hash Table 
// 👍 94 👎 2


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();    // create 2 hashsets
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1){ set1.add(num); }  // add nums1 elements to set1
        for(int num : nums2){ set2.add(num); }  // add nums2 elements to set2

        List<List<Integer>> res = new ArrayList<>();
        // Initialize result list with 2 empty sublists that we will return
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for(int num : set1){ // just iterate to all elements of set1
            if(!set2.contains(num)){ res.get(0).add(num); }
            // add those elements to first sublist of result list, which are not in set2.
        }
        for(int num : set2){ // just iterate to all elements of set2
            if(!set1.contains(num)){ res.get(1).add(num); }
            // add those elements to first sublist of result list, which are not in set1
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
