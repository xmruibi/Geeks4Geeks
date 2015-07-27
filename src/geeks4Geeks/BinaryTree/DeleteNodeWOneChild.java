package geeks4Geeks.BinaryTree;

import java.util.*;

public class DeleteNodeWOneChild {

	private static void deleteNode(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		HashMap<TreeNode, TreeNode> checkParent = new HashMap<>();
		while (!queue.isEmpty()) {
			TreeNode cur = queue.remove();
			if (cur.left != null && cur.right != null) {
				queue.offer(cur.left);
				queue.offer(cur.right);
				checkParent.put(cur.left, cur);
				checkParent.put(cur.right, cur);
			} else if ((cur.left != null || cur.right != null)
					&& checkParent.containsKey(cur)) {
				TreeNode parent = checkParent.get(cur);
				if (parent.left == cur) {
					parent.left = cur.left != null ? cur.left : cur.right;
				} else
					parent.right = cur.left != null ? cur.left : cur.right;
				checkParent
						.put(cur.left != null ? cur.left : cur.right, parent);
				queue.offer(cur.left != null ? cur.left : cur.right);
			}
		}
	}
	
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1); 
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2; n1.right = n3; n2.left = n4; n3.right = n5; n4.left = n6;
		deleteNode(n1);
		TreeNode node = n1;
		
	}
}
