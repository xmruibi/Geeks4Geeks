package geeks4Geeks.Array;

public class MaxSubarraySum {
	private int sum(int[] num) {
		if (num == null | num.length == 0)
			return 0;
		int max = num[0];
		for (int i = 1; i < num.length; i++) {
			if (num[i - 1] >= 0)
				num[i] += num[i - 1];
			max = Math.max(max, num[i]);
		}
		return max;
	}
	
	// Divide and conquer
	
	private void dc(int[] num) {
		
	}
	
	
}
