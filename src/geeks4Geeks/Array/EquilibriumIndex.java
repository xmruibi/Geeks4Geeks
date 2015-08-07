package geeks4Geeks.Array;

public class EquilibriumIndex {

	// Equilibrium index of an array is an index such that the sum of elements
	// at lower indexes is equal to the sum of elements at higher indexes.
	
	private static int getEquilibriumIdx(int[] arr) {
		int sum = arr[0];
		for (int i = 1; i < arr.length; i++)
			sum += arr[i];
		int leftSum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum -= arr[i];
			leftSum += arr[i];
			if (leftSum == sum)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
		System.out.println(getEquilibriumIdx(arr));
	}
}
