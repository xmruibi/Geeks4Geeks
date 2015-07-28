package geeks4Geeks.BinaryTree;

public class FindDepthOfDeepestOddLevelLeafNode {

	static int maxDepth = 0;
	private static void findNode(int lv, Node node) {
		if(node==null)
			return;
		if(lv%2!=0&&node.left==null&&node.right==null){
			maxDepth = Math.max(maxDepth, lv);
			return;
		}
		findNode(lv+1, node.left);
		findNode(lv+1, node.right);	
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
		findNode(1, n1);
		System.out.println(maxDepth);
		}
	
	private static class Node {
		int val;
		Node left, right;

		public Node(int val) {
			this.val = val;
		}
	}
}
