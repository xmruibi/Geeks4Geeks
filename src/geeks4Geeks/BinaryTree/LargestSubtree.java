package geeks4Geeks.BinaryTree;

public class LargestSubtree {

	static int sum = 0;
	private static int findMaxSubtree(TreeNode root) {
			if(root==null)
				return 0;
			int left = findMaxSubtree(root.left);
			int right = findMaxSubtree(root.right);
			int curSum = root.val+left+right;
			sum = Math.max(curSum, sum);
			return curSum;
	}
	private static int findMaxSubtreeSize(TreeNode root) {
		if(root ==null)
			return 0;
		int leftsize = findMaxSubtreeSize(root.left);
		int rightsize = findMaxSubtreeSize(root.right);
		int curSize = 1+leftsize + rightsize;
		return curSize;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(-5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		findMaxSubtree(root);
		System.out.println(sum);
	}
}
