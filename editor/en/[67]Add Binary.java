//Given two binary strings a and b, return their sum as a binary string. 
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 104 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
// Related Topics Math String Bit Manipulation Simulation 
// 👍 4734 👎 524


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1; // 这里的i, 就是为了charAt准备的变量, 所以从char array的index-0开始
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {  //这里的carry不能等于0, 这样循环永远不会停止
            int val1 = i >= 0 ? a.charAt(i) - '0' : 0; // 这里一定不要忘记-0
            int val2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 2; // 求carry
            sb.append(sum % 2); // 取模
            i--; // 相当于for循环, 最后操作i
            j--;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
