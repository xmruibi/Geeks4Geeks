package geeks4Geeks.Array;

import java.util.Arrays;

public class CheckSubarray {

	// sort and find by binary search
	private static boolean checkSubarray(int[] array, int[] subarray) {
		Arrays.sort(array);
		for (int i : subarray)
			if (!binarySearch(i, array))
				return false;
		return true;
	}

	private static boolean binarySearch(int n, int[] array) {
		int l = 0, r = array.length - 1;
		while (l <= r) {
			int m = l + ((r - l) >> 1);
			if (array[m] == n)
				return true;
			if (array[m] < n)
				l = m + 1;
			else
				r = m - 1;
		}
		return false;
	}
	
	
	// sort and merge
	
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,4,5,6};
		int[] suba = {2,4,5};
		System.out.println(checkSubarray(arr, suba));
	}
}
