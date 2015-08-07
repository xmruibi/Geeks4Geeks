package geeks4Geeks.Array;

public class MinDistOfTwoNumbers {

	private static int findMinDist(int[] arr, int x, int y) {
		int min_dist = arr.length;
		int prev = -1;
		int idx = 0;
		for (; idx < arr.length; idx++) {
			if (arr[idx] == x || arr[idx] == y) {
				prev = idx;
				break;
			}
		}
		if(idx>=arr.length)
			return -1;
		for (; idx < arr.length; idx++) {
			if (arr[idx] == x || arr[idx] == y) {
				if (arr[prev] != arr[idx] && idx - prev < min_dist)
					min_dist = idx - prev;
				prev = idx;
			}
		}
		return min_dist;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
		System.out.println(findMinDist(arr, 3, 6));
	}
}
