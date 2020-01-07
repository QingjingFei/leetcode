//给定一个二叉树，检查它是否是镜像对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
// 说明:
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
// Related Topics 树 深度优先搜索 广度优先搜索




//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.tree.TreeNode;

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
// 1. 递归，检查节点的左孩子是否等于节点的右孩子……
// 2. 用栈，代码又复杂，运行效率又低
//class Solution {
//    // 思路1
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        return isMirror(root.left, root.right);
//    }
//    public boolean isMirror(TreeNode p, TreeNode q) {
//        if (p == null && q == null) return true;
//        if (p == null && q == null) return false;
//        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
//    }
//}
class Solution {
    // 思路1
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
