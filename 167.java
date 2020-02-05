//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//
// 说明:
//
//
// 返回的下标值（index1 和 index2）不是从零开始的。
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
//
//
// 示例:
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
// Related Topics 数组 双指针 二分查找


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
// 思路：（类似题001，区别是数组变为有序）
// 1. 两层循环 Time O(n^2), Space O(1)
// 2. HashMap Time O(n), Space O(n)
// 3. 头尾双指针一遍循环 Time O(n), Space O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
                if (numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }
        return new int[0];
    }
}
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i ++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i + 1};
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return new int[-1];
    }
}
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
