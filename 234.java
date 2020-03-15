//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 思路：
// 1. 快慢指针+翻转，快，但改变了原链表
// 2. 栈，慢，但不改变原链表
class Solution {
  public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if (fast != null) {  // odd nodes: let right half smaller
      slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;

    while (slow != null) {  // 思考为什么这里不是 while(fast!=null)！
      if (fast.val != slow.val) return false;
      fast = fast.next;
      slow = slow.next;
    }
    return true;
  }

  public ListNode reverse(ListNode head) {
    ListNode pre = null;

    while (head != null) {
      ListNode node = head.next;
      head.next = pre;
      pre = head;
      head = node;
    }
    return pre;
  }
}

class Solution {
  public boolean isPalindrome(ListNode head) {
    LinkedList<Integer> stack = new LinkedList<>();
    ListNode node = head;
    while (head != null) {
      stack.push(head.val);
      head = head.next;
    }
    while (node != null) {
      if (node.val != stack.peek()) return false;
      stack.pop();
      node = node.next;
    }
    return true;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
