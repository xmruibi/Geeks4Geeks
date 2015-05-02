package geeks4Geeks.Array;

public class FindDupsiUnsortedArray {
	private static void findDup(int[] num) {
		if (num == null || num.length == 0)
			return;
		for (int i = 0; i < num.length; i++) {
			int n = Math.abs(num[i]);
			if (num[n] >= 0)
				num[n] = -num[n];
			else
				System.out.println(Math.abs(num[i]));
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 1, 3, 6, 6 };
		findDup(num);
	}
}
