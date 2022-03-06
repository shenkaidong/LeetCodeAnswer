//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 
// 👍 11519 👎 500


//leetcode submit region begin(Prohibit modification and deletion)
// clarification
// 1. dose this string s could be empty?

// I will use string function replace to handle this issue.
// T O(n^2), S O(1) do not use extra space except an int number
class Solution {
    public boolean isValid(String s) {
        // the size must record. can't use s.length() in for loop
        // because it is variable after replace function
        // it also can divide by 2, not much different, so here just using size
        int size = s.length();
        for (int i = 0; i < size; i++) {
            // if we want to break when s is empty, we can check here
            if (s.contains("()")) {
                s = s.replace("()","");
            } else if (s.contains("[]")) {
                s = s.replace("[]","");
            } else if (s.contains("{}")) {
                s = s.replace("{}","");
            }
        }
        // just return empty is enough
        return s.isEmpty();
    }
}
// replaceAll time complexity is O(n), replace also T O(n)
//leetcode submit region end(Prohibit modification and deletion)
