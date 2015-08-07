package geeks4Geeks.Array;

public class FindFixedPoint {

	// fixed point in sorted array
	private static int findFixedPoint(int[] arr) {
		int l = 0, r = arr.length - 1;
		while (l < r) {
			int m = l + ((r - l) >> 1);
			if(arr[m]==m)
				return m;
			if(arr[m]<m)
				 l = m+1;
			else
				r = m - 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 2, 5, 8, 17};
		System.out.println(findFixedPoint(arr));
	}
}
