//给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
//
// 示例:
//
// 输入: "Hello World"
//输出: 5
//
// Related Topics 字符串



//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 1. 直接调java字符串操作api
// 2. 一个指针，String.charAt(i)遍历，注意java中""和''严格区分字符串与字符
// 补：注意特例，调用String.trim()
class Solution {
    public int lengthOfLastWord(String s) {
//        return s.length() - s.lastIndexOf(" ") - 1;
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}
//class Solution {
//    public int lengthOfLastWord(String s) {
//        s = s.trim();
//        int count = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (s.charAt(i) != ' ') count++;
//            else break;
//        }
//        return count;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
