//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2386 👎 0


package leetcode.editor.cn;

public class ReverseInteger {
	public static void main(String[] args) {
		Solution solution = new ReverseInteger().new Solution();
		solution.reverse(-123);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int reverse(int x) {
			int res;
			StringBuffer sb = new StringBuffer();
			String s = String.valueOf(x);

			char pre = s.charAt(0);
			if (s.charAt(0) == '+' || s.charAt(0) == '-') {
				s = s.substring(1, s.length());
			}
			String reverse = new StringBuffer(s).reverse().toString();
			int i = 0;
			while (reverse.charAt(i) == '0') {
				i++;
			}

			try {
				if (pre == '+' || pre == '-') {
					res = Integer.parseInt(pre + reverse.substring(i, reverse.length()));
				} else {
					res = Integer.parseInt(reverse.substring(i, reverse.length()));
				}
			} catch (NumberFormatException e) {
				res = 0;
			}

			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
