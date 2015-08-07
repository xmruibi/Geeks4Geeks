package geeks4Geeks.BinaryTree;

public class AVLTree {

	Node root;

	public AVLTree() {
		root = null;
	}

	public void insert(int i) {
		root = insert(i, root);
	}

	private Node insert(int val, Node root) {
		if (root == null)
			root = new Node(val);
		else if (root.val > val) {
			root.left = insert(val, root.left);
			if (getHeight(root.left) - getHeight(root.right) == 2)
				if (val < root.left.val)
					root = leftRotate(root);
				else
					root = doubleLeftRotate(root);
		} else if (root.val < val) {
			root.right = insert(val, root.right);
			if (getHeight(root.right) - getHeight(root.left) == 2)
				if (val > root.right.val)
					root = rightRotate(root);
				else
					root = doubleRightRotate(root);
		}
		root.height = Math.max(getHeight(root.left), getHeight(root.right));
		return root;
	}

	private Node leftRotate(Node node) {
		Node newRoot = node.left;
		node.left = newRoot.right; // keep the bst!
		newRoot.right = node;
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		newRoot.height = Math.max(node.height, getHeight(newRoot.left)) + 1;
		return newRoot;
	}

	private Node rightRotate(Node node) {
		Node newRoot = node.right;
		node.right = newRoot.left;
		newRoot.left = node;
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		newRoot.height = Math.max(node.height, getHeight(newRoot.right)) + 1;
		return newRoot;
	}

	private Node doubleLeftRotate(Node node) {
		node.left = rightRotate(node.left);
		return leftRotate(node);
	}

	private Node doubleRightRotate(Node node) {
		node.right = leftRotate(node.right);
		return rightRotate(node);
	}

	private int getHeight(Node node) {
		return node == null ? -1 : node.height;
	}

	public void inorderCheck() {
		inorder(this.root);
	}

	private void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.val);
		inorder(node.right);
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.insert(7);
		tree.insert(2);
		tree.insert(4);
		tree.insert(3);
		tree.insert(5);
		tree.insert(1);
		tree.insert(6);
		tree.inorderCheck();
	}
}

class Node {
	int val;
	int height;
	Node left, right;

	public Node(int val) {
		this.val = val;
		this.height = 0;
	}
}
