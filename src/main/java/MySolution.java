import java.util.*;

class MySolution {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int res = dp[0];
		// 以i结尾的连续子数组最大值
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	// 0 1 3
	public static int missingNumber(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int mid = (i + j) / 2;

			if (mid == nums[mid]) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return i;
	}

	// "abcabcbb"
	public static int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0;
		Map<String, Integer> charSet = new HashMap<>();
		int res = 1;

		while (j < s.length()) {
			if (i > j) {
				j = i;
			}
			String ss = String.valueOf(s.charAt(j));
			if (charSet.containsKey(ss)) {
				int index = charSet.get(ss);
				while (i < index + 1) {
					charSet.remove(String.valueOf(s.charAt(i)));
					i++;
				}
			}
			charSet.put(ss, j);
			j++;
			res = Math.max(j - i, res);
		}
		return res;
	}

	public static int search(int[] nums, int mid) {
		return Arrays.binarySearch(nums, mid);
	}

	public static void moveZeroes(int[] nums) {
		int i = 0, j = 0;
		while (i < nums.length) {
			if(nums[i] != 0){
				nums[j++] = nums[i];
			}
			i++;
		}
		while(j<nums.length){
			nums[j++] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Click HELP above to see examples of handling input/debug/output
		// INPUT: int n = in.nextInt();
		// DEBUG: System.out.println(n);
		// OUTPUT: System.out.println(result);

		// Write the code to solve the problem below,
		// format the "result" as specified in the problem statement
		// and finally, write the result to stdout
		// IMPORTANT: Remove all debug statements for final submission
		int n = in.nextInt();
		String out = "";
		while(n>=0){
			int j = n%1000;
			if(out == ""){
				out = String.valueOf(j);
			} else {
				out = String.valueOf(j) + "," + out;
			}
			n = n/1000;
		}
		System.out.println(out);
	}

}