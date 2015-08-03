package geeks4Geeks.BinaryTree;

import java.util.List;

public class FindNodeKDistanceFromGivenNode {

	private static void findKDistDown(TreeNode node, int k, List<TreeNode> res) {
		if(node==null||k<0)
			return;
		if(k==0){
			res.add(node);
			return;
		}
		findKDistDown(node.left, k-1, res);
		findKDistDown(node.right, k-1, res);
	}
	
	private static  int findKdistanceNodes(TreeNode root, TreeNode target, int k, List<TreeNode> res) {
		if(root==null)
			return -1;
		if(root==target){
			findKDistDown(root, k, res);
			return 0;
		}
		// check the left subtree
		int dl = findKdistanceNodes(root.left, target, k, res);
		if(dl!=-1){
			if(dl+1==k)
				res.add(root);
			else
				findKdistanceNodes(root.right, target, k - dl - 2, res); // minus two node positions
			return dl +1;
		}
		// check the right subtree
		int dr = findKdistanceNodes(root.right, target, k, res);
		if(dr!=1){
			if(dr+1==k)
				res.add(root);
			else
				findKdistanceNodes(root.left, target, k-dr-2, res);
			return dr+1;
		}
		return -1;
	}
}
