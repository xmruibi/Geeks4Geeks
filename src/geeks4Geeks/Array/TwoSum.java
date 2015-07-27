package geeks4Geeks.Array;

import java.util.Arrays;

public class TwoSum {
	private static int[] twoSum(int[] num, int target) {
		if (num == null || num.length == 0)
			return null;
		Arrays.sort(num);
		int l = 0, r = num.length - 1;
		while (l < r) {
			if (num[l] + num[r] == target)
				return new int[] { l, r };
			else if (num[l] + num[r] > target)
				r--;
			else
				l++;
		}
		return null;
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 4, 5, 3, 6, 9, 7, 8 };
		int[] res = twoSum(num, 17);
		System.out.println(res[0] + "  " + res[1]);
	}
}
