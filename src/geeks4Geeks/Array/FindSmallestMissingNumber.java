package geeks4Geeks.Array;

import java.util.*;

public class FindSmallestMissingNumber {

	// sorted array
	private static int findSmallestMissnumber(int[] arr) {
		Arrays.sort(arr);
		return helper(arr, 0, arr.length - 1);
	}

	private static int helper(int[] arr, int l, int r) {
		if (l > r)
			return r + 1;
		if (l != arr[l])
			return l;
		int mid = l + ((r - l) >> 1);
		if (arr[mid] > mid) // missing number in left part
			return helper(arr, l, mid);
		else
			return helper(arr, mid + 1, r);
	}
	
	public static void main(String[] args) {
		int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
		System.out.println(findSmallestMissnumber(arr));
	}
}
