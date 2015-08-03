package geeks4Geeks.Array;

public class SearchElementPivotArray {

	private static void findAndPivot(int[] arr, int target) {
		int l = 0, r = arr.length - 1;
		int mid = -1;
		while (l <= r) {
			mid = l + ((r - l) >> 1);
			if (arr[mid] == target)
				break;
			if (arr[mid] > target)
				r = mid - 1;
			else
				l = mid + 1;
		}
		if (mid == -1)
			return;
		int pivot = arr[mid];
		System.out.println(pivot);
		int prev = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > pivot) {
				int tmp = arr[prev];
				arr[prev++] = arr[i];
				arr[i] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		findAndPivot(arr, 4);
		for(int i:arr)
			System.out.print(i+" ");
	}
}
