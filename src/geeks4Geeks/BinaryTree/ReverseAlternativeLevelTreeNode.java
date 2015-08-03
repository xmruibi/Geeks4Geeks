package geeks4Geeks.BinaryTree;


import java.util.*;

public class ReverseAlternativeLevelTreeNode {

   // reverse odd level	
	private static void findAlternativeNode(TreeNode root,  int lv, List<Integer> nodeVals) {
		if(root == null)
			return;
		findAlternativeNode(root.left, lv+1, nodeVals);
		if(lv%2!=0){
			nodeVals.add(root.val);
		}
		findAlternativeNode(root.right, lv+1, nodeVals);	
	}
	private static void reverseList(List<Integer> list) {
		int l = 0, r = list.size()-1;
		while(l<r){
			int tmp = list.get(l);
			list.set(l, list.get(r));
			list.set(r, tmp);
			l++;r--;
		}
	}
	private static void modifyNodes(TreeNode root,  int lv, List<Integer> nodeVals) {
		if(root==null)
			return;
		modifyNodes(root.left, lv+1,nodeVals);
		if(lv%2!=0)
			root.val = nodeVals.remove(0);
		
		modifyNodes(root.right, lv+1, nodeVals);
	}
	private static void printTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Character> row = new ArrayList<>();
		List<List<Character>> res = new ArrayList<>();
		queue.offer(root);
		int curLv = 1;
		int nxLv = 0;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.remove();
			curLv--;		
			if (cur == null)
				row.add('#');
			else {
				nxLv += 2;
				row.add((char) (cur.val + '0'));
				if (cur.left != null)
					queue.offer(cur.left);
				else
					queue.offer(null);
				if (cur.right != null)
					queue.offer(cur.right);
				else
					queue.offer(null);
			}

			if (curLv == 0) {
				curLv = nxLv;
				nxLv = 0;
				res.add(new ArrayList<Character>(row));
				row = new ArrayList<>();
			}
		}
		for (List<Character> crow : res) {
			for (Character c : crow)
				System.out.print(c + " ");
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n6;
		n5.right = n7;
		printTree(n1);
		List<Integer> list = new ArrayList<>();
		findAlternativeNode(n1, 0, list);
		reverseList(list);
		modifyNodes(n1, 0, list);
		printTree(n1);
	}
	
}
