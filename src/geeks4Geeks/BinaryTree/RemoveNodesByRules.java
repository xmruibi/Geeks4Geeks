package geeks4Geeks.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveNodesByRules {

	/**
	 * Given a binary tree, a complete path is defined as a path from root to a
	 * leaf. The sum of all nodes on that path is defined as the sum of that
	 * path. Given a number K, you have to remove (prune the tree) all nodes
	 * which don’t lie in any path with sum>=k.
	 */
	// need bottom up
	static int sum = 0;

	private static Node removeProcess(Node root, int sum, int tarSum) {
		if (root == null)
			return null;
		int lsum = sum + root.val;
		int rsum = lsum;
		root.left = removeProcess(root.left, lsum, tarSum);
		root.right = removeProcess(root.right, rsum, tarSum);
		int curSum = Math.max(lsum, rsum);
		if (curSum < tarSum)
			return null;
		return root;
	}

	public static boolean isOnPath(Node node, int val, int curVal) {
		if (curVal >= val)
			return true;
		if (node == null && curVal < val)
			return false;

		boolean left = isOnPath(node.left, val, curVal + node.val);
		boolean right = isOnPath(node.right, val, curVal + node.val);

		if (left && right)
			return true;
		else if (!left && !right) {
			node.left = null;
			node.right = null;
			return false;
		} else {
			if (!left)
				node.left = null;
			else if(!right)
				node.right = null;
			return true;
		}

	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(1);
		Node n3 = new Node(1);
		Node n4 = new Node(1);
		Node n5 = new Node(1);
		Node n6 = new Node(1);
		Node n7 = new Node(1);
		Node n8 = new Node(1);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n6.right = n7;
		n7.left = n8;
		isOnPath(n1, 4, 0);
		printTree(n1);
	}

	private static void printTree(Node root) {
		Queue<Node> queue = new LinkedList<>();
		List<Character> row = new ArrayList<>();
		List<List<Character>> res = new ArrayList<>();
		queue.offer(root);
		int curLv = 1;
		int nxLv = 0;
		while (!queue.isEmpty()) {
			Node cur = queue.remove();
			curLv--;
			nxLv += 2;
			if (cur == null)
				row.add('#');
			else {
				row.add((char) (cur.val + '0'));
				if (cur.left != null)
					queue.offer(cur.left);
				else
					queue.offer(null);
				if (cur.right != null)
					queue.offer(cur.right);
				else
					queue.offer(null);
			}

			if (curLv == 0) {
				curLv = nxLv;
				nxLv = 0;
				res.add(new ArrayList<Character>(row));
				row = new ArrayList<>();
			}
		}
		for (List<Character> crow : res) {
			for (Character c : crow)
				System.out.print(c + " ");
			System.out.print("\n");
		}
	}

	private static class Node {
		int val;
		Node left, right;

		public Node(int val) {
			this.val = val;
		}
	}
}
