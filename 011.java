//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
// 示例:
//
// 输入: [1,8,6,2,5,4,8,3,7]
//输出: 49
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
// 主流解法：双指针夹逼遍历所有可能的组合并计算面积
// class Solution {
//     public int maxArea(int[] height) {
//         int maxArea = 0;
//         for (int i = 0, j = height.length - 1; i < j; ) {
//             maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
//             if (height[i] < height[j]) i++;
//             else j--;
//         }
//         return maxArea;
//     }
// }
// 效率改进版
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            int k = 1;
            if (height[i] < height[j]) {
                while (height[i] > height[i+k]) k++;
                i += k;
//                while (i < j && height[i] > height[++i]);  // 此写法私以为逻辑有漏洞
            }
            else {
                while (height[j] > height[j-k]) k++;
                j -= k;
//                while (i < j && height[j] > height[--j]);  // 此写法私以为逻辑有漏洞
            }
        }
        return maxArea;
    }
}
// 写法改进版
//class Solution {
//    public int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0, j = height.length - 1; i < j; ) {
//            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
//            int area = (j - i + 1) * minHeight;
//            max = Math.max(max, area);
//        }
//        return max;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
