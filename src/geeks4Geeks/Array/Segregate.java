package geeks4Geeks.Array;

public class Segregate {

	private static void segregateArray(int[] arr) {
		int l = 0, r = arr.length - 1;
		while (l < r) {
			while (arr[l] % 2 == 0 && l < r)
				l++;
			while (arr[r] % 2 != 0 && l < r)
				r--;
			if (l < r) {
				int tmp = arr[l];
				arr[l] = arr[r];
				arr[r] = tmp;
				l++;
				r--;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {12, 34, 45, 9, 8, 90, 3 };
		segregateArray(arr);
		for (int i : arr)
			System.out.print(i + " ");
	}
}
