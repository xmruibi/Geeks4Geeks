package geeks4Geeks.BinaryTree;

public class RemoveTreeNodeOutofRange {

	private static TreeNode removeOutofRange(TreeNode root, int min, int max) {
		if(root == null)
			return null;
		root.left = removeOutofRange(root.left, min, max);
		root.right = removeOutofRange(root.right, min, max);		
		
		if(root.val<min){
			TreeNode tmp = root.right;
			root = null;
			return tmp;
		}
		if(root.val>max){
			TreeNode tmp = root.left;
			root = null;
			return tmp;
		}
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(-1);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		TreeNode newnode = removeOutofRange(root, 0, 4);
	}
}
