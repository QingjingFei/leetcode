//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 1. 模拟按位进行的加法运算
// 2. 遵题目要求筛减可能性
class Solution {
  public int[] plusOne(int[] digits) {
    int n = digits.length;
    int[] sum = new int[n+1] ;
    int carry = 0;
    for (int i = n - 1; i >= 0; i--) {
      int digit = 0;
      if (i == n - 1) {
        digit = digits[i] + 1;
      }   else {
        digit = digits[i] + carry;
      }
      if (digit >= 10) {
        carry = 1;
        digit = digit - 10;
      } else {
        carry = 0;
      }
      sum[i+1] = digit;
    }
    if(carry == 1) sum[0] = 1;
    else {
      int[] shortSum = new int[n];
      for(int i = 1; i < sum.length; i++)
        shortSum[i - 1] = sum[i];
      return shortSum;
    }
    return sum;
  }
}

class Solution {
  // 巧妙，记住题目仅要求加1！
  // 按位加一只要取余不为零即可返回
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i]++;
      digits[i] = digits[i] % 10;
      if (digits[i] != 0) return digits;
    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
