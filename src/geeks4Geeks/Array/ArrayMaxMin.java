package geeks4Geeks.Array;

public class ArrayMaxMin {

	private static int[] maxMin(int[] arr, int l, int r) {
		if (l == r)
			return new int[] { arr[l], arr[l] };
		else {
			int mid = l + ((r - l) >> 1);
			int[] r1 = maxMin(arr, l, mid);
			int[] r2 = maxMin(arr, mid + 1, r);
			return new int[] { Math.min(r1[0], r2[0]), Math.max(r1[1], r2[1]) };
		}
	}

	private static void getMaxMin(int[] arr) {
		int[] res = maxMin(arr, 0, arr.length - 1);
		System.out.println(res[0] + " " + res[1]);
	}

	public static void main(String[] args) {
		int[] arr = {2,1,4,9,-1,5};
		getMaxMin(arr);
	}
}
