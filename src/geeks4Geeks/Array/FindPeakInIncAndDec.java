package geeks4Geeks.Array;

public class FindPeakInIncAndDec {

	private static int findPeak(int[] arr) {
		int l = 0, r = arr.length - 1;
		while (l < r) {
			int m = l + ((r - l) >> 1);
			if ((l == r - 1) && (arr[l] >= arr[r]))
				return arr[l];
			if ((l == r - 1) && (arr[l] < arr[r]))
				return arr[r];
			if ((m == 0 || arr[m] > arr[m - 1])
					&& (arr[m] > arr[m + 1] || m == arr.length - 1))
				return arr[m];
			if (arr[m] <= arr[m - 1])
				r = m - 1;
			else
				l = m;
		}
		return l;
	}

	public static void main(String[] args) {
		int[] arr = { 120, 100, 80, 20, 0 };
		System.out.println(findPeak(arr));
	}
}
