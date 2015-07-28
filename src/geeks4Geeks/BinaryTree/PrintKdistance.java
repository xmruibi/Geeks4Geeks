package geeks4Geeks.BinaryTree;

import java.util.*;


public class PrintKdistance {
	List<Node> kDistanceNodes = new ArrayList<>();
	private void getKDistanceNode(Node root, int k) {
		if(root==null)
			return;
		if(k==0){
			kDistanceNodes.add(root);
			return;
		}
		getKDistanceNode(root.left, k-1);
		getKDistanceNode(root.right, k-1);
	}
	
	
	
	private static class Node {
		int val;
		Node left, right;

		public Node(int val) {
			this.val = val;
		}
	}
}
