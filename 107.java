//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Deque;
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
// 思路：利用队列进行层次遍历，类似104
// 用ArrayList.add(0, E)实现自底向上
class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        list.add(node.val);
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
      }
      res.add(0, list);
    }
    return res;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
