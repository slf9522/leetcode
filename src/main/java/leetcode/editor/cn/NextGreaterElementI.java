//给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个
//比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
//    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
//    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。 
//
// 示例 2: 
//
// 输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// nums1和nums2中所有元素是唯一的。 
// nums1和nums2 的数组大小都不超过1000。 
// 
// Related Topics 栈 
// 👍 337 👎 0


package leetcode.editor.cn;

import java.util.*;

public class NextGreaterElementI {
	public static void main(String[] args) {
		Solution solution = new NextGreaterElementI().new Solution();
		int[] nums2 = new int[]{137, 59, 92, 122, 52, 131, 79, 236, 94, 171, 141, 86, 169, 199, 248, 120, 196, 168, 77, 71, 5, 198, 215, 230, 176, 87, 189, 206, 115, 76, 13, 216, 197, 26, 183, 54, 250, 27, 109, 140, 147, 25, 96, 105, 30, 207, 241, 8, 217, 40, 0, 35, 221, 191, 83, 132, 9, 144, 12, 91, 175, 65, 170, 149, 174, 82, 102, 167, 62, 70, 44, 143, 10, 153, 160, 142, 188, 81, 146, 212, 15, 162, 103, 163, 123, 48, 245, 116, 192, 14, 211, 126, 63, 180, 88, 155, 224, 148, 134, 158, 119, 165, 130, 112, 166, 93, 125, 1, 11, 208, 150, 100, 106, 194, 124, 2, 184, 75, 113, 104, 18, 210, 202, 111, 84, 223, 173, 238, 41, 33, 154, 47, 244, 232, 249, 60, 164, 227, 253, 56, 157, 99, 179, 6, 203, 110, 127, 152, 252, 55, 185, 73, 67, 219, 22, 156, 118, 234, 37, 193, 90, 187, 181, 23, 220, 72, 255, 58, 204, 7, 107, 239, 42, 139, 159, 95, 45, 242, 145, 172, 209, 121, 24, 21, 218, 246, 49, 46, 243, 178, 64, 161, 117, 20, 214, 17, 114, 69, 182, 85, 229, 32, 129, 29, 226, 136, 39, 36, 233, 43, 240, 254, 57, 251, 78, 51, 195, 98, 205, 108, 61, 66, 16, 213, 19, 68, 237, 190, 3, 200, 133, 80, 177, 97, 74, 138, 38, 235, 135, 186, 89, 201, 4, 101, 151, 31, 228, 231, 34, 225, 28, 222, 128, 53, 50, 247};
		solution.nextGreaterElement(new int[]{59}, nums2);

	}


	// 如何维持一个单调递减栈
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] nextGreaterElement(int[] nums1, int[] nums2) {
			Map<Integer, Integer> dict = new HashMap<>();
			Deque<Integer> stack = new LinkedList<>();
			stack.add(nums2[0]);

			for (int i = 1; i < nums2.length; i++) {
				int tmp = nums2[i];
				while (stack.size() > 0) {
					if (stack.getLast() < tmp) {
						dict.putIfAbsent(stack.pollLast(), tmp);
					} else {
						break;
					}
				}
				stack.add(tmp);
			}

			int[] res = new int[nums1.length];
			for (int i = 0; i < nums1.length; i++) {
				res[i] = dict.getOrDefault(nums1[i], -1);
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
