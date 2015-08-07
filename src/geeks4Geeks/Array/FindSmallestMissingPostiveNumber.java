package geeks4Geeks.Array;

public class FindSmallestMissingPostiveNumber {

	// first step move the neg number into left
	private static int segregate(int[] arr) {
		int negIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				int tmp = arr[negIdx];
				arr[negIdx++] = arr[i];
				arr[i] = tmp;
			}
		}
		return negIdx;
	}

	// second step
	private static int findMissing(int[] arr) {
		segregate(arr);
		for (int i = 0; i < arr.length; i++) {
			if (Math.abs(arr[i]) - 1 < arr.length
					&& arr[Math.abs(arr[i]) - 1] > 0)
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0)
				return i + 1;
		}
		return arr.length + 1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, -1, -2 };
		System.out.println(findMissing(arr));
	}

}
