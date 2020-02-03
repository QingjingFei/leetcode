//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//
// 你可以返回满足此条件的任何数组作为答案。
//
//
//
// 示例：
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000
//
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 双指针，交换。看看自己的代码！再看看别人的！学学！！！
// 自己版本
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int sep = 0;
        while (i < A.length) {
            if (A[i] % 2 != 0) {
                i++;
            } else {
                int tmp = A[sep];
                A[sep] = A[i];
                A[i] = tmp;
                sep++;
                i++;
            }
        }
        return A;
    }
}
// 别人版本
class Solution {
    public int[] sortArrayByParity(int[] A) {
        for (int pivot = 0, i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int tmp = A[pivot];
                A[pivot++] = A[i];
                A[i] = tmp;
            }
        }
        return A;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
