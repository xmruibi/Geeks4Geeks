package geeks4Geeks.BinaryTree;

public class FoldTree {

	private static boolean isFolded(TreeNode node) {
		if(node==null)
				return true;
		makeMirror(node.left); // convert left node to mirror and check the structure with right node
		if (!sameStruct(node.left, node.right))
			return false;
		makeMirror(node.left);
		return true;
	}

	private static boolean sameStruct(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null)
			return true;
		if (n1 != null || n2 != null)
			return sameStruct(n1.left, n2.left)
					&& sameStruct(n1.right, n2.right);
		else
			return false;
	}

	private static void makeMirror(TreeNode node) {
		if (node == null)
			return;
		makeMirror(node.left);
		makeMirror(node.right);
		TreeNode tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}
}
