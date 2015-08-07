package geeks4Geeks.Array;

import java.util.*;

public class NextGreaterNumber {

	private static void getNGE(int[] arr) {
		if (arr.length == 0)
			return;
		List<int[]> res = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int elemIdx, next;
		for (int i = 1; i < arr.length; i++) {
			next = arr[i];
			elemIdx = stack.pop();
			while (arr[elemIdx] < arr[i]) {
				res.add(new int[] { arr[elemIdx], arr[i] });
				if (stack.isEmpty())
					break;
				elemIdx = stack.pop();
			}
			if (arr[elemIdx] > next)
				stack.push(elemIdx);
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			elemIdx = stack.pop();
			next = -1;
			res.add(new int[] { arr[elemIdx], -1 });
		}

		for (int[] cur : res)
			System.out.println(cur[0] + "  " + cur[1]);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 4, 5, 4, 3, 0 };
		getNGE(arr);
	}
}
