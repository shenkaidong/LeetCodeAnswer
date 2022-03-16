//Given the root of a binary tree, determine if it is a valid binary search tree
// (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 9131 👎 863


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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBst;
    }

    private RT helper(TreeNode root) {
        if (root == null) {
            return new RT(Long.MAX_VALUE, Long.MIN_VALUE, true);
        }
        RT left = helper(root.left);
        RT right = helper(root.right);
        if (left.isBst && right.isBst && left.max < root.val && right.min > root.val) {
            return new RT(Math.min(left.min, root.val), Math.max(right.max, root.val), true);
        } else {
            return new RT(0, 0, false);
        }
    }

    private class RT {
        long min;
        long max;
        boolean isBst;
        RT(long min, long max, boolean isBst) {
            this.min = min;
            this.max = max;
            this.isBst = isBst;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
