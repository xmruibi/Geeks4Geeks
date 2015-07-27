package geeks4Geeks.Array;

public class SumArray {
	public static int sum(int[] num, int idx) {
		if (idx == num.length)
			return 0;
		return num[idx] + sum(num, idx + 1);
	}

	public static int sum2(int[] num, int l, int r) {
		if (l > r)
			return 0;
		if (l == r)
			return num[l];
		int m = l + ((r - l) >> 1);
		int left = sum2(num, l, m);
		int right = sum2(num, m + 1, r);
		return left + right;
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 5, 6, 2, 4, 5, 7, 3, 4, 5, 7 };
		System.out.println(sum2(num, 0,num.length-1));
	}
}
