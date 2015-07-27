package geeks4Geeks.BinaryTree;


public class BuildTreeByPreorder {

	private static TreeNode buildTree(int[] arr, int l, int r) {
		if (l > r)
			return null;
		TreeNode root = new TreeNode(arr[l++]);
		int mid = l + ((r - l) >> 1);
		root.left = buildTree(arr, l, mid);
		root.right = buildTree(arr, mid + 1, r);
		return root;
	}

	
	
	public static void main(String[] args) {
		int[] arr = { 10, 5, 1, 7, 40, 50 };
		TreeNode res = buildTree(arr, 0, arr.length - 1);
		
	}
	private static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
