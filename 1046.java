//有一堆石头，每块石头的重量都是正整数。
//
// 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//
//
// 如果 x == y，那么两块石头都会被完全粉碎；
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
//
//
// 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
//
//
//
// 提示：
//
//
// 1 <= stones.length <= 30
// 1 <= stones[i] <= 1000
//
// Related Topics 堆 贪心算法


import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 1. 数组
// 2. 大顶堆
// 数组的时间复杂度要大于大顶堆，但这一题的数据规模小，运行上反而是数组耗时更短。
class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        for (int i=stones.length-1; i>0; i--) {
            if (stones[i] == stones[i-1]) {
                if (i-1 > 0)
                    i -= 1;
                else
                    return 0;
            }
            else
                stones[i-1] = stones[i] - stones[i-1];
            Arrays.sort(stones);
        }
        return stones[0];
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);  // lambda表达式
//        Queue<Integer> maxPq = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
//        Queue<Integer> maxPq = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for (int stone : stones) {
            maxPq.offer(stone);
        }
        while (maxPq.size() > 1) {
            maxPq.offer(maxPq.poll() - maxPq.poll());
        }
        return maxPq.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
