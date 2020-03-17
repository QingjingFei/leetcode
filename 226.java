//翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// 输出：
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// 备注:
//这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)

import apple.laf.JRSUIUtils;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;

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
// 2. 只要是递归，深度太深就存在程序调用栈溢出的风险；
//    只要是递归，就可以用栈解决。
// 3. 队列
// 注意：本题的栈和队列仅用作临时存储容器，出栈和出队列顺序并不影响left与right指针。
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
/*
出栈顺序是：4, 2, 1, 3, 7, 6, 9
但出栈顺序并不影响最终root的left与right指针指向。
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return root;
    }
}
/*
出队列顺序是：4, 7, 3, 9, 6, 3, 1
但出队列顺序并不影响最终root的left与right指针指向。
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
