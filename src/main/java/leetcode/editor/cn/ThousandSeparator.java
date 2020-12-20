//给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。 
//
// 
//
// 示例 1： 
//
// 输入：n = 987
//输出："987"
// 
//
// 示例 2： 
//
// 输入：n = 1234
//输出："1.234"
// 
//
// 示例 3： 
//
// 输入：n = 123456789
//输出："123.456.789"
// 
//
// 示例 4： 
//
// 输入：n = 0
//输出："0"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n < 2^31 
// 
// Related Topics 字符串 
// 👍 4 👎 0


package leetcode.editor.cn;
public class ThousandSeparator {
    public static void main(String[] args) {
        Solution solution = new ThousandSeparator().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String thousandSeparator(int n) {
        StringBuffer sb = new StringBuffer(String.valueOf(n));
        for (int i = sb.length() - 3; i > 0; i -= 3) sb.insert(i, '.');
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
