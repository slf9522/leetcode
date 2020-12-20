//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2039 👎 0


package leetcode.editor.cn;

public class ContainerWithMostWater {
	public static void main(String[] args) {

	    Solution solution = new ContainerWithMostWater().new Solution();
        System.out.println(solution.maxArea(new int[]{2,3,10,5,7,8,9}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maxArea(int[] height) {
			int i = 0;
			int j = height.length - 1;
			int hi = height[i];
			int hj = height[j];
			int v = (j - i) * Math.min(hi, hj);


			while (i < j) {
				int ii = i + 1;
				int jj = j - 1;
				// 决定移动哪一边
				if (hi < hj) {
					if (height[ii] > hi) {
						int vt = Math.min(height[ii], hj) * (j - ii);
						v = Math.max(v, vt);
					}
					i = ii;
					hi = height[ii];
				} else {
					if (height[jj] > hj) {
						int vt = Math.min(height[jj], hi) * (jj - i);
						v = Math.max(v, vt);
					}
					j = jj;
					hj = height[jj];
				}
			}

			return v;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
