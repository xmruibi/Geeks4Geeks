package geeks4Geeks.BinaryTree;

import java.util.*;

public class checkSubtree {

	private static void inorder(TreeNode node, List<Integer> inorder) {
		if (node == null)
			return;
		inorder(node.left, inorder);
		inorder.add(node.val);
		inorder(node.right, inorder);
	}

	private static void preorder(TreeNode node, List<Integer> preorder) {
		if (node == null)
			return;
		preorder.add(node.val);
		preorder(node.left, preorder);
		preorder(node.right, preorder);
	}

	private static boolean checkSublist(List<Integer> list,
			List<Integer> sublist) {
		int subidx = 0;
		for (int i = 0; i < list.size(); i++) {
			int cur = i;
			while (list.get(cur++) == sublist.get(subidx++))
				if (subidx == (sublist.size() - 1))
					return true;
			subidx = 0;
		}
		return false;
	}

	private static boolean checkSubtree(TreeNode tree, TreeNode subtree) {
		if (tree == null)
			return false;
		List<Integer> inorder = new ArrayList<>();
		inorder(tree, inorder);
		List<Integer> preorder = new ArrayList<>();
		preorder(tree, preorder);
		List<Integer> subinorder = new ArrayList<>();
		inorder(subtree, subinorder);
		List<Integer> subpreorder = new ArrayList<>();
		preorder(subtree, subpreorder);
		if(checkSublist(preorder, subpreorder)&&checkSublist(inorder, subinorder))
			return true;
		return false;	
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
		TreeNode n11 = new TreeNode(11);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n6;
		n5.right = n7;
		n3.left = n8;
		
		n9.left = n10;
		n9.right = n11;
		
		System.out.println(checkSubtree(n1, n9));
		
	}
}
