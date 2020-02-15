//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//
// 示例 1:
//
// 给定二叉树 [3,9,20,null,null,15,7]
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回 true 。
//
//示例 2:
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// 返回 false 。
//
//
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 思路：
// 1. 从顶向下递归
// 2. 从下向上递归，Time O(n)，关键是设置标志，表示访问过；提供两种写法
//    最后一种写法占用内存略大，因为类里还用到了成员变量。
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
    public int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));

    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    private int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        if (left == -1 || right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
class Solution {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return flag;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        if (Math.abs(right - left) > 1) flag = false;
        return Math.max(left, right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
