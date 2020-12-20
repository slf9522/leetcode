//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3463 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {

		Solution solution = new MedianOfTwoSortedArrays().new Solution();
		solution.findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22}, new int[]{0, 6});
	}

	// [1,2] [3,4] m=2,n=2 (2+2+1)/2=2 6/2=3
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int m = nums1.length;
			int n = nums2.length;
			int l = (m + n + 1) / 2;
			int r = (m + n + 2) / 2;

			int li = findK(nums1, nums2, l);
			int ri = findK(nums1, nums2, r);

			return (li + ri) / 2.0;
		}

		public int findK(int[] nums1, int[] nums2, int k) {
			if (nums1.length == 0) {
				return nums2[k - 1];
			}
			if (nums2.length == 0) {
				return nums1[k - 1];
			}

			if (k == 1) {
				return Math.min(nums1[0], nums2[0]);
			}

			int m = k / 2;
			int n = k - m;

			if (nums1.length < m) {
				m = nums1.length;
				n = k - m;
			}
			if (nums2.length < n) {
				n = nums2.length;
				m = k - n;
			}
			int i = nums1[m - 1];
			int j = nums2[n - 1];

			if (i < j) {
				return findK(Arrays.copyOfRange(nums1, m, nums1.length), nums2, k - m);
			} else if (i > j) {
				return findK(nums1, Arrays.copyOfRange(nums2, n, nums2.length), k - n);
			} else {
				return i;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
