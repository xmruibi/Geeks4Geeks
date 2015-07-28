package geeks4Geeks.BinaryTree;

import java.util.*;

public class CheckCompleteTree {

	// iterative 
	private boolean iterativeWay(Node root) {
		boolean incomplete = false;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			Node cur = queue.remove();
			if(!incomplete&&(cur.left==null||cur.right==null)){
					incomplete = true;
			}else if(incomplete&&!(cur.left==null&&cur.right==null)){
				return false;
			}
			if(cur.left!=null)
				queue.offer(cur.left);
			if(cur.right!=null)
				queue.offer(cur.right);
		}
		return true;
	}
	
	private static class Node{
		int val;
		Node left, right;
		public Node(int val) {
			this.val = val;
		}
	}
}
