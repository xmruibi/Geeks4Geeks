package geeks4Geeks.BinaryTree;

import java.util.*;

public class FindNodeKDistanceFromLeaf {

	private static void findByLeaf(int k, TreeNode node, List<TreeNode> path,
			Set<TreeNode> res) {
		if (node == null)
			return;
		if (node.left == null && node.right == null && path.size() >= k) {
			res.add(path.get(path.size() - k));
			return;
		}
		path.add(node);
		findByLeaf(k, node.left, path, res);
		findByLeaf(k, node.right, path, res);
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		Set<TreeNode> res = new HashSet<>();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		findByLeaf(2, n1, new LinkedList<>(), res);
		for (TreeNode node : res)
			System.out.print(node.val + " ");
	}
}
