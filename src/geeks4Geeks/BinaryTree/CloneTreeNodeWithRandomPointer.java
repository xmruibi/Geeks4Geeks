package geeks4Geeks.BinaryTree;

import java.util.*;

public class CloneTreeNodeWithRandomPointer {

	// hashind Method
	private static void cloneTreeNodeOne(Node node, Map<Node, Node> map) {
		if (node == null)
			return;
		cloneTreeNodeOne(node.left, map);
		map.put(node, new Node(node));
		cloneTreeNodeOne(node.right, map);
	}

	private static Node construct(Node node, Map<Node, Node> map) {
		if (node == null)
			return node;
		Node curRoot = map.get(node);
		curRoot.left = construct(node.left, map);
		curRoot.right = construct(node.right, map);
		curRoot.random = map.get(node.random);
		return curRoot;
	}

	private static Node putToLeftChild(Node root) {
		if (root == null)
			return root;
		Node left = root.left;
		Node newRoot = new Node(root.val);
		root.left = newRoot;
		newRoot.right = root.right;
		if (left != null)
			newRoot.left = putToLeftChild(left);
		newRoot.right = putToLeftChild(root.right);
		return left;
	}

	private static void copyRandom(Node node, Node clone) {
		if(node==null)
			return;
		if(node.random!=null)
			clone.random = node.random.left;
		if(node.left.left!=null&&clone.left.left!=null)
			copyRandom(node.left.left, clone.left.left);
		copyRandom(node.right, clone.right);
	}

	private static void restoreNode(Node node, Node clone) {
		if(node==null)
			return;
		if(clone.left!=null){
			Node cloneLeft = clone.left.left;
			node.left = clone.left;
			clone.left = cloneLeft;
		}else
			node.left = null;
		restoreNode(node.left, clone.left);
		restoreNode(node.right, clone.right);
	}
	
	// copyMain function
	private static void mainCopy(Node root) {
		if(root==null)
			return;
		Node cloneRoot = putToLeftChild(root);
		copyRandom(root, cloneRoot);
		restoreNode(root, cloneRoot);
	}
	
	private static void print(Node node) {
		if (node == null)
			return;
		print(node.left);
		System.out.println(" Node:" + node.val + "   Random: "
				+ (node.random != null ? node.random.val : "null"));
		print(node.right);
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.left = n2;
		n1.right = n3;
		n1.random = n5;
		n2.left = n4;
		n2.random = n3;
		n3.right = n5;
		n3.random = n1;
		n4.random = n2;
		n5.random = n4;
		Map<Node, Node> map = new HashMap<>();
		cloneTreeNodeOne(n1, map);
		Node newNode = construct(n1, map);
		print(newNode);
	}

	private static class Node {
		int val;
		Node left, right, random;

		public Node(int val) {
			this.val = val;
		}

		public Node(Node node) {
			this.val = node.val;
		}
	}
}
