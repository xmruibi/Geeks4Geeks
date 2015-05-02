package geeks4Geeks.Array;

public class FindMinGapinArray {
	public static int findMinGap(int[] num) {
		if (num == null || num.length == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		/*************** Using bucket as sort tool ***************/
		for (int i = 0; i < num.length; i++) {
			min = Math.min(min, num[i]);
			max = Math.max(max, num[i]);
		}
		// set a bucket array with length of range
		int range = max - min;
		int[] bucket = new int[range + 1];
		for (int i = 0; i < num.length; i++)
			bucket[num[i] - min]++;
		// return to original array!!
		int idx = 0;
		for (int i = 0; i < bucket.length; i++)
			while (bucket[i] > 0) {
				num[idx++] = i;
				bucket[i]--;
			}
		/************ End of Sort! ************/
		int minGap = Integer.MAX_VALUE;
		for (int i = 1; i < num.length; i++)
			minGap = Math.min(minGap, num[i] - num[i - 1]);
		return minGap;
	}

	public static void main(String[] args) {
		int[] num = { 11, 22, 51, 72, 61, 81, 30, 6 };
		System.out.println(findMinGap(num));
	}
}
