//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// Related Topics 数组


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 1. 递归，Time O(numRows^2) and Space O(numRows^2)，递归的时间复杂度要推导
// 2. 迭代，Time O(numRows^2) and Space O(numRows^2)
// 3. 错一位再逐个相加
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) return triangle;
        if (numRows == 1) {
            triangle.add(new ArrayList<>());
            triangle.get(0).add(1);
            return triangle;
        }
        triangle = generate(numRows - 1);
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            row.add(triangle.get(numRows-2).get(i-1)+triangle.get(numRows-2).get(i));
        }
        row.add(1);
        triangle.add(row);
        return triangle;
    }
}
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            result.add(list);
        }
        return result;
    }
}
class Solution {
    public List<List<Integer>> generate(int numRows) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
