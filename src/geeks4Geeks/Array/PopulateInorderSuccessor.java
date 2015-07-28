package geeks4Geeks.Array;

import java.util.Stack;

public class PopulateInorderSuccessor {

	private static void populate(Node root) {
		Stack<Node> stack = new Stack<>();
		do {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			Node pop = stack.pop();
			if (pop.right != null) {
				Node mostLeft = pop.right;
				while (mostLeft != null){
					stack.push(mostLeft);
					mostLeft = mostLeft.left;
				}
			}
			Node next = null;
			if (!stack.isEmpty())
				next = stack.peek();
			pop.next = next;
		} while (!stack.isEmpty());

	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n6;
		n3.right = n7;
		populate(n1);
	}

	private static class Node {
		int val;
		Node left, right, next;

		public Node(int val) {
			this.val = val;
		}
	}
}
