//给定一个整数数组，判断是否存在重复元素。
//
// 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
//
// 示例 1:
//
// 输入: [1,2,3,1]
//输出: true
//
// 示例 2:
//
// 输入: [1,2,3,4]
//输出: false
//
// 示例 3:
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true
// Related Topics 数组 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 1. map映射，nums[i]作key，i作value
// 2. 用集合去重，看长度是否变化。
//    没想到的是直接Hashset(Arrays.asList(int[]))用size()方法会报错！
//    打印查看了一下，set内放的是数组的内存地址！！
//    注意：对于int[]数组不能直接这样做，因为asList()方法的参数必须是对象。
//    应该先把int[]转化为Integer[]。
//    对于其他primitive类型的数组也是如此，必须先转换成相应的wrapper类型数组。
//    参考：https://www.cnblogs.com/annieBaby/p/4889406.html
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.put(nums[i], i) != null)
                return true;
        }
        return false;
    }
}
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // if (nums.length == 0) return false;
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Integer integer = nums[i];
            array[i] = integer;
        }
        List list = Arrays.asList(array);
        Set set = new HashSet(list);
        System.out.println(set);
        System.out.println(set.size());
        if (nums.length == set.size()) return false;
        else return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
