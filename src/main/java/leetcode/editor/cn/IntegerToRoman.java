//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: 3
//输出: "III" 
//
// 示例 2: 
//
// 输入: 4
//输出: "IV" 
//
// 示例 3: 
//
// 输入: 9
//输出: "IX" 
//
// 示例 4: 
//
// 输入: 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串 
// 👍 457 👎 0


package leetcode.editor.cn;

import java.util.*;

public class IntegerToRoman {
	public static void main(String[] args) {

		Solution solution = new IntegerToRoman().new Solution();
		solution.intToRoman(1994);

		List<Integer> stack = new ArrayList<>();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String intToRoman(int num) {
			TreeMap<Integer, String> dic = new TreeMap<>();
			dic.put(1, "I");
			dic.put(5, "V");
			dic.put(10, "X");
			dic.put(50, "L");
			dic.put(100, "C");
			dic.put(500, "D");
			dic.put(1000, "M");
			dic.put(4, "IV");
			dic.put(9, "IX");
			dic.put(40, "XL");
			dic.put(90, "XC");
			dic.put(400, "CD");
			dic.put(900, "CM");

			String out = "";
			while (num > 0) {
				Integer key = dic.floorKey(num);
				num -= key;
				out += dic.get(key);
			}
			return out;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
