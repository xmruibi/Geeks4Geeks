package geeks4Geeks.Array;

public class FindMaxAndSecondMax {
	private static int[] findMaxAndSecondMax(int[] num) {
		if (num == null || num.length == 0)
			return null;
		return helper(num, 0, num.length - 1);
	}

	private static int[] helper(int[] num, int l, int r) {
		if (l >= r)
			return new int[] { num[l], num[l] };
		if (l + 1 == r)
			return new int[] { Math.min(num[l], num[r]),
					Math.max(num[l], num[r]) };

		int m = l + ((r - l) >> 1);
		int[] resL = helper(num, l, m);
		int[] resR = helper(num, m + 1, r);
		int max, secondMax;
		if (resL[1] > resR[1]) {
			max = resL[1];
			if (resL[0] < resR[1])
				secondMax = resR[1];
			else
				secondMax = resL[0];
		} else {
			max = resR[1];
			if (resL[1] < resR[0])
				secondMax = resR[0];
			else
				secondMax = resL[1];
		}
		return new int[] { secondMax, max };
	}

	public static void main(String[] args) {
		int[] num = { 1, 4, 6, 2, 3, 10, 9, 12 };
		int[] res = findMaxAndSecondMax(num);
		System.out.println(res[0] + "    " + res[1]);
	}
}
