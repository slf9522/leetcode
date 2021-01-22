//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 246 👎 0


package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

public class NextGreaterElementIi {
	public static void main(String[] args) {

		Solution solution = new NextGreaterElementIi().new Solution();
		int[] nums = new int[]{};
		System.out.println(solution.nextGreaterElements(nums));

	}

	// 循环数组 + 重复元素
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] nextGreaterElements(int[] nums) {
			int[] res = new int[nums.length];
			Arrays.fill(res, -1);
			if (nums.length == 0){
				return res;
			}
//			index:value
			Deque<Pair<Integer, Integer>> stack = new LinkedList<>();
			stack.add(new Pair<>(0, nums[0]));

			for (int i = 1; i < nums.length * 2; i++) {
				int ii = i % nums.length;
				int tmp = nums[ii];
				while (stack.size() > 0 && stack.getLast().getValue() < tmp) {
					Pair<Integer, Integer> last = stack.pollLast();
					if (last.getKey() < nums.length) {
						res[last.getKey()] = tmp;
					}
				}
				stack.add(new Pair<>(ii, tmp));
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
