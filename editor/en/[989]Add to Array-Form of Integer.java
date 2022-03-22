//The array-form of an integer num is an array representing its digits in left t
//o right order. 
//
// 
// For example, for num = 1321, the array form is [1,3,2,1]. 
// 
//
// Given num, the array-form of an integer, and an integer k, return the array-f
//orm of the integer num + k. 
//
// 
// Example 1: 
//
// 
//Input: num = [1,2,0,0], k = 34
//Output: [1,2,3,4]
//Explanation: 1200 + 34 = 1234
// 
//
// Example 2: 
//
// 
//Input: num = [2,7,4], k = 181
//Output: [4,5,5]
//Explanation: 274 + 181 = 455
// 
//
// Example 3: 
//
// 
//Input: num = [2,1,5], k = 806
//Output: [1,0,2,1]
//Explanation: 215 + 806 = 1021
// 
//
// 
// Constraints: 
//
// 
// 1 <= num.length <= 104 
// 0 <= num[i] <= 9 
// num does not contain any leading zeros except for the zero itself. 
// 1 <= k <= 104 
// 
// Related Topics Array Math 
// 👍 1144 👎 140


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int i = num.length - 1;
        int carry = 0;
        while (i >= 0 || k != 0 || carry >0) { // 这里必须是k != 0, 而不能是k >=0
            // k因为每次循环都会/10, 个位数会被抹去, 最终一定会回到0
            int val1 = i>= 0 ? num[i] : 0;
            int val2 = k % 10;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            res.add(sum % 10);
            i--;
            k /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
