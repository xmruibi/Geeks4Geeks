package geeks4Geeks.Array;

public class FindSubarraySum {

	private static void findSubarraySum(int[] arr, int target) {
		int sum = 0;
		int prev = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			while (sum > target)
				sum -= arr[prev++];
			if (sum == target) {
				System.out.println(prev+" "+i);
				return;
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 20, 3, 10, 5};
		findSubarraySum(arr,33);
	}
}
