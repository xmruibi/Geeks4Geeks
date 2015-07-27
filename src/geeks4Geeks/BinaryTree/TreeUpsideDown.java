package geeks4Geeks.BinaryTree;

public class TreeUpsideDown {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t4.left = t6;
		t4.right = t7;
		TreeNode node = upsideDown(t1);
		traversal(node);
	}

	private static TreeNode upsideDown(TreeNode root) {
		TreeNode node = root, parent = null, right = null;
		while (node != null) {
			TreeNode left = node.left;
			node.left = right;
			right = node.right;
			node.right = parent;
			parent = node;
			node = left;
		}
		return parent;
	}

	private static TreeNode upsideDown2(TreeNode root) {
		TreeNode node = root, parent = null, right = null;
		while(node!=null){
			TreeNode left = node.left;
			node.left = right;
			right = node.right;
			node.right = parent;
			parent = node;					
			node = left;
		}
		return parent;
	}

	private static void traversal(TreeNode root) {
		if (root == null)
			return;
		int val = root.val;

		traversal(root.left);
		System.out.print(val + "  ");
		traversal(root.right);
	}
}
