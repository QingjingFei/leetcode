//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索




//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import org.javatuples.Pair;

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
// 1. 递归
// 2. 利用队列，BFS，记录层数，遍历完层数即为最大深度
// 3. 利用栈，DFS先序遍历（代码略麻烦）
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
//class Solution {
//    // add/remove/get是抛出异常的
//    // offer/poll/peek是返回特定值的
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.addLast(root);
//        int maxDepth = 0;
//        while (!queue.isEmpty()) {
//            maxDepth++;
//            int levelSize = queue.size();  // 一定要在此处用队列大小固定住for循环的次数！！！
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode node = queue.removeFirst();
//                if (node.left != null) {
//                    queue.addLast(node.left);
//                }
//                if (node.right != null) {
//                    queue.addLast(node.right);
//                }
//            }
//        }
//        return maxDepth;
//    }
//}
//class Solution {
//    // 此法leetcode不能通过！cannot find symbol Pair
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//        stack.push(new Pair<>(root, 1));
//        int maxDepth = 0;
//        while (!stack.isEmpth()) {
//            Pair<TreeNode, Integer> pair = stack.pop();
//            TreeNode node = pair.first;
//            maxDepth = Math.max(maxDepth, pair.second);
//            int curDepth = pair.second;
//            // 注意！！栈是先进后出，所以后面先进right再进left；
//            // 可以保证出栈为DFS先序遍历为中左右的自然顺序
//            if (node.right != null) {
//                stack.push(new Pair<>(node.right, curDepth + 1));
//            }
//            if (node.left != null) {
//                stack.push(new Pair<>(node.left, curDepth + 1));
//            }
//        }
//        return maxDepth;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
