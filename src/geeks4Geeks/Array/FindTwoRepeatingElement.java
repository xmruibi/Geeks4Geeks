package geeks4Geeks.Array;

public class FindTwoRepeatingElement {

	private static void findTwoReaptingElem(int[] arr, int n) {
		int originSum = (1 + n) * n / 2;
		int originProduct = 1;
		for (int i = 1; i <= n; i++)
			originProduct *= arr[i];

		int actualSum = arr[0];
		int actualProduct = arr[0];
		for (int i = 1; i < arr.length; i++) {
			actualSum += arr[i];
			actualProduct *= arr[i];
		}
		actualSum = actualSum-originSum;
		// x+y =diff(actualSum, originaSum)
		// （x+y）^2 = (x^2+2xy+y^2) -> x^2+y^2 - 4xy = (x-y)^2
		int diff = (int) Math.sqrt(actualSum * actualSum - 4 * actualProduct);
		// x+y = actual sum; x-y = diff;
		int x = (actualSum + diff) / 2;
		int y = actualSum - x;
		System.out.println(x + "  " + y);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,4,3,5};
		findTwoReaptingElem(arr, 5);
	}
}
