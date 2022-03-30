//Write an efficient algorithm that searches for a value target in an m x n inte
//ger matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics Array Binary Search Matrix 
// 👍 6661 👎 254


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0;
        int hi = m*n - 1;
        while (lo + 1 < hi) {
            int mid = (hi - lo)/2 + lo;
            if (matrix[mid/n][mid%n] == target) return true;
            if (matrix[mid/n][mid%n] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return matrix[lo/n][lo%n] == target || matrix[hi/n][hi%n] == target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
