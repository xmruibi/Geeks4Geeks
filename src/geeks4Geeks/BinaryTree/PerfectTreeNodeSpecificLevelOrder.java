package geeks4Geeks.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectTreeNodeSpecificLevelOrder {
	
	// Since the tree is perfect, it can be push every left and right nodes
	private void reconstruct(TreeNode root) {
		if(root==null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root.left);
		queue.offer(root.right);
		while(!queue.isEmpty()){
			TreeNode fst = queue.remove();
			TreeNode sec = queue.remove();
			
			System.out.print(fst.val+" "+sec.val+" ");
			
			queue.offer(fst.left);
			queue.offer(sec.right);
			queue.offer(fst.right);
			queue.offer(sec.left);
		}
	}
}
