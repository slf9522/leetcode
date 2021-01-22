//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 328 👎 0


package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		solution.zigzagLevelOrder(root);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}


	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */


	/**
	 * class Solution {
	 * public:
	 * vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
	 * vector<vector<int>> res;
	 * queue<TreeNode *> q;
	 * if (root) q.push(root);
	 * <p>
	 * bool lr = true;
	 * while (!q.empty()) {
	 * int size = q.size();
	 * vector<int> level(size, 0);
	 * while (size--) {
	 * root = q.front(); q.pop();
	 * level[lr ? level.size() - size - 1 : size] = root->val;
	 * if (root->left) q.push(root->left);
	 * if (root->right) q.push(root->right);
	 * }
	 * res.push_back(move(level));
	 * lr = !lr;
	 * }
	 * <p>
	 * return res;
	 * }
	 * };
	 */

	/**
	 * //  [3],
	 * //  [20,9],
	 * //  [15,7]
	 */
	class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> res = new ArrayList<>();
			if (root == null) {
				return res;
			}
			List<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			boolean right = false;

			while (queue.size() > 0) {
				int length = queue.size();
				Integer[] layer = new Integer[length];
				int tmp = length;
				while (length > 0) {
					TreeNode n = queue.remove(0);
					layer[right ? length - 1 : tmp - length] = n.val;
					if (n.left != null) queue.add(n.left);
					if (n.right != null) queue.add(n.right);
					length--;
				}
				right = !right;
				res.add(Arrays.asList(layer));
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
