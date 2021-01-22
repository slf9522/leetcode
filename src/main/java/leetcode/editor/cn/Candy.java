//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 示例 1: 
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2: 
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 333 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 1 3 4 5 2
 * 1 2 3 4 1
 */
public class Candy {
	public static void main(String[] args) {
		Solution solution = new Candy().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int candy(int[] ratings) {
			if (ratings.length == 0) {
				return 0;
			}
			int l = ratings.length;
			int[] candy = new int[l];

			for (int i = 0; i < l; i++) {
				if (i == 0) {
					candy[i] = 1;
					continue;
				}
				if (ratings[i - 1] < ratings[i]) {
					candy[i] = candy[i - 1] + 1;
				} else {
					candy[i] = 1;
				}
			}

			for (int i = l - 2; i >= 0; i--) {
				if (ratings[i] > ratings[i + 1]) {
					candy[i] = Math.max(candy[i], candy[i + 1] + 1);
				}
			}

			return Arrays.stream(candy).reduce((a, b) -> a + b).getAsInt();

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
