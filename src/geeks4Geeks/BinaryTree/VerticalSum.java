package geeks4Geeks.BinaryTree;

import java.util.*;

public class VerticalSum {

	private void verticalSum(Node root) {
		Map<Integer, Integer> line = new HashMap<>();
		sumHelper(root, 0, line);
		if(!line.isEmpty())
			System.out.println(line.entrySet());
	}

	private void sumHelper(Node node, int hD, Map<Integer, Integer> line) {
		if(node==null)
			return;
		sumHelper(node.left, hD-1, line);
		line.put(hD, line.containsKey(hD)?line.get(hD):1);
		sumHelper(node.right, hD+1, line);
	}

	private class Node {
		int val;
		Node left, right;

		public Node(int val) {
			this.val = val;
		}
	}
}
