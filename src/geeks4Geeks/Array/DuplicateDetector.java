package geeks4Geeks.Array;

public class DuplicateDetector {

	// Given an array of n elements which contains elements from 0 to n-1, with
	// any of these numbers appearing any number of times. Find these repeating
	// numbers in O(n) and using only constant memory space.

	private static void findDuplicate(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.println(Math.abs(arr[i]));
		}
	}

	// find missing and repeating number
	private static void method(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i]) - 1] >= 0)
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
			else
				System.out.print(" " + Math.abs(arr[i]));
		}
		System.out.println("\n");
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > 0)
				System.out.print(" " + (i + 1));
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 3 };
		method(arr);
	}
}
