//Given a binary tree, determine if it is height-balanced. 
//
// For this problem, a height-balanced binary tree is defined as: 
//
// 
// a binary tree in which the left and right subtrees of every node differ in he
//ight by no more than 1. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: true
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -104 <= Node.val <= 104 
// 
// Related Topics Tree Depth-First Search Binary Tree 
// 👍 5181 👎 286


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

    // clarification
    // 1. The return tpye should be boolean, isBalanced will return true, if not return false.
    // 1. If root == null then return true
class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private RT helper(TreeNode root) {
        if (root == null) return new RT(0, true);

        RT left = helper(root.left);
        RT right = helper(root.right);
        if (!left.isBalanced || !right.isBalanced || Math.abs(left.height - right.height) > 1) {
            return new RT(0, false);
        }
        // tree height need add root leave, so we need plus 1
        return new RT(Math.max(left.height, right.height) + 1, true);
    }

    private static class RT {
        int height;
        boolean isBalanced;
        RT(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
