package geeks4Geeks.BinaryTree;

public class LeavesCount {
	static int leafCount = 0;
	private static void countLeaves(TreeNode root) {
		if(root==null)
			return;
		if(root.left==null&&root.right==null){
			leafCount++;
			return;
		}
		countLeaves(root.left);
		countLeaves(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(0);
		TreeNode node2 = new TreeNode(0);
		TreeNode node3 = new TreeNode(0);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(0);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		countLeaves(root);
		System.out.println(leafCount);
	}
}
