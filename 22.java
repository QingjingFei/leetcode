//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为：
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
// Related Topics 字符串 回溯算法


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
// 思路：递归+优化（括号合法性）
// 1. 记录尚未使用的left括号和right括号个数，仅当right>left时才可添加")"
// 2. 记录已使用的left括号和right括号个数，仅当right<left时才可添加")"
//class Solution {
//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<>();
//        generateOneByOne("", res, n, n);
//        return res;
//    }
//
//    public void generateOneByOne(String sublist, List<String> res, int left, int right) {
//        if (left == 0 && right == 0) {
//            res.add(sublist);
//            return;
//        }
//        if (left > 0) {
//            generateOneByOne(sublist + "(", res, left - 1, right);
//        }
//        if (right > left) {
//            generateOneByOne(sublist + ")", res, left, right - 1);
//        }
//    }
//}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }

    public void helper(List<String> res, String str, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        if (left < n) {
            helper(res, str + "(", left + 1, right, n);
        }
        if (right < left) {
            helper(res, str + ")", left, right + 1, n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
