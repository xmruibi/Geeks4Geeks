package geeks4Geeks.BinaryTree;

public class FindDistanceBetweenTwoNodes {

	private static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || node1 == root || node2 == root)
			return root;
		TreeNode left = findLCA(root.left, node1, node2);
		TreeNode right = findLCA(root.right, node1, node2);

		if (left != null && right != null)
			return root;
		else
			return left != null ? left : right;
	}

	private static int getNodeHeight(TreeNode root, TreeNode node, int height) {
		if (root == null)
			return 0;
		if (root == node)
			return height;
		int left = getNodeHeight(root.left, node, height+1);
		if(left!=0)
			return left;
		return getNodeHeight(root.right, node, height+1);				
	}

	private static int getDist(TreeNode root, TreeNode node1, TreeNode node2) {
		TreeNode lca = findLCA(root, node1, node2);
		int lcaH = getNodeHeight(root, lca, 0);
		int n1H = getNodeHeight(root, node1, 0);
		int n2H = getNodeHeight(root, node2, 0);
		return n1H+n2H - 2*lcaH;
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);

		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n4.right = n5;

		System.out.println(getDist(n1, n2, n5));
		
	}
}
