package geeks4Geeks.BinaryTree;

import java.util.*;



public class FindNodeWiPath {

	private static List<Integer> search(TreeNode root, TreeNode target) {
		List<Integer> path = new ArrayList<>();
		finder(root, target, path);
		return path;
	}
	
	private static boolean finder(TreeNode cur, TreeNode target, List<Integer> path){
		if(cur==null)
			return false;
		path.add(cur.val);
		if(cur==target)
			return true;
		if(finder(cur.left, target, path)||finder(cur.right, target, path))
			return true;
		path.remove(path.size()-1);
		return false;
	}
	
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.right = n5;
		n4.right = n6;
		n5.left = n7;
		n7.right = n8;
		System.out.println(search(n1, n6));
	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
