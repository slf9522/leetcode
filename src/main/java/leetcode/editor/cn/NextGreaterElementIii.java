//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 字符串 
// 👍 118 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class NextGreaterElementIii {
	public static void main(String[] args) {
		Solution solution = new NextGreaterElementIii().new Solution();
		solution.nextGreaterElement(121);
	}

	// 下一个最大元素/最大排列
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int nextGreaterElement(int n) {
			char[] reOrder = String.valueOf(n).toCharArray();
			Deque<Integer> 

		}


	}
//leetcode submit region end(Prohibit modification and deletion)

}
