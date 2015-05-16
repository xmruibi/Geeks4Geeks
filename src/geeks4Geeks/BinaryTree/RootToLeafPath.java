package geeks4Geeks.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {	
	private static List<List<Integer>> path(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(root, new ArrayList<Integer>(), res);
		return res;
	}
	
	private static void helper(TreeNode node,List<Integer> cur, List<List<Integer>>res){
		cur.add(node.val);
		if(node.left==null&&node.right==null){
			res.add(new ArrayList<Integer>(cur));
//			cur.remove(cur.size()-1);
		}else{
			if(node.left!=null)
				helper(node.left, cur, res);
			if(node.right!=null)
				helper(node.right,cur,res);
		}
		cur.remove(cur.size()-1);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		System.out.println(path(root));
	}
}
