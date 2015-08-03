package geeks4Geeks.BinaryTree;


import java.util.*;

public class CheckIfLevesAllLevel {

	static int lLvl = 0;

	private static boolean checkLeves(Node root, int curLvl) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			if (lLvl == 0) {
				lLvl = curLvl;
				return true;
			} else
				return curLvl == lLvl;

		return checkLeves(root.left, curLvl + 1)
				&& checkLeves(root.right, curLvl + 1);
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
		Node n9 = new Node(1);
		Node n10 = new Node(1);
		Node n11 = new Node(1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n6.right = n7;
		n7.left = n8;
		System.out.println(checkLeves(n1, 0));
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
			nxLv+=2;
			if (cur == null)
				row.add('#');
			else {
				row.add((char) (cur.val+'0'));
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
