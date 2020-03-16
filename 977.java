//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
//
//
//
// 示例 1：
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//
//
// 示例 2：
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 10000
// -10000 <= A[i] <= 10000
// A 已按非递减顺序排序。
//
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 1. 头尾双指针夹逼
//    注意：若写成for (int i = 0, j = n - 1; i < j; )就错了！！必须是i <= j
class Solution {
  public int[] sortedSquares(int[] A) {
    int n = A.length;
    int[] res = new int[n];
    int k = n - 1;
    for (int i = 0, j = n - 1; i <= j; ) {
      if (Math.abs(A[i]) < Math.abs(A[j])) {
        res[k--] = A[j] * A[j];
        j--;
      } else {
        res[k--] = A[i] * A[i];
        i++;
      }
    }
    return res;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
