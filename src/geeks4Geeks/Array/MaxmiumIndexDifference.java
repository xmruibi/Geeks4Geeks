package geeks4Geeks.Array;

public class MaxmiumIndexDifference {

	// Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
	private static void maxIndexDiff(int[] arr) {
		int[] leftmin = new int[arr.length];
		int[] rightmax = new int[arr.length];
		// from left to right to get left min
		leftmin[0] = arr[0];
		for (int i = 1; i < arr.length; i++)
			leftmin[i] = Math.min(arr[i], leftmin[i - 1]);
		rightmax[rightmax.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--)
			rightmax[i] = Math.max(arr[i], rightmax[i + 1]);

		int l = 0, r = 0;
		int maxDiff = Integer.MIN_VALUE;
		while (l < arr.length && r < arr.length) {
			if (leftmin[l] < rightmax[r]) {
				maxDiff = Math.max(maxDiff, r-l);
				r++;
			}else
				l++;
		}
		System.out.println(maxDiff);
	}
	
	public static void main(String[] args) {
		int[] arr = {8,1,4,3,7,6,5};
		maxIndexDiff(arr);
	}
}
