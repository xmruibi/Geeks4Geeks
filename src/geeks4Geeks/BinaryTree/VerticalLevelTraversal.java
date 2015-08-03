package geeks4Geeks.BinaryTree;

import java.util.*;

public class VerticalLevelTraversal {

	private static void printNodeVertical(int hd, TreeNode node,
			Map<Integer, List<TreeNode>> res) {
		if(node==null)
			return;
		List<TreeNode> list = res.containsKey(hd) ? res.get(hd)
				: new ArrayList<TreeNode>();
		list.add(node);
		res.put(hd, list);
		printNodeVertical(hd - 1, node.left, res);
		printNodeVertical(hd + 1, node.right, res);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		Map<Integer, List<TreeNode>> res = new HashMap<>();
		printNodeVertical(0, n1, res);
		for (Map.Entry<Integer, List<TreeNode>> entry : res.entrySet()) {
			for(TreeNode node :entry.getValue())
				System.out.print(node.val+" ");
		}
	}

}
