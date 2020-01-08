//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
//
// 注意你不能在买入股票前卖出股票。
//
// 示例 1:
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
//
//
// 示例 2:
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
// Related Topics 数组 动态规划




//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 1. 暴力法，两层嵌套循环O(n^2)
// 2. 一次遍历法，两个变量minPrice和maxProfit，求"迄今为止"价格与波谷的最大利润，最快！
// 3. 一次遍历法，（Kadane's Algorithm）求差问题等价于区间和问题，两个变量maxCur和maxSofar
//class Solution {
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                int profit = prices[j] - prices[i];
//                if (profit > maxProfit)
//                    maxProfit = profit;
//            }
//        }
//        return maxProfit;
//    }
//}
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i ++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
//class Solution {
//    public int maxProfit(int[] prices) {
//        int maxCur = 0, maxSofar = 0;
//        for (int i = 1; i < prices.length; i++) {
//            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
//            maxSofar = Math.max(maxSofar, maxCur);
//        }
//        return maxSofar;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
