//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 1. 暴力法，时间复杂度O(n^2)，空间复杂度O(1)
// 2. 两遍哈希法，一遍存map一遍查map返回解，时间复杂度O(n)，空间复杂度O(n)
// 3. 一遍哈希法，查map中没有则存map，若有则返回解，时间复杂度O(n)，空间复杂度O(n)
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i])
//                    return new int[] {i, j};
//            }
//        }
////        return new int[] {-1};
//        throw new IllegalArgumentException("No two sum solution");
//    }
//}
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++)
//            map.put(nums[i], i);
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i)
//                return new int[] {i, map.get(complement)};
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
//        // 阿里java规范推荐的哈希的初始化
//        // 建议：
//        // 所有集合类的问题 如果能预估到准确的取值范围 直接规定好了 是最节省开销 也最高效的解决问题方案了
//        Map<Integer, Integer> map = new HashMap<>((int) ((float) nums.length / 0.75F + 1.0F));
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[] {map.get(complement), i};  // 这里i放在后面了，解法2是放在前面的，很有意思的细节
            else
                map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
