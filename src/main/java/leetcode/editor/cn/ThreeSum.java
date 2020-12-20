//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2812 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
	public static void main(String[] args) {
		Solution solution = new ThreeSum().new Solution();
		System.out.println(solution.threeSum(new int[]{0, 0, 0, 0}));

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			int i = 0;
			Arrays.sort(nums);
			Set<List<Integer>> res = new HashSet<>();
			while (i <= nums.length - 3) {
				List<Integer> r = new ArrayList<>();
				find(i, nums, res);
				i++;
			}

			return new ArrayList<>(res);
		}

		private void find(int i, int[] nums, Set<List<Integer>> res) {
			int t = -nums[i];
			int r = nums.length - 1;
			while (r > i + 1) {
				int index = Arrays.binarySearch(nums, i + 1, r, t - nums[r]);
				if (index >= 0 && nums[index] == t - nums[r]) {
					res.add(Arrays.asList(nums[i], nums[index], nums[r]));
				}
				r--;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
