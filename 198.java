//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
//
// 示例 1:
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 2:
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//
// Related Topics 动态规划




//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 1. 递归 —— Time Limit Exceeded
// 2. 递归 + memo（从顶向下）
// 3. 迭代 + memo（从底向上）
// 4. 迭代 + 2变量记录（从底向上）
//class Solution {
//    public int rob(int[] nums) {
//        return rob(nums, nums.length - 1);
//    }
//
//    private int rob(int[] nums, int i) {
//        if (i < 0) return 0;
//        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
//    }
//}
//class Solution {
//    int[] memo;
//    public int rob(int[] nums) {
//        memo = new int[nums.length + 1];
//        Arrays.fill(memo, -1);
//        return rob(nums, nums.length - 1);
//    }
//
//    private int rob(int[] nums, int i) {
//        if (i < 0) return 0;
//        if (memo[i] >= 0) return memo[i];
//        int res = Math.max(rob(nums, i -2) + nums[i], rob(nums, i - 1));
//        memo[i] = res;
//        return res;
//    }
//}
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n == 0 ? 0 : nums[0];
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++)
            memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
        return memo[n - 1];
    }
}
//class Solution {
//    public int rob (int[] nums) {
//        if (nums.length == 0) return 0;
//        int prev1 = 0;
//        int prev2 = 0;
//        for (int num : nums) {
//            int tmp = prev1;
//            prev1 = Math.max(prev2 + num, prev1);
//            prev2 = tmp;
//        }
//        return prev1;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
