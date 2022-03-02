//You are given an array prices where prices[i] is the price of a given stock on
// the ith day. 
//
// You want to maximize your profit by choosing a single day to buy one stock an
//d choosing a different day in the future to sell that stock. 
//
// Return the maximum profit you can achieve from this transaction. If you canno
//t achieve any profit, return 0. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must
// buy before you sell.
// 
//
// Example 2: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics Array Dynamic Programming 
// 👍 14617 👎 491


//leetcode submit region begin(Prohibit modification and deletion)
// T O(n), SO(1)
class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            // remember the minprice
            if (prices[i] < minprice) {
                minprice = prices[i];
                // remember the maxprofit by current prices - minprice;
            } else if (maxprofit < prices[i] - minprice) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
