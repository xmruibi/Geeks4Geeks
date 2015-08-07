package geeks4Geeks.Array;

public class CountNumberOccurance {

	// idea is search range!
	private static void countOccur(int[] arr, int target) throws Exception {
		int left = getIndex(arr, target);
		//if (left >= arr.length || arr[left] != target)
			//throw new Exception("Error!");
		int right = getIndex(arr, target + 1) - 1;
		
		System.out.println(left + "  " + right);
		System.out.println(right - left + 1);
	}

	private static int getIndex(int[] arr, int target) {
		int l = 0, r = arr.length;
		while (l < r) {
			int mid = l + ((r - l) >> 1);
			if (arr[mid] < target)
				l = mid+1;
			else
				r = mid;
		}
		return l;
	}

	public static void main(String[] args) throws Exception {
		int[] arr = { 1, 1, 2, 2, 2, 2, 3 };
		countOccur(arr, 3);
	}
}
