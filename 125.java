//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串



//leetcode submit region begin(Prohibit modification and deletion)
// 思路：
// 1. 自顶向下业务逻辑编程示例
// 2. 双指针法
//class Solution {
//    public boolean isPalindrome(String s) {
//        // 自顶向下编程
//        // 1. filter out number & char; 2. reverse; 3. compare
//        String _filteredS = _filterNonNumberAndChar(s);
//
//        String _reversedS = _reverseString(_filteredS);
//
//        return _reversedS.equalsIgnoreCase(_filteredS);
//    }
//
//    private String _reverseString(String s) {
//        return new StringBuilder(s).reverse().toString();
//    }
//
//    private String _filterNonNumberAndChar(String s) {
//        return s.replaceAll("[^A-Za-z0-9]", "");
//    }
//}
//class Solution {
//    public boolean isPalindrome(String s) {
//        String actual = s.replaceAll("[A-Za-z0-9]", "").toLowerCase();
//        String rev = new StringBuilder(s).reverse().toString();
//        return actual.equals(rev);
//    }
//}
class Solution {
    // 方法2：双指针法
    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(c[i])) i++;
            else if (!Character.isLetterOrDigit(c[j])) j--;
            else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--]))
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
