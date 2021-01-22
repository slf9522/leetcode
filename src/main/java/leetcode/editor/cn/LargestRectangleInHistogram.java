//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1101 👎 0


package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		Solution solution = new LargestRectangleInHistogram().new Solution();
		solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int largestRectangleArea(int[] heights) {

			int res = 0, l = heights.length;
			if (l == 0) {
				return res;
			}
			List<Integer> h = Arrays.stream(heights).boxed().collect(Collectors.toList());
			h.add(0);

			List<Pair<Integer, Integer>> pairs = new ArrayList<>();

			int i = 0;
			while (i < h.size()) {
				//栈顶
				if (pairs.size() == 0 || (pairs.size() > 0 && h.get(i) >= pairs.get(pairs.size() - 1).getValue())) {
					pairs.add(new Pair<>(i, h.get(i)));
					i++;
					continue;
				}

				Pair<Integer, Integer> top;
				while (pairs.size() > 0 && h.get(i) < pairs.get(pairs.size() - 1).getValue()) {
					top = pairs.get(pairs.size() - 1);
					int pi = -1, pv = 0;
					if (pairs.size() > 1) {
						Pair<Integer, Integer> pre = pairs.get(pairs.size() - 2);
						pi = pre.getKey();
					}
					int tmp = (i - (pi + 1)) * top.getValue();
					res = Math.max(res, tmp);

					// 移除top
					pairs.remove(pairs.size() - 1);
				}
				pairs.add(new Pair<>(i, h.get(i)));
				i++;
			}
			return res;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
