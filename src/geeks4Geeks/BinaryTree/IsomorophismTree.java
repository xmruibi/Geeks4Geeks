package geeks4Geeks.BinaryTree;

public class IsomorophismTree {

	private static boolean checkIsomor(TreeNode node1, TreeNode node2) {
		if(node1==null&&node2==null)
			return true;
		if(node1==null||node2==null)
			return false;
		if(node1.val == node2.val)
			return checkIsomor(node1.left, node2.right)&&checkIsomor(node1.right, node2.left);
		else
			return false;
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode n2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode n3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode n4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n4.right = n5;
		
		r1.left = r3;
		r1.right = r2;
		r4.left = r5;
		r3.right = r4;
		System.out.println(checkIsomor(n1, r1));
	}
}
