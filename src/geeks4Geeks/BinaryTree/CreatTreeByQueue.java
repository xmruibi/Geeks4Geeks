package geeks4Geeks.BinaryTree;

import java.util.*;

public class CreatTreeByQueue {

	private static Node create(LinkedList<Node> list) {
		Queue<Node> tmp = new LinkedList<>();
		tmp.offer(list.remove());
		Node root = tmp.peek();
		while (!tmp.isEmpty()) {
			Node cur = tmp.remove();
			if (cur.left == null && !list.isEmpty()) {
				Node left = list.remove();
				cur.left = left;
				tmp.offer(left);
			}
			if (cur.right == null && !list.isEmpty()) {
				Node right = list.remove();
				cur.right = right;
				tmp.offer(right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		LinkedList<Node> list = new LinkedList<>();
		for (int i = 0; i < 10; i++)
			list.add(new Node(i));
		Node root = create(list);
		printTree(root);
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
