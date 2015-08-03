package geeks4Geeks.Array;

public class CountInversion {

	// Inversion Count for an array indicates – how far (or close) the array is
	// from being sorted. If array is already sorted then inversion count is 0.
	// If array is sorted in reverse order that inversion count is the maximum.
	// Formally speaking, two elements a[i] and a[j] form an inversion if a[i] >
	// a[j] and i < j

	private static int inversionCount(int[] arr, int[] tmp, int left, int right) {
		int mid, inv_cnt = 0;
		if (left >= right)
			return 0;

		mid = left + ((right - left) >> 1);
		inv_cnt = inversionCount(arr, tmp, left, mid);
		inv_cnt += inversionCount(arr, tmp, mid + 1, right);
		inv_cnt += divideConquer(arr, tmp, left, mid, right);

		return inv_cnt;
	}

	private static int divideConquer(int[] arr, int[] tmp, int left, int mid,
			int right) {
		int i = left, j = mid, k = left;
		int inversion_cnt = 0;
		while (i < mid && j <= right) {
			if (arr[i] <= arr[j])
				tmp[k++] = arr[i++];
			else {
				tmp[k++] = arr[j++];
				inversion_cnt = inversion_cnt + (mid - i);
			}
		}
		while (i < mid)
			tmp[k++] = arr[i++];
		while (j <= right)
			tmp[k++] = arr[j++];
		for (int idx = left; idx <= right; idx++)
			arr[idx] = tmp[idx];
		return inversion_cnt;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 1, 3, 5 };
		System.out.println(inversionCount(arr, new int[arr.length], 0,
				arr.length - 1));
	}
}
