//设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
//
// 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返
//回当前数据流中第K大的元素。
//
// 示例:
//
//
//int k = 3;
//int[] arr = [4,5,8,2];
//KthLargest kthLargest = new KthLargest(3, arr);
//kthLargest.add(3);   // returns 4
//kthLargest.add(5);   // returns 5
//kthLargest.add(10);  // returns 5
//kthLargest.add(9);   // returns 8
//kthLargest.add(4);   // returns 8
//
//
// 说明:
//你可以假设 nums 的长度≥ k-1 且k ≥ 1。
// Related Topics 堆


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 用大小为k的小顶堆，每来一个数字，与堆顶最小值进行比较：
// 若小于，不处理；若大于，删除堆顶元素，插入数字。
// 时间复杂度为nlogk
class KthLargest {
  final PriorityQueue<Integer> q;
  final int size;

  public KthLargest(int k, int[] nums) {
    size = k;
    q = new PriorityQueue<>(k);
    for (int i = 0; i < nums.length; i++) {
      add(nums[i]);
    }
  }

  public int add(int val) {
    if (q.size() < size) {
      q.offer(val);
    } else if (q.peek() < val) {
      q.poll();
      q.offer(val);
    }
    return q.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
