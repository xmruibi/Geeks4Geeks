package geeks4Geeks.BinaryTree;

public class TreeSize {
	private static int size = 0;
	private static int countSize(TreeNode root) {
			if(root==null)
				return size;
			size++;
			countSize(root.left);
			countSize(root.right);
			return size;
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
		System.out.println(countSize(root));
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
	}
}
